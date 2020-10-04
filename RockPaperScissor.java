import java.util.*;
class RockPaperScissor
{
  public static Scanner ob=new Scanner(System.in);
  public static Random R=new Random();
  static String match[][];
  static String Win[];
  static int N[];
  
  public static void main(String[] args) {
    int userCh,ch,compCh,n,i,j;
    System.out.println("\n\t\t\tROCK-PAPER-SCISSOR GAME!");
    do{
      System.out.println("\n\tENTER \n\t1.TO PLAY \n\t0.EXIT");
      ch=ob.nextInt();
      switch(ch)
      {
        case 1:
        System.out.print("TO DECIDE WINNER WE NEED TO PLAY ODD MATCHES \n ENTER NO OF MATCHES YOU WANT TO PLAY : ");
        n=ob.nextInt();
        if(n%2==0){
          n++;
        }
        Win=new String[n];
        match=new String[n][2];
        N=new int[3];
        for(i=0;i<n;i++)
        {
          System.out.println("\n\t1.ROCK\n\t2.PAPER\n\t3.SCISSOR");
          System.out.print("\t\t\tENTER YOUR CHOICE : ");
          userCh=ob.nextInt();
          match[i][1]=choice(userCh); //1 is user

          compCh=(R.nextInt(3)+1);
          match[i][0]=choice(compCh); // 0 is Computer

          Win[i]=winner(userCh,compCh); //2 is TIE 
        }
        display(n);
        break;
        case 0:
        System.out.println("\t\t\tExiting...");
        break;
        default:
        break;
      }
    }while(ch!=0);
  }
  
  public static String winner(int U,int C)
  {
    if((U==1 && C==2)||(U==2 && C==3)||(U==3 && C==1))
    {
       N[0]++;//System.out.println("\t\tComputer");
      return "Computer";
    }
    else if((U==2 && C==1)||(U==3 && C==2)||(U==1 && C==3))
    {
       N[1]++;//System.out.println("\t\tUser");
      return "User";
    }else
    {
       N[2]++;//System.out.println("\t\tTIE");
      return "TIE";
    }
  }
  
  public static void display(int n)
  {
    int i;
    System.out.println("\t       \t      COMPUTER  \t|\t    USER    \t|\t    WINNER    \t\n");
    for(i=0;i<n;i++)
    {
      System.out.println("MATCH "+(i+1)+"   \t\t    "+match[i][0]+"    \t|\t    "+match[i][0]+"    \t|\t    "+Win[i]+"    \t");
    }
    System.out.println("\n\n\t\tUSER = "+N[1]+" \t\t COMPUTER = "+N[0]+"\t\tTIES = "+N[2]);
    if(N[1]>N[0])
    {
      System.out.println(" \t \t \t   CONGRATULATIONS YOU WON !!!");
    }
    else if(N[0]<N[1])
    {
      System.out.println(" \t \t \t   COMPUTER IS FINAL WINNER !!!");
    }
    else{
      System.out.println(" \t \t \t   FINAL TIE !!!");
    }
  }
  
  public static String choice(int ch)
  {
          if(ch==1)
          {
            return "ROCK"; //1 is ROCK
          }else if(ch==2)
          {
            return "PAPER"; //2 is PAPER
          }
          else if(ch==3)
          {
            return "SCISSOR"; //3 is SCISSOR
          }
      return "";
  }
}
