try:
    print(x)
except NameError:
    print("x hasn't been defined yet.")
else:
  print("Nothing went wrong")
finally:
  print("Clean up code")