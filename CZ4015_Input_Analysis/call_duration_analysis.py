import pandas as pd
import math
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np

data = pd.read_excel("PCS_TEST_DETERMINSTIC_19S2.xls")
call_duration = data["Call duration (sec)"]

call_duration_minus_10 = []
for i in range (0, call_duration.shape[0]):
    call_duration_minus_10.append(call_duration[i] - 10)

call_duration_minus_10_series = pd.Series(call_duration_minus_10)
mean = call_duration.mean()

a = [0]
k = 100
p_j = 1/k
for i in range(1,k):
    a.append(mean * np.log(1/ (1 - i*p_j)))
a.append(math.inf)
n = len(call_duration)

chi_square_err = 0
for i in range(k):
    N_i = list(call_duration.apply(lambda value: a[i]<=value<a[i+1])).count(True)
    chi_square_err += (N_i-n*p_j)**2/(n*p_j)

print(mean)           
print(chi_square_err)
sns.distplot(call_duration)
plt.show()
