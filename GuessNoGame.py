"""
Number Guessing Game
"""
import random

def game(u,l=1):
    upperLimit=(2**u)
    lowerLimit=1
    randNo=random.randint(lowerLimit,upperLimit)
    chances=u
    print("GUESSED NO BETWEEN {} {} WITH CHANCES = {}".format(lowerLimit,upperLimit,chances))
    no=int(input("\t\t\tENTER YOUR GUESSED NO : "))
    chances-=1
    Guessing(randNo,no,chances)

def Guessing(randNo,no,chances):
    if(chances>0):
        if(no==randNo):
            print("\t\t RIGHT GUESS IN {} TURNS !!!!!!".format(chances+1))
        elif(no<randNo):
            print("\t\tWRONG GUESS \t  TRY AGAIN \t\t {} MORE TURNS TO GO !".format(chances))
            print("\t\t\tYOUR NUMBER IS LESS THAN THE GUESSING NUMBER ")
            no=int(input("ENTER YOUR GUESSED NO... "))
            chances-=1
            Guessing(randNo,no,chances)
        elif(no>randNo):
            print("\t\tWRONG GUESS \t  TRY AGAIN \t\t {} MORE TURNS TO GO !".format(chances))
            print("\t\t\tYOUR NUMBER IS MORE THAN THE GUESSING NUMBER ")
            no=int(input("ENTER YOUR GUESSED NO... "))
            chances-=1
            Guessing(randNo,no,chances)
    else:
        print("\t\tYOU COULDN'T GUESS IN GIVEN CHANCES \t\t TRY AGAIN \t\t {} WAS THE NO TO BE GUESSED".format(randNo))
    task=int(input(("\t\t  DO U WANT TO PLAY THE GAME AGAIN ? ")))
    start()
    
def difficulty():
    print("1.EASY \n2.MEDIUM \n3.HARD ")
    level=int(input("ENTER YOUR DIFFICULTY LEVEL : "))
    if(level==1):
        r=random.randint(3,8) #random difficulty
        game(r)
    elif(level==2):
        r=random.randint(6,10) #random difficulty
        game(r)
    elif(level==3):
        r=random.randint(9,14) #random difficulty
        game(r)

def start():
    task=int(input("\n\n 1. PLAY GUESSING GAME \n 0. EXIT THE GAME \n"))
    if (task==1):
        difficulty()
    else :
        exit("\t\t\t\t\t\t GAME ENDED !")

start()
