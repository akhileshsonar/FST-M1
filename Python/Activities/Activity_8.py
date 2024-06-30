list = list(input("Enter a list elements"))
print("Given list is ", list)
firstElement = list[0]
lastElement = list[-1]
if (firstElement == lastElement):
    print(True)
else:
    print(False)