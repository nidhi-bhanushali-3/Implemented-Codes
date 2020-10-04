import java.util.*;

class Jagged_Array
{       
  public static void main(String[] args) {    //main()
    Scanner ob=new Scanner(System.in);
    System.out.println("");
    int n,i,j,k,m,SumRuns,MaxMatch=-1;
    System.out.print("Enter number of Player : ");
    n=ob.nextInt();
    int P[][]=new int[n][];//Jagged array of players & matches played by them
    double RunAvg[]=new double[n]; //1d array of players' avg
    System.out.println("");
    for(i=0;i<P.length;i++){
      System.out.println("Enter number of Matches Player " +(i+1)+" played : ");
      m=ob.nextInt();
      P[i]=new int[m];
      if(MaxMatch<m)
      {
        MaxMatch=m;
      }
    }//no of matches by player (i+1)
    System.out.println("");
    for(i=0;i<P.length;i++){
      SumRuns=0;
      for(j=0;j<P[i].length;j++){
        System.out.println("Enter Runs Scored in Match "+(j+1)+" by Player "+(i+1)+" : " );
        P[i][j]=ob.nextInt();
        SumRuns+=P[i][j];//sum of runs of player (j+1)
      }
      RunAvg[i]=((double)SumRuns/P[i].length); //avg of runs of player (j+1)
      System.out.println("");
    }
    System.out.println("");
    /*
    for(i=0;i<P.length;i++){
      System.out.println("\nRun Average of player " +(i+1)+" played : "+RunAvg[i]);
    }  //printing avg of player (i+1)
    */
    System.out.println("");
    System.out.print(" MATCH NO  |\t");   //printing Match
    for(i=0;i<MaxMatch;i++)
    {
      System.out.print((i+1)+"  |  ");    //printing |
    }
    System.out.println("  Average Runs |\n");   //Average of Player

    for (i=0;i<P.length;i++)
    {
      System.out.print("PLAYER  "+(i+1)+"  |\t");
      for(j=0;j<P[i].length;j++)
      {
        System.out.print(P[i][j]+"  |  "); //printing scores on score board
      }
      for(k=0;k<(MaxMatch-j);k++)
      {
        System.out.print("   |  "); //printing blanks on score board
      }
      System.out.println("  \t"+RunAvg[i]+"  \t|"); //Average of Player (i+1)
    }
    ob.close();
  } //main() ends
} //class ends
