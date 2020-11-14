package Engineering;    //user-defined package Engineering;
import Engineering.*;   //user-defined package Engineering class are imported;
import java.util.*;

public class Marks {        
    public static Scanner ob;
    public static Vector<Student> S = new Vector<Student>();    //Vector of Student
    public static Enumeration<Student> ES=S.elements();         //Enumeration of Student
    public static void display()           // displaying the student DETAILS
    {
        System.out.println(" STUDENT DETAILS ");
        System.out.println("NAME \t \t \t ROLL NO \t \t \t ENGLISH \t \t \t MATHS \t \t \t SCIENCE \t \t \t TOTAL ");
        ES=S.elements();                    //enumeration
        Student s1;             //reference of Student
        while(ES.hasMoreElements())         // displaying the student DETAILS till there are elements
        {
            s1= ES.nextElement();
            System.out.print(s1.name + " \t \t \t ");
            System.out.print(s1.rollNo+ "   \t  \t\t\t ");
            System.out.print(s1.engMarks+ "  \t \t\t\t  ");
            System.out.print(s1.mathsMarks+ " \t  \t   \t\t  ");
            System.out.print(s1.scienceMarks+ "  \t  \t  \t\t  ");
            System.out.println(s1.totalMarks+ " \t  \t  \t  ");
        }
    }
    public static void sort()      // sorting by ascending order of marks
    {
        int i,j;
        for(i=0;i<S.size();i++)
        {
            for(j=0;j<(S.size()-i-1);j++)
            {
                if((S.elementAt(j).totalMarks)>(S.elementAt(j+1).totalMarks))
                { 
                    Student tS = S.elementAt(j);
                    S.setElementAt(S.elementAt(j+1), j);
                    S.setElementAt(tS, j+1);
                }
            }
        } //bubble sort()
        display();
    }
    public static void input()      // taking input from user 
    {
        String n;
        int eM,mM,sM,totalM;
        int r;
        ob = new Scanner(System.in);
        Student s;
        int ch;
        do{
            System.out.println(" 1. ENTER THE DETAILS OF STUDENT \n 2. DISPLAY \n 3. SORT \n 0. EXIT");
            System.out.print(" ENTER THE CHOICE ");
            ch=ob.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.print(" ENTER THE NAME ");           ob.nextLine();
                    n=ob.nextLine();
                    System.out.print(" ENTER THE ROLL NO ");
                    r=ob.nextInt();
                    System.out.print(" ENTER THE ENG MARKS ");
                    eM = ob.nextInt();
                    System.out.print(" ENTER THE MATHS MARKS ");
                    mM = ob.nextInt();
                    System.out.print(" ENTER THE SCIENCE MARKS ");
                    sM = ob.nextInt();
                    System.out.println("");
                    s = new Student(n,r,eM,mM,sM); //obj creation 
                    S.addElement(s); //adding to Vector
                break;
                case 2:
                    display();      // display() called
                break;
                case 3:
                    sort();         //sort() called
                break;
                case 0:
                    System.out.println(" EXITING ");
                    System.exit(0);
                break;
                default:
                    System.out.println(" INVALID CHOICE ");
                break;
            }
        }
        while(ch!=0);
    }
}
