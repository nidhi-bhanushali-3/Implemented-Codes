import java.util.*;

class IEEE_floating_point 
{
  static int signBit=0; //defalut positive no so SignBit 0
  static int w[],f[],N[],B[],B_[],SPE[],DPE[],P[],pos1st1,pos_,e;
  
  public static void main(String[] args) {
    Scanner ob=new Scanner(System.in);
    System.out.print("\nENTER THE FLOATING POINT NO. = ");
    double n=ob.nextDouble();
    int i,j,k;  //assuming that n is positive so signBit=0  
    if(n<0)
    {
      signBit=1;
    }
    n=Math.abs(n);
    int x=((int)n); //int part of n
    double y=n-x;//floating point value of n
    w=binaryI(x); //binary of integer part
    f=binaryF(y); //binary of floating part  
    B=new int[w.length+f.length+1]; //entire binary no of n
    B_=B;
    display();
    ob.close();
  }
  
  public static int[] binaryI(int x) //for binary of int part
  {
    int bin[]=new int[11];//can handle 2^11 no
    int i=0;
    while(x!=0)
    {
      bin[i]=x%2;
      i++;
      x/=2;
    }
    /*for(i=9;i>=0;i--)
    {
    System.out.print(bin[i]);
    }*/
    System.out.println();
    return bin;
  }
  
  public static int[] binaryF(double y) //for binary of floating point
  {
    int bin[]=new int[32];
    int i=0,w=0;//whole no in binary
    double d=y;//floating no
    i=0;
    do
    {
      d=d*2;
      w=((int)d);
      bin[i]=w;
      d=d-w;
      ++i;
    }while(((d!=y) || (d!=0.00) )&& (i<=31));
    /*
    for(i=0;i<32;i++)
    {
    System.out.print(bin[i]);
    }
    */
     return bin;
  }
  
  public static int normalize(int b[])
  {
    int e=0;
    for(int i=0;i<b.length;i++)
    {
      if(b[i]==1)
      {
        pos1st1=i;
        break;
      }
    }
    System.out.println("\nAFTER NORMALIZATION");
    e=pos_-pos1st1;
    if(e>=0){
    for(int i=pos_+1;i>pos1st1+1;i--)
    {
      b[i]=b[i-1];
    }
    b[pos1st1+1]=9; //represents .
    }
    else{
      for(int i=pos_+1;i<pos1st1;i++)
    {
      b[i]=b[i+1];
    }
    b[pos1st1]=9;
    }
    for(int i=0;i<b.length;i++)
    {
      if(B[i]==1 || B[i]==0)
        System.out.print(B[i]+" ");
      else
        System.out.print(". ");
    }
    int j=-1;
    for(int i=b.length-1;i>=0;i--)
    {
      j++;
      if(b[i]==9)
      {
        break;
      }
    } //System.out.println(j);
    N=new int[j];
    j=0;
    for(int i=b.length-1;j<N.length;i--,j++)
    {
      N[j]=b[i];
      //System.out.print(N[j]+" ");
    }
    //System.out.println("\nN");
    return e;
  }
  
  public static int[] bias(int e)
  {
    int singlePE=(e+127),doublePE=(e+1023);
    int P[]=new int[2];
    P[0]=singlePE;
    P[1]=doublePE;
    return P;
  }
  
  public static void displayPrecision(int signBit,int PE[],int N[])
  {
    int i;
    System.out.print("\t | "+signBit+" | ");
    for(i=(PE.length-1);i>=0;i--)
    {
      System.out.print(PE[i]+" ");
    }
    System.out.print(" | ");
    for(i=(N.length-1);i>=0;i--)
    {
      System.out.print(N[i]+" ");
    }
  }
  
  public static void display()
  {
    int i,j,k;
    System.out.println(" SIGN BIT  = " +signBit);
    System.out.println("BINARY OF INTEGER PART");
    for(i=(w.length-1),j=0;i>=0;i--,j++)
    {
      B[j]=w[i];
      System.out.print(w[i]+" ");
    }
    B[j]=9;         //9 represents . in int[] B[]
    pos_=j-1;
    System.out.println("\nBINARY OF FLOATING PART");
    for(i=0,k=0;i<f.length;i++,k++)
    {
      B[j+k+1]=f[i];
      System.out.print(f[i]+" ");
    } 
    System.out.println("\nBINARY OF NUMBER");
    for(i=0;i<B.length;i++)
    {
      if(B[i]==1 || B[i]==0)
      System.out.print(B[i]+" ");
      else
      System.out.print(". ");
    } 
    e=normalize(B);
    System.out.print("\nN = ");
    for(j=N.length-1;j>=0;j--)
    {
    System.out.print(N[j]+" ");
    }
    System.out.println("\nE = "+e);
    P=bias(e);
    System.out.print("\nSINGLE PRECISION BINARY = \t"+(e+127)+" ");
    SPE=binaryI(P[0]);
    for(i=(SPE.length-1);i>=0;i--)
    {
      System.out.print(SPE[i]+" ");
    }
    System.out.print("\nDOUBLE PRECISION BINARY = \t"+(e+1023)+" ");
    DPE=binaryI(P[1]);
    for(i=(DPE.length-1);i>=0;i--)
    {
      System.out.print(DPE[i]+" ");
    }
    System.out.println("\n\n\t \t \t SINGLE PRECISION = 32 BITS\n");
    System.out.println("   | SIGN BIT| 8 BIT   BIASED EXPONENT|  23  BIT (FRACTION = N) \n");
    displayPrecision(signBit,SPE,N);

    System.out.println("\n\n\t \t \t DOUBLE PRECISION = 64 BITS\n");
    System.out.println("   | SIGN BIT| 11 BIT  BIASED EXPONENT|  52  BIT (FRACTION = N) \n");
    displayPrecision(signBit,DPE,N);
  }
}
