import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

filename = "No_Channel_Reservation.csv"
data = pd.read_csv(filename)
data.plot(
    x="Number of Calls",
    y="Blocked Rate",
    kind="line"
)
plt.show()