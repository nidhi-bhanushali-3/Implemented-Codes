import java.util.*;

class Prog1
{
  static double C=(3.142/180);
  public static void main(String[] args) {
    Scanner ob=new Scanner(System.in);
    double c,s,tan,cot,cosec,sec;
    System.out.println("ENTER VALUE FOR N = ");
    int n=ob.nextInt();
    System.out.println("ENTER VALUE FOR X = ");
    double X=ob.nextDouble();
    X*=C;
    int choice;
    do {
    System.out.println(" 1.sin \n 2.cos \n 3.tan \n 4.cot \n 5.cosec \n 6.sec\n 0.Exit");
    System.out.println("ENTER CHOICE FOR Function : ");
    choice=ob.nextInt();
    switch(choice)
    {
      case 1:
      s=Sin(X,n);
      System.out.println("\nsin = "+s);
      break;
      case 2:
      c=Cos(X,n);
      System.out.println("\ncos = "+c);
      break;
      case 3:
      s=Sin(X,n);
      c=Cos(X,n);
      tan=s/c;
      System.out.println("\ntan = "+tan);
      break;
      case 4:
      s=Sin(X,n);
      c=Cos(X,n);
      cot=c/s;
      System.out.println("\ncot = "+cot);
      break;
      case 5:
      s=Sin(X,n);
      cosec=1/s;
      System.out.println("\ncosec = "+cosec);
      break;
      case 6:
      c=Cos(X,n);
      sec=1/c;
      System.out.println("\nsec = "+sec);
      break;
      case 0:
      System.out.println("EXITING");
      break;
      default:
      System.out.println("Invalid Choice");
    }
  }while(choice!=0);
    ob.close();
  }
  public static double Sin(double X,int n)  // sin func
  {
    
    double s=0.0;
    int i,j=0;
    for(i=0;i<n;i++,j++)
    {
      s+=((MyMath.power(-1,j))*(MyMath.power((X),(2*i)+1)/MyMath.fact((2*i)+1)));
    }
    return s; //returning sin value
  }
  public static double Cos(double X,int n) //cos func
  {
    double c=0.0;
    int i,j=0;
    for(i=0;i<n;i++,j++)
    {
      c+=((MyMath.power(-1,j)*(MyMath.power(X,2*i))/MyMath.fact((2*i))));
    }
    return c;//returning cos value
  }
}
class MyMath{  //user defined MyMath class
  public static double power(double x,int y)
  {
    int i;
    long ans=1;
    if (y==0)
    {
      return 1.0;
    }
    else
    {
      return (1.0*x*power(x,y-1));
    }
    /* (i=1;i<=y;i++)
    {
      ans*=x;
    }*/
    //return ans;
  }
  public static long fact(int x) //factorial calculation
  {
    int i,j;
    long f=1;
    if (x==1 || x==0)
    {
      return 1;
    }
    else
    {
      return (x*fact(x-1));
    }
    /*
    for (i=1;i<=x;i++)
    {
      f*=i;
    }*/
    //return f;
  }
}
