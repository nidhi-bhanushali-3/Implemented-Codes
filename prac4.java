import java.util.*;

class prac4
{
  public static void main(String args[]){
  
    Scanner ob=new Scanner(System.in);
    Vector<String> v=new Vector<String>();
    Enumeration e=v.elements();
    int i,j,n;
    
    v.add("Apple");//1. add() to add new elements to list
    v.add("Banana");//1. add() to add new elements to list
    v.add("Cherry");//1. add() to add new elements to list
    e=v.elements();//2.  v.elements() to give all the elements to enumeration 
    
    System.out.println("CAPACITY OF VECTOR = "+v.capacity()); //3. capacity() returns the current capacity of the Vector.
    System.out.println("SIZE OF VECTOR = "+v.size()); //4.size() returns the current size of the vector
    while(e.hasMoreElements()){
      System.out.println(e.nextElement());
    }
    
    System.out.println("\nEnter index at which object you want to find");
    System.out.println(v.elementAt(ob.nextInt())+"\n"); //5. elementsAt() particular index
    v.set(1, "Mangoes"); //6.set() to set the object at given location to given Object
    e=v.elements();//2.  v.elements() to give all the elements to enumeration e
    while(e.hasMoreElements())
    {
      System.out.println(e.nextElement());
    }
    System.out.print("Enter an item to delete which is in the shopping list : ");
    ob.nextLine();
    String del=ob.nextLine();
    v.remove(del); //7. remove() to remove the given object from vector
    
    e=v.elements();//2.  v.elements() to give all the elements to enumeration e
    while(e.hasMoreElements()){
      System.out.println(e.nextElement());
    }
    
    System.out.print("\nEnter an item to add at any postion (Give position) & Item  : ");
    String into=ob.nextLine();
    int p=ob.nextInt();
    v.insertElementAt(into,p);//8. insertElementAt() inserts the given object at given location
    e=v.elements();//2.  v.elements() to give all the elements to enumeration e
    
    while(e.hasMoreElements()){
      System.out.println(e.nextElement());
    }
    System.out.println("First Element is "+v.firstElement()); //9. firstElement() to return 1st element of vector
    System.out.println("First Element is "+v.lastElement());   //10. lastElement() to return last element of vector
    System.out.println("Enter index at which object you want to find");
    System.out.println(v.get(ob.nextInt())); //11. get() to get object at index given
    
    System.out.println("\nEnter an item to add at last Index : ");
    ob.nextLine();
    String atEnd=ob.nextLine();
    v.add(atEnd);//1.  add() to add new elements to list
    
    e=v.elements();  //2.  v.elements() to give all the elements to enumeration e
    while(e.hasMoreElements()){
      System.out.println(e.nextElement());
    }
    ob.close();
  }
}
