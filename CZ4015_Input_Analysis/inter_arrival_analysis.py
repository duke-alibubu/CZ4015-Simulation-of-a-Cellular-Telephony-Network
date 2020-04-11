import pandas as pd
import math
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np

data = pd.read_excel("PCS_TEST_DETERMINSTIC_19S2.xls")
arrival_time = data["Arrival time (sec)"]
inter_arrival_time = []
for i in range (1, arrival_time.shape[0]):
    inter_arrival_time.append(arrival_time[i] - arrival_time[i-1])

inter_arrival_time_series = pd.Series(inter_arrival_time)

mean = inter_arrival_time_series.mean()
# var = ((velocity-mean)**2).sum()/len(velocity)
# deviation = math.sqrt(var)

a = [0]
k = 100
p_j = 1/k
for i in range(1,k):
    a.append(mean * np.log(1/ (1 - i*p_j)))
a.append(math.inf)
n = len(inter_arrival_time_series)

chi_square_err = 0
for i in range(k):
    N_i = list(inter_arrival_time_series.apply(lambda value: a[i]<=value<a[i+1])).count(True)
    chi_square_err += (N_i-n*p_j)**2/(n*p_j)

print(mean)           
print(chi_square_err)
sns.distplot(inter_arrival_time_series)
plt.show()
