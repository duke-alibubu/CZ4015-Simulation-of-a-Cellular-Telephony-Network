import pandas as pd
from scipy.stats import norm
import math
import seaborn as sns
import matplotlib.pyplot as plt

data = pd.read_excel("PCS_TEST_DETERMINSTIC_19S2.xls")
base_station = data["Base station "]

mean = base_station.mean()
k = 20

a = [0]
p_j = 1/k
for i in range(1,k):
    a.append(19*i*p_j + 1)
a.append(math.inf)

n = len(base_station)

chi_square_err = 0
for i in range(k):
    N_i = list(base_station.apply(lambda value: a[i]<=value<a[i+1])).count(True)
    chi_square_err += (N_i-n*p_j)**2/(n*p_j)
# for i in range(1,21):
#     percentage = list(base_station.apply(lambda value: value == i)).count(True)
#     print(percentage)

print(mean)     
print(chi_square_err)
sns.distplot(base_station)
plt.show()
