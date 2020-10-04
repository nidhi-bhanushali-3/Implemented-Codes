import java.util.*;

class prac2
{
	public static void main(String args[]){
		Scanner ob=new Scanner(System.in);
		Vector<String> v=new Vector<String>();
		int i,j,n;
    
		for(i=0;i<args.length;i++)
		{
			v.add(args[i]);
		}
		System.out.println("Enter an item to delete which is in the shopping list ");
		String del=ob.nextLine();
		v.remove(del);
		System.out.println("Enter an item to add at any postion (Give position) & Item");
		String into=ob.nextLine();
		int p=ob.nextInt();
		v.add(p,into);
		System.out.println("Enter an item to add at last Index");
		String atEnd=ob.nextLine();
		v.add(atEnd);
		Enumeration e=v.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
		//Vector<String> v=new Vector<String>();
		System.out.println("");
		ob.close();
	}
}
