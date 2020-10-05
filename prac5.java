import java.util.*;
			// hear we have consider time as 1 month and formula is given in program
class prac5{
	public static Scanner ob = new Scanner(System.in);
	public static void main(String args[]){
		double r1,r2;
		String name,add;
		long no,phoneNo;
		double bal;

		System.out.print("Enter NAME = " ); 					name=ob.nextLine();
		System.out.print("\nEnter ACC NO = ");					no=ob.nextLong();
		System.out.print("\nEnter ACC PHONE NO = "); 			phoneNo=ob.nextLong();		ob.nextLine();
		System.out.print("\nEnter ACC ADD = ");  				add=ob.nextLine();
		System.out.print("\nEnter ACC BAL = ");					bal=ob.nextDouble();

		System.out.println("\tEnter Interest-Rate for Saving Account ");			r1=ob.nextDouble();
		Saving_Account SA=new Saving_Account(r1,name,add,bal,phoneNo,no);
		SA.accountHolder();
		bal=SA.calc_int();
	
		System.out.println("\tEnter Interest-Rate for Current Account ");      	r2=ob.nextDouble();
		Current_Account CA=new Current_Account(r2,name,add,bal,phoneNo,no);
		CA.accountHolder();
		bal=CA.calc_int();
		ob.close();
		//System.out.println("");
	}
}
class Account{
	String AccName,AccAddress;
	double AccBalance;
	long AccPhoneNo,AccNo;
	Account(String AccName,String AccAddress,double AccBalance,long AccPhoneNo,long AccNo)
	{
		this.AccAddress=AccAddress;
		this.AccBalance=AccBalance;
		this.AccName=AccName;
		this.AccPhoneNo=AccPhoneNo;
		this.AccNo=AccNo;
	}
	public void accountHolder()
	{
		System.out.println("NAME = " + AccName);
		System.out.println("ACC NO = "+AccNo);
		System.out.println("ACC PHONE NO = "+AccPhoneNo);
		System.out.println("ACC ADD = "+AccAddress);
		System.out.println("ACC BAL = "+AccBalance);
		//System.out.println("");
		//System.out.println("");
	}
}
class Saving_Account extends Account{
	double rate;
	Saving_Account(double rate,String AccName,String AccAddress,double AccBalance,long AccPhoneNo,long AccNo){
		super(AccName, AccAddress, AccBalance, AccPhoneNo, AccNo);
		//super();
		this.rate=rate;
	}
	public double calc_int(){
		//super(AccName, AccAddress, AccBalance, AccPhoneNo, AccNo);
		//Saving_Account();
		AccBalance-=AccBalance*rate*0.01;
		accountHolder();
		return AccBalance;
	}
}
class Current_Account extends Account{
	double rate;
	Current_Account(double rate,String AccName,String AccAddress,double AccBalance,long AccPhoneNo,long AccNo){
		super(AccName, AccAddress, AccBalance, AccPhoneNo, AccNo);
		//super();
		this.rate=rate;
	}
	public double calc_int(){
		//Current_Account();
		AccBalance-=AccBalance*rate*0.01;
		accountHolder();
		return AccBalance;
	}
}
