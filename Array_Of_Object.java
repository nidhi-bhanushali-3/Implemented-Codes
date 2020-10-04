import java.util.*;
class Array_Of_Object
{
	static int n,i,j,no,delAccId,id,actualAcc,ch=-1;
	static String name;
	static double bal;
	public static Scanner ob=new Scanner(System.in);
	public static void main(String args[]){  //main()
			System.out.println("\t===> BANK <===");
			System.out.print("ENTER NO. OF ACCOUNTS : ");
			n=ob.nextInt();
			actualAcc=no;
			Account[] acc=new Account[n+15]; //creating array of object 
			for(i=0;i<n;i++){
			System.out.println("ID = "+ (i+1));
			id=(i+1);
			System.out.println("ENTER BALANCE");
			bal=ob.nextDouble();
			ob.nextLine();
			System.out.println("ENTER NAME");
			name=ob.nextLine();
			acc[i]=new Account(id,bal,name); //instantialting the acc[i] obj
			}
		do{
			System.out.println("1.ADD USERS");
			System.out.println("2.DELETE USER");
			System.out.println("3.DISPLAY USER");
			System.out.println("0.EXIT FROM HERE");
			System.out.print("ENTER OPERATION TO DO : ");
			ch=ob.nextInt();	
			switch(ch){
				case 1:{
					System.out.println("ENTER THE NO OF ACCOUNT TO ADD");
					no=ob.nextInt();
					actualAcc+=no;
					for(i=n;i<(n+no);i++)
						{
							System.out.println("ID = "+ (i+1));
							id=(i+1);
							System.out.println("ENTER BALANCE");
							bal=ob.nextDouble();
							ob.nextLine();
							System.out.println("ENTER NAME");
							name=ob.nextLine();
							acc[i]=new Account(id,bal,name);
						}
				}break;
				case 2:{
					System.out.print("ENTER THE ACC ID TO DELETE ");
					delAccId=ob.nextInt();
					for(i=0;i<(n+actualAcc);i++){
						if(acc[i].id==delAccId){
							for(j=i;j<(n+actualAcc-1);j++){
							acc[j]=acc[j+1]; //shifting the arr of obj values by 1 place
							}
							acc[n-1+actualAcc]=new Account(); //initializing to default values
						}break;
					}
					System.out.println("   \t  ID  \t  NAME   \t   BALANCE   ");
					for(i=0;i<(n+actualAcc);i++)
					{
						if((acc[i].id!=0) && (acc[i].id!=delAccId)){
							System.out.print("   \t  "+acc[i].id);
							System.out.print("\t  "+acc[i].name);
							System.out.println("\t\t "+acc[i].bal);}
					}
				}break;
				case 3:{  //displaing
					sort(acc); //sorting as ascending order of balance  //using call by reference
					System.out.println("   \t  ID  \t   NAME   \t   BALANCE   ");
					for(i=0;i<(n+actualAcc);i++){
						if((acc[i].id!=0) && (acc[i].id!=delAccId)) {
							System.out.print("   \t  "+acc[i].id);
							System.out.print("\t   "+acc[i].name);
							System.out.println("\t\t  "+acc[i].bal);
						}
					}
				} break;
				case 0:
				System.out.println("EXITING");
				break;
				default:
				System.out.println("Invalid choice");
			}
		}while(ch!=0);
		ob.close();
	} //  main() ends
	public static void sort(Account a[]) {//using pass by reference
		for(i=0;i<(n+actualAcc);i++) {
			for(j=0;j<(n+actualAcc-1);j++) {
				if(a[j].bal>a[j+1].bal) {
					Account t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
	}
} //class ends
class Account { //class Account to make obj of class
	int id;
	String name;
	double bal;
	Account(int id_,double bal_,String name_) { //parameterised constructor
		id=id_;
		name=name_;
		bal=bal_;
	}
	Account(){ //initailizing to default values
		id=0;
		name="";
		bal=0.0;
	}
}
