import java.util.*;
class BoothsAlgo
{
  static int countBit=4;
	public static void main(String Arr[])
	{
		Scanner ob=new Scanner(System.in);
		int Q1=0,m1,q1,nBitM,nBitQ;
    int i,j,n,k;
    //Q1 = Q(-1) bit 
    //m1=decimal M
    //q1=decimal Q
		System.out.println("\nEnter the two nos");
    System.out.print("Enter M = ");
		m1=ob.nextInt();
    nBitM=countBit(m1);//noOfBitOF M
    System.out.print("Enter Q = ");
		q1=ob.nextInt();
    nBitQ=countBit(q1);//noOfBitOF M
    System.out.println("\n\n  A      Q\t\tQ(-1)");
    if(nBitM>=nBitQ && nBitM>=4){
      countBit=nBitM;
    }
    else if(nBitQ>=nBitM && nBitQ>=4){
      countBit=nBitM;
    }
    int A[]=new int[countBit];
		int m[]=new int[countBit];
		int m2[]=new int[countBit];
		int q[]=new int[countBit];
    for(i=0;i<countBit;i++)
    {
      A[i]=0;//initially A is 0000
    }
		decimal(m1,m);
		decimal(q1,q); 
		for(i=countBit;i>0;i--)
		{
			for(j=0;j<countBit;j++)
			{
				m2[j]=m[j];
			}
			if(q[countBit-1]==0 && Q1==1)
			{
        System.out.println("\t\t\t\t\t\tA <-- A+M");
				A=add(A,m2);
				display(A,q,Q1,m);
				System.out.println();
			}
			if((q[countBit-1]==1&&Q1==1)||(q[countBit-1]==0&&Q1==0))
			{
        //no A<-- A + M 
        //no A<-- A - M
      }
			if(q[countBit-1]==1 && Q1==0)
			{
				int c[]=complement2(m2);//taking 2's complement
        System.out.println("\t\t\t\t\t\tA <-- A-M");
				A=add(A,c);
				display(A,q,Q1,m);
				System.out.println();
			}
			Q1=q[countBit-1];
      System.out.println("\t\t\t\t\t\tRight Shift ");
			shift(A,q);
			display(A,q,Q1,m);
      System.out.println("\t\t\t\t\t\tCount--");
      System.out.println("\t-\t-\t-\t-\t-\t-");
			System.out.println();
		}
    ob.close();
	}
	static int countBit(int no)
  {
    int noBit=0,i,n1=no,r;
    while(n1!=0)
    {
      r=n1%2;
      noBit++;
      n1/=2;
    }
    return noBit;
  }
	static void decimal(int t,int m[])
	{
		int i=0,k=0,c=0,t1=t;
		int A[]=new int[100];
    while(t1!=0)
    {
      A[i]=t1%2;
      t1/=2;
      c++;
      i++;
    }
    /*
		for(i=0;i < countBit-1;i++,t=t/2)
		{
			A[i]=t%2; 
			c++;
		}*/
		for(int j=c,b=0;j >= 0;j--,b++)
			m[b]=A[j];
	}
	
	static void display(int A[],int q[],int Q1,int m[]) //display  A   Q   Q(-1)
	{
		for(int i=0;i < countBit;i++)
			System.out.print(A[i]);
		System.out.print("\t");
		for(int i=0;i < countBit;i++)
			System.out.print(q[i]);
		System.out.print(" \t");
		System.out.print(Q1);
		System.out.print("\t");
	}

	static int[] add(int A[],int m1[])//add()
	{
		int carry=0;
		int sum[]=new int[countBit];
		for(int i=countBit-1;i >= 0;i--)
		{
			sum[i]=(A[i]+m1[i]+carry)%2;
			carry=(A[i]+m1[i]+carry)/2;
		}
		return sum;
	}
	
	static int[] complement2(int m1[])//2s Complement() 
	{
    int i;
		int z[]=new int[countBit];
    for(i=0;i<countBit-1;i++)
    {
      z[i]=0;
    }
    z[countBit-1]=1;
		for( i=0;i<m1.length;i++)
		{
			if(m1[i]==0)
				m1[i]=1;
			else
				m1[i]=0;
		}
		int compliment2[]=add(m1,z);
		return compliment2;
	}
	static void shift(int A[],int q[])//shift()
	{
		int b=A[countBit-1];
    int i;
		for(i=countBit-2;i>=0;i--)
		{
			A[i+1]=A[i];
			q[i+1]=q[i]; 
		}
		q[0]=b;
	}
}
