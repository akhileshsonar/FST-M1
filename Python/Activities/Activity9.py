print("Enter a list with , saparated")
list1 = list(input("Enter a list elements for list 1 ").split(","))
list2 = list(input("Enter a list elements for list 2 ").split(","))
print("Print both lists")
print("List 1 ",list1)
print("List 2 ",list2)
list3=[]
for ele in list1:
    if (int(ele) % 2 !=0) :
        print("Added odd no ",ele)
        list3.append(ele)
for ele in list2:
    if (int(ele) % 2==0) :
        print("Added even odd no ",ele)
        list3.append(ele)

print("list 3")
print(list3)
