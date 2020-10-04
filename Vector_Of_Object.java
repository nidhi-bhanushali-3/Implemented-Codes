import java.util.*;
class Vector_Of_Object{
	public static Scanner ob=new Scanner(System.in);
	public static Vector<Employee> E=new Vector<Employee>(); //vector of data type Employee
	public static Enumeration<Employee> e;//=E.elements();
	public static int eID;
	public static String eName;
	public static double eSal;
	public static void main(String args[]){
		int i,j,n,ch,pos;
		String name;int id;
		do{
			System.out.println("1.CREATE");
			System.out.println("2.INSERT");
			System.out.println("3.DELETE (E-Name)");
			System.out.println("4.DELETE (E-Id)");
			System.out.println("5.DISPLAY");
			System.out.println("0.EXITING");
			System.out.print("ENTER CHOICE : ");
			ch=ob.nextInt();
			switch(ch)
			{
				case 1:
					System.out.print("ENTER NO OF REC TO ADD = ");
					n=ob.nextInt();
					for(i=0;i<n;i++)
						create();  //calling create( ) n times to add obj at E
					sort();
					display();
				break;
				case 2:
					System.out.println("ENTER THE LOCATION(POSITION/INDEX) AT WHICH REC IS TO BE ADDED : ");
					pos=ob.nextInt();
					insert(pos); //calling insert () at pos(index)
					System.out.println("AFTER INSERTING REC AT "+pos +" : ");
					display(); //before sorting
					sort();
					System.out.println("AFTER SORTING BY SALARY : \n");
					display(); //after sorting
				break;
				case 3:
					System.out.println("ENTER THE NAME OF REC TO DELETE : ");
					ob.nextLine();
					name=ob.nextLine();
					deleteByEName(name); //delete by EName
					sort();
					display();
				break;
				case 4:	
					System.out.println("ENTER THE ID OF REC TO DELETE : ");
					id=ob.nextInt();
					deleteByEId(id);  //delete by EID
					sort();
					display();
				break;
				case 5:
					display();
				break;
				case 0:
					System.out.println("EXITING");
				break;
				default:
					System.out.println("INVALID CHOICE");
			}
		}while(ch!=0);
		//System.out.println(" ");
		ob.close();
	}
	public static void create()//create() add elements to E Vector
	{
		System.out.print("ENTER EMPLOYEE DETAILS \n");
		System.out.print(" ID : "); 
		eID=ob.nextInt();
		ob.nextLine();
		System.out.print(" NAME : ");
		eName=ob.nextLine();
		System.out.print(" SALARY : ");
		eSal=ob.nextDouble();
		Employee e1=new Employee(eName,eID,eSal); //creating object by parameterised constructor
		E.add(e1); //adding object
	}
	public static void insert(int pos) //insert() at given index
	{   
		System.out.print("ENTER EMPLOYEE DETAILS \n");
		System.out.print(" ID : "); 
		eID=ob.nextInt();
		ob.nextLine();
		System.out.print(" NAME : ");
		eName=ob.nextLine();
		System.out.print(" SALARY : ");
		eSal=ob.nextDouble();
		Employee e1=new Employee(eName,eID,eSal); //creating object by parameterised constructor
		E.insertElementAt(e1,pos); //insert obj at pos(index)
	}
	public static void deleteByEName(String name)//deleteByEName()
	{
		/*for(Employee e_:E)
		{
			if(e_.eName.equalsIgnoreCase(name)==true)
			{
				//E.remove(e_);
				E.removeElement(e_);
			}
		}*//* 
		for(Employee e_:E)
						{
						if(e_.eName.equalsIgnoreCase(name))
						{
							//E.remove(e_);
							E.removeElement(e_);
						}
						}
		*/
		/*for(int i=0;i<E.size();i++)
		{
			if(E.get(i).eName.equalsIgnoreCase(name)) //to compare 2Strings
			{
				E.removeElementAt(i);//E.removeElementAt () to remove element by index
			}
		}*/ //approach 1
		/*
			for( i=0;i<E.size();i++)
		{
			if(E.get(i).eName.equals(name))// && (E.get(i).eID==id)) //to compare 2Strings n then delete && if id r same
			{
				c++;
				E.remove(E.get(i)); //to remove the obj
				//E.removeElementAt () to remove element by index
				//E.remove(i);
			}
		} //approach 2
		*/
		int c=0,i;
		for( i=0;i<E.size();i++)
		{
			if(E.get(i).eName.equals(name))// && (E.get(i).eID==id)) //to compare 2Strings n then delete && if id r same
			{
				c++;
				//E.remove(E.get(i)); //to remove the obj
				//E.removeElementAt () to remove element by index
				//E.remove(i);
			}
		}
		
		if(c>1)
		{
		System.out.println("ENTER THE ID OF REC TO DELETE : ");
		id=ob.nextInt();
		for( i=0;i<E.size();i++)
		{
			if((E.get(i).eID==id)&&E.get(i).eName.equalsIgnoreCase(name))
			{
				E.removeElementAt(i);//E.removeElementAt () to remove element by index
			}
		}
		}
		else{
			for( i=0;i<E.size();i++)
			{
			if(E.get(i).eName.equalsIgnoreCase(name))
			{
				E.removeElementAt(i);//E.removeElementAt () to remove element by index
			}
			}
		}
	}
	public static void deleteByEId(int id)//deleteByEId()
	{
		/*for(Employee e_:E)
		{
			if(e_.eID==id)
			{
				//E.remove(e_);
				E.removeElement(e_);
			}
		}*//* 
		for(Employee e_:E)
					{
					if(e_.eID==id)
					{
					E.removeElement(e_);
					}
					}
		*/
		int c=0,i;
		//int size=E.size();
		for(i=0;i<E.size();i++)
		{
			if((E.get(i).eID==id)) 
			{
				c++; //counter //E.removeElementAt(i);//E.removeElementAt () to remove element by index
			}
		}
		if(c>1)
		{
		System.out.println("ENTER THE NAME OF REC TO DELETE : ");
		ob.nextLine();
		String name_=ob.nextLine();
		for( i=0;i<E.size();i++)
		{
			if((E.get(i).eID==id)&&E.get(i).eName.equalsIgnoreCase(name_))
			{
				E.removeElementAt(i);//E.removeElementAt () to remove element by index
			}
		}
		}
		else{
			for( i=0;i<E.size();i++)
			{
			if((E.get(i).eID==id))
			{
				E.removeElementAt(i);//E.removeElementAt () to remove element by index
			}
			}
		}
	}
	public static void display()//display()
	{
		System.out.println("\t\t\t> EMPLOYEES LIST <");
		System.out.println("\t\t ID "+ "\t NAME "+"\t SALARY  ");
		Employee e_;//Employee obj  //=new Employee(); //create obj as we have list/vector of Employee obj so we need obj to be refered & compare
		e=E.elements(); //added this as currently we have to update the enumeration e
		while(e.hasMoreElements()) //checking if more elements are there in enum
		{
			e_=e.nextElement();//Enum e method nextElement() //we generally print e.nextElement by here it is object of Employee so we assign to other obj as we want to print the data members
			System.out.println("\t\t "+e_.eID +"\t "+e_.eName+"\t "+e_.eSal);  //printing data_members
			//System.out.println(e.nextElement());
		}
		/*System.out.println("\t\t\tEMPLOYEES ARE");
		System.out.println("\t ID "+""+ "\t NAME "+""+"\t SALARY  "+"");
		for(Employee e_:E)
		{
			System.out.println("\t "+e_.eID+ "\t "+e_.eName+"\t "+e_.eSal);
		}*/
	}
	public static void sort()//sort()
	{
		Employee eT;
		int i,j;
		for(i=0;i<E.size();i++)
		{
			for(j=0;j<(E.size()-i-1);j++)
			{
				if(E.get(j).eSal>E.get(j+1).eSal) //sorting by Salary
				{
					eT=E.get(j); //to get object of Employee at j
					E.set(j,E.get(j+1)); //set object at j+1 at j
					E.set(j+1,eT);  //set object at j using eT
				}
				else if(E.get(j).eSal==E.get(j+1).eSal)//if Salary is equal
				{
					if(E.get(j).eID>E.get(j+1).eID)//sortig by id
					{
						eT=E.get(j); //to get object of Employee at j
						E.set(j,E.get(j+1)); //set object at j+1 at j
						E.set(j+1,eT);  //set object at j using eT
					}
				}
			}
		}
	}
}
class Employee{
	String eName;
	int eID;
	double eSal;
	Employee(String EName,int EID,double ESal)//parameterized constructor
	{
		eName=EName;
		eID=EID;
		eSal=ESal;
	}
	Employee() //default constructor
	{
		eName="";
		eID=0;
		eSal=0.0;
	}
}
/*

Create a class Employee which stores E-Name, E-Id and E-Salary of an Employee. Use class Vector to maintain an array of Employee with respect to  the E-Salary.Provide the following functions
1) Create (): this function will accept the n Employee records in any order and will arrange them in the sorted order.
2) Insert (): to insert the given Employee record at appropriate index in the vector depending upon the E-Salary.
3) delete ByE-name( ): to accept the name of the Employee  and delete the record having given name
4) deleteByE-Id ( ): to accept the Id of the Employee  and delete the record having given E-Id.

*/
