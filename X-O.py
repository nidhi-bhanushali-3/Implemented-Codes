import random

gameBoardPosition={1:1,2:1,3:1,4:1,5:1,6:1,7:1,8:1,9:1}
winningPairs=[[1,2,3],[4,5,6],[7,8,9],[1,4,7],[2,5,8],[3,6,9],[1,5,9],[3,5,7]]
player1=[]      #0 = player1_id = O = Computer 
player2=[]      #1 = player2_id = X = Player
players=[]
game_board={'Player1':player1,'Player2':player2}

class XnO():
    #gameBoardPosition={1:1,2:1,3:1,4:1,5:1,6:1,7:1,8:1,9:1}
    #winningPairs=[[1,2,3],[4,5,6],[7,8,9],[1,4,7],[2,5,8],[3,6,9],[1,5,9],[3,5,7]]
    #player1=[]      #0 = player1_id = O = Computer 
    #player2=[]      #1 = player2_id = X = Player
    #players=[]
    #game_board={'Player1':player1,'Player2':player2}

    def __init__(self):
        self.gameBoardPosition={1:1,2:1,3:1,4:1,5:1,6:1,7:1,8:1,9:1}
        self.winningPairs=[[1,2,3],[4,5,6],[7,8,9],[1,4,7],[2,5,8],[3,6,9],[1,5,9],[3,5,7]]
        self.player1=[]      #0 = player1_id = O = Computer 
        self.player2=[]      #1 = player2_id = X = Player
        self.players=[]
        self.game_board={'Player1':player1,'Player2':player2}

    def _play(self,playerId):
        allFilled=0
        print("\n\t\t\t\t\t\t[ COMPUTER = O ]\n\t\t\t\t\t\t[ PLAYER = X ]\n")
        self.wastedChoice=0
        i=playerId
        while(i<9+i+self.wastedChoice and allFilled<=9):
            if (i%2==0 and allFilled<10):
                print("COMPUTER's POSITION (in [1-9]) WHERE IT WANTS O TO BE  = ")
                pos=random.randint(1,9)
                if (pos in self.gameBoardPosition and self.gameBoardPosition[pos]==1 and allFilled<10):
                    self.gameBoardPosition[pos]-=1
                    self.player1.append(pos)
                    self.game_board['Player1']=tuple(self.player1) #Computer
                    allFilled+=1
                    self.players=self.player1+self.player2
                    self.display(self.players,self.game_board)
                    self.win=self.checkWin(self.player1,0)
                    if(self.win==1):
                        print("\n\t \t \t CONGRATULATIONS TO COMPUTER !! IT WON !!!")
                        break
                else:
                    print("\n \t \t \t !! WRONG PLACE COMPUTER THIS IS ALREADY FILLED !!")
                    i-=1
                    allFilled+=1    #wastedChoice+=1
            elif (i%2==1 and allFilled<10):
                pos=int(input("ENTER POSITION (in [1-9]) WHERE YOU WANT X TO BE  = "))
                if (pos in self.gameBoardPosition and self.gameBoardPosition[pos]==1 and allFilled<10):
                    self.gameBoardPosition[pos]-=1
                    self.player2.append(pos)
                    self.game_board['Player2']=tuple(self.player2)
                    allFilled+=1
                    self.players=self.player1+self.player2
                    self.display(self.players,self.game_board)
                    self.win=self.checkWin(self.player2,1)
                    if(self.win==1):
                        print("\n\t \t \t CONGRATULATION PLAYER !! YOU WIN !!!")
                        break
                else:
                    print("\n \t \t \t !! WRONG PLACE PLAYER THIS IS ALREADY FILLED !!")
                    i-=1 
                    allFilled+=1   #wastedChoice+=1
            else:
                break
            i+=1
            #allFilled+=1
        self.win1=self.checkWin(self.player1,0)
        self.win2=self.checkWin(self.player2,1)
        if(self.win1==self.win2):
            print("\n\t \t \t ITS A TIE !!!")
            print("\n\t \t \t  ~~~ GAME ENDS ~~~")
        playGame=int(input("\t   DO YOU WANT TO PLAY ? ([ 1 = YES  &  0 = NO ])\t\t PLAY = "))
        playerNo=int(input("\t   DO YOU WANT TO PLAY MULTIPLAYER OR SINGLE ? ([ 1 = Multi  &  0 = Single ])\t\t Number = "))
        self.__init__()
        self.x_o(playGame,playerNo)  #starts if 1 stops if 0
        # 1 is MultiPlayer 0 is SinglePlayer

    def play(self,playerId):
        allFilled=0
        print("\n\t\t\t\t\t\t[ PLAYER-1 = O ]\n\t\t\t\t\t\t[ PLAYER-2 = X ]\n")
        self.wastedChoice=0
        i=playerId
        while(i<9+i+self.wastedChoice):
            if (i%2==0 and allFilled<10):
                pos=int(input("ENTER POSITION (in [1-9]) WHERE YOU WANT O TO BE  = "))
                if (pos in self.gameBoardPosition and self.gameBoardPosition[pos]==1 and allFilled<10):
                    self.gameBoardPosition[pos]-=1
                    self.player1.append(pos)
                    self.game_board['Player1']=tuple(self.player1)
                    allFilled+=1
                    self.players=self.player1+self.player2
                    self.display(self.players,self.game_board)
                    self.win=self.checkWin(self.player1,0)
                    if(self.win==1):
                        print("\n\t \t \t CONGRATULATION PLAYER 1 !! YOU WIN !!!")
                        break
                else:
                    print("\n \t \t \t !! WRONG PLACE PLAYER 1 THIS IS ALREADY FILLED !!")
                    i-=1    #wastedChoice+=1
            elif (i%2==1 and allFilled<10):
                pos=int(input("ENTER POSITION (in [1-9]) WHERE YOU WANT X TO BE  = "))
                if (pos in self.gameBoardPosition and self.gameBoardPosition[pos]==1 and allFilled<10):
                    self.gameBoardPosition[pos]-=1
                    self.player2.append(pos)
                    self.game_board['Player2']=tuple(self.player2)
                    allFilled+=1
                    self.players=self.player1+self.player2
                    self.display(self.players,self.game_board)
                    self.win=self.checkWin(self.player2,1)
                    if(self.win==1):
                        print("\n\t \t \t CONGRATULATION PLAYER 2 !! YOU WIN !!!")
                        break
                else:
                    print("\n \t \t \t !! WRONG PLACE PLAYER 2 THIS IS ALREADY FILLED !!")
                    i-=1    #wastedChoice+=1
            else:
                break        
            i+=1
        win1=self.checkWin(self.player1,0)
        win2=self.checkWin(self.player2,1)
        if(win1==win2):
            print("\n\t \t \t ITS A TIE !!!")
            print("\n\t \t \t  ~~~ GAME ENDS ~~~")
        playGame=int(input("\t   DO YOU WANT TO PLAY ? ([ 1 = YES  &  0 = NO ])\t\t PLAY = "))
        playerNo=int(input("\t   DO YOU WANT TO PLAY MULTIPLAYER OR SINGLE ? ([ 1 = Multi  &  0 = Single ])\t\t Number = "))
        self.__init__()
        self.x_o(playGame,playerNo)  #starts if 1 stops if 0
        # 1 is MultiPlayer 0 is SinglePlayer


    def display(self,players,game_board):
        self.gameBoard=[[' ',' ',' '],[' ',' ',' '],[' ',' ',' ']]
        self.players.sort()
        for player in self.players:
            if (player>=1 and player<=3):
                player_=player-1
                if(player in (self.game_board['Player1'])):
                    self.gameBoard[0][player_]='O'
                elif (player in (self.game_board['Player2'])):
                    self.gameBoard[0][player_]='X'
                else:
                    self.gameBoard[0][player_]=' '
            elif(player>=4 and player<=6):
                player_=player-4
                if(player in (self.game_board['Player1'])):
                    self.gameBoard[1][player_]='O'
                elif (player in (self.game_board['Player2'])):
                    self.gameBoard[1][player_]='X'
                else:
                    self.gameBoard[1][player_]=' '
            elif(player>=7 and player<=9):
                player_=player-7
                if(player in (self.game_board['Player1'])):
                    self.gameBoard[2][player_]='O'
                elif (player in (self.game_board['Player2'])):
                    self.gameBoard[2][player_]='X'
                else:
                    self.gameBoard[2][player_]=' '
        print("\n\t\t\t\t\t\t-------------")
        for i in range(0,3):
            print("\t\t\t\t\t\t| {} | {} | {} |".format(self.gameBoard[i][0],self.gameBoard[i][1],self.gameBoard[i][2]))
            print("\t\t\t\t\t\t-------------")

    def checkWin(self,playerWinCheck,playerId):
        playerWinCheck.sort()
        self.flag=None
        for winningPair in self.winningPairs:
            for wP_ in winningPair:
                if (wP_ in playerWinCheck):
                    self.flag=True
                    continue
                else:
                    self.flag=False
                    break
            if (self.flag==True and playerId==0):
                return 1    #print("\t \t \t CONGRATULATION PLAYER 1 !! YOU WIN !!!")
            elif (self.flag==True and playerId==1):
                return 1    #print("\t \t \t CONGRATULATION PLAYER 2 !! YOU WIN !!!")
            elif(self.flag==True and playerId==0 and playerId==1):
                return 0    #print("\t \t \t ITS A TIE !!!")
            #else:
                #return 0
                #print("\t \t \t ITS A TIE !!!")
                #pass
        if (self.flag != True):
            return 0    #print("\t \t \t ITS A TIE !!!")

    def x_o(self,play_,playerNo):
        if(play_==0):
            print("\t\t\tEXITING...")
            exit()
            #return ""
        elif(play_!=0 and (playerNo>=1)):
            gameBoardPosition=self.gameBoardPosition_={1:1,2:1,3:1,4:1,5:1,6:1,7:1,8:1,9:1}
            player1=self.player1_=[]      #0 = player1_id = O
            player2=self.player2_=[]      #1 = player2_id = X
            players=self.player_=[]
            game_board={'Player1':player1,'Player2':player2}
            self.randomPlayer=random.randint(0,1)
            if(self.randomPlayer==0):    
                self.play(0)         #player1 starts
            elif(self.randomPlayer==1):  
                self.play(1)        #player2 starts
        elif(play_!=0 and (playerNo==0)):
            gameBoardPosition=self.gameBoardPosition_={1:1,2:1,3:1,4:1,5:1,6:1,7:1,8:1,9:1}
            player1=self.player1_=[]      #0 = player1_id = O
            player2=self.player2_=[]      #1 = player2_id = X
            players=self.player_=[]
            game_board={'Player1':player1,'Player2':player2}
            self.randomPlayer=random.randint(0,1)
            if(self.randomPlayer==0):    
                self._play(0)         #player1 starts
            elif(self.randomPlayer==1):  
                self._play(1)        #player2 starts



print("\n\t \t \t \t \t \t [ X - & - O ]\n")
playGame=int(input("\t   DO YOU WANT TO PLAY ? ([ 1 = YES  &  0 = NO ])\t\t PLAY = "))
playerNo=int(input("\t   DO YOU WANT TO PLAY MULTIPLAYER OR SINGLE ? ([ 1 = Multi  &  0 = Single ])\t\t Number = "))
PLAY=[]
while(playGame):
    xo=XnO()
    xo.x_o(playGame,playerNo)
