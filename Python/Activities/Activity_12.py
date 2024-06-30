
def calculateSum(num):
  if num:
    print(num-1)
    return num + calculateSum(num-1)
  else:
    return 0


res = calculateSum(10)

print(res)