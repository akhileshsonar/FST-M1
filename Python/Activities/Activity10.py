
print("Enter a list with , saparated")
number = list(input("Enter a list elements for list 1 ").split(","))
print("elements are ",number)
 
print("Elements that are divisible by 5:")
for no in number:
    if (int(no) % 5 == 0):
        print("Numbers are "+no)
    else:
        print("No number divided by 5 "+no)