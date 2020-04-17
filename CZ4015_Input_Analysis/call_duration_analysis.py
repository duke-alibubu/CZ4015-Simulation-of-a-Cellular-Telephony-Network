import pandas as pd
import math
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np

data = pd.read_excel("PCS_TEST_DETERMINSTIC_19S2.xls")
call_duration = data["Call duration (sec)"]

min = call_duration.min()    #10.003951603252272

call_duration_minus_min = []
for i in range (0, call_duration.shape[0]):
    call_duration_minus_min.append(call_duration[i] - min)

call_duration_minus_min_series = pd.Series(call_duration_minus_min)
mean = call_duration_minus_min_series.mean()

a = [0]
k = 100
p_j = 1/k
for i in range(1,k):
    a.append(mean * np.log(1/ (1 - i*p_j)))
a.append(math.inf)
n = len(call_duration_minus_min_series)

chi_square_err = 0
for i in range(k):
    N_i = list(call_duration_minus_min_series.apply(lambda value: a[i]<=value<a[i+1])).count(True)
    chi_square_err += (N_i-n*p_j)**2/(n*p_j)

print(mean)           
print(chi_square_err)
sns.distplot(call_duration_minus_min_series)
plt.show()
