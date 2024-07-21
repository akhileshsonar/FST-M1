
import pandas

data = {
  "Usernames": ["admin", "test1", "test1"],
  "Passwords": ["password", "test2", "test2"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)

dataframe.to_csv("test.csv", index=False)