import java.util.*;
class Main
{
public static void main (String A[])
{
int a,b;
int gcd1,lcm1,gcd2,lcm2;  // for same class
int gcd1_,lcm1_,gcd2_,lcm2_;  // for 2 different class

Scanner ob=new Scanner (System.in);

System.out.println("Enter 1st Num = ");
a=Math.abs(ob.nextInt());

System.out.println("Enter 2nd Num = ");
b=Math.abs(ob.nextInt());

// in same class
Main e=new Main();
gcd1=e.GCD_same(a,b);  //non static gcd
lcm1=e.LCM_same(a,b); //non static lcm

gcd2=GCD_sameS(a,b); //static gcd
lcm2=LCM_sameS(a,b); // static lcm


//in different class
GCD_LCM g_l = new GCD_LCM();
gcd1_=g_l.GCD(a,b);   //non static gcd
lcm1_=g_l.LCM(a,b);  //non static lcm

gcd2_=GCD_LCM.GCD_(a,b);  //static gcd
lcm2_=GCD_LCM.LCM_(a,b); //static lcm

System.out.println("==> WITH IN SAME CLASS (NON STATIC) ");
System.out.println(" GCD = " + gcd1 +"\n LCM = "+lcm1);

System.out.println("==> WITH IN IN SAME CLASS (STATIC) ");
System.out.println(" GCD = " + gcd2+"\n LCM = "+lcm2);

System.out.println("==> IN DIFFERENT CLASS (NON STATIC) ");
System.out.println(" GCD = " + gcd1_+"\n LCM = "+lcm1_ );

System.out.println("==> IN DIFFERENT CLASS (STATIC) ");
System.out.println(" GCD = " + gcd2_ +"\n LCM = "+lcm2_ );

ob.close();
}

int GCD_same(int a,int b)   // GCD() non static
{
   if (a==0 || b==0)
	  {
		return (Math.max(a,b));
	  }
        else 
	  {
		a=Math.abs(a);
		b=Math.abs(b);
		if(a!=0)
		{
		  return GCD_same(b%a,a);
		}
		else   
                { 
		  return b;
		}
	  }	
}
int LCM_same(int a,int b)  //LCM()  non static
{
  //Main e1=new Main();
  return (Math.abs(a)*Math.abs(b)/GCD_same(a,b));
}


static int GCD_sameS(int a,int b)  //GCD()  static
	{
	  if (a==0 || b==0)
	  {
		return (Math.max(a,b));
	  }
        else 
	  {
		a=Math.abs(a);
		b=Math.abs(b);
		if(a!=0)
		{
		  return GCD_sameS(b%a,a);
		}
		else   
                { 
		  return b;
		}
	  }	
	}
static int LCM_sameS(int a,int b)   //LCM()    static
	{
	  return (Math.abs(a)*Math.abs(b)/GCD_sameS(a,b));
	}
}


class GCD_LCM //class GCD_LCM
{
	public static int GCD_(int a,int b)  //GCD()  static
	{
	  if (a==0 || b==0)
	  {
		return (Math.max(a,b));
	  }
        else 
	  {
		a=Math.abs(a);
		b=Math.abs(b);
		if(a!=0)
		{
		  return GCD_(b%a,a);
		}
		else   
                { 
		  return b;
		}
	  }	
	}
	public static int LCM_(int a,int b)   //LCM()    static
	{
	  return (Math.abs(a)*Math.abs(b)/GCD_(a,b));
	}

	public int GCD(int a,int b)  //GCD()    non static
	{
	  if (a==0 || b==0)
	  {
		return (Math.max(a,b));
	  }
        else 
	  {
		a=Math.abs(a);
		b=Math.abs(b);
		if(a!=0)
		{
		  return GCD(b%a,a);
		}
		else   
                { 
		  return b;
		}
	  }	
	}
  
	public int LCM(int a,int b)    //LCM()   non static
	{
	  return (Math.abs(a)*Math.abs(b)/GCD(a,b));
	}
}
