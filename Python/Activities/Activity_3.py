user1 = input("user1 ")
user2 = input("user1 ")

user1_answer = input(user1 + "Your choise ").lower()
user2_answer = input(user2 + ",Your choise ").lower()

if user1_answer == user2_answer:
    print("It's a tie")
elif user1_answer == 'rock':
    if user2_answer == 'scissors':
        print("Rock wins")
    else:
        print("Paper win")
elif user1_answer == 'scissors':
    if user2_answer == 'paper':
        print("Scissors win")
    else:
        print("Rock win")
elif user1_answer == 'paper':
    if user2_answer == 'rock':
        print("Paper wins")
    else:
        print("Scissors win")
else:
    print("better luck next time")