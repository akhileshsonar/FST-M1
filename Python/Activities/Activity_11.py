	
fruit_shop = {
    "apple": 1,
    "banana": 2,
    "orange": 3,
    "peaches": 4
}
 
key_to_check = input("What are you looking for? ").lower()
 
if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")