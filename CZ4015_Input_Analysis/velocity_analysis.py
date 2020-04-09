import pandas as pd
from scipy.stats import norm
import math
import seaborn as sns
import matplotlib.pyplot as plt

data = pd.read_excel("PCS_TEST_DETERMINSTIC_19S2.xls")
velocity = data["velocity (km/h)"]

mean = velocity.mean()
var = ((velocity-mean)**2).sum()/len(velocity)
deviation = math.sqrt(var)

a = [0]
p_j = 1/100
for i in range(1,100):
    a.append(norm.ppf(i*p_j, loc=mean, scale=deviation))
a.append(math.inf)

n = len(velocity)

chi_square_err = 0
for i in range(100):
    N_i = list(velocity.apply(lambda value: a[i]<=value<a[i+1])).count(True)
    chi_square_err += (N_i-n*p_j)**2/(n*p_j)

print(mean)             #120.07209801685764
print(var)              #81.3352710250803
print(chi_square_err)
sns.distplot(velocity)
plt.show()
