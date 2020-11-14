package Engineering;            //user-defined package Engineering;
import java.util.*;

public class Student {          //student class
    String name;                //details of student 
    int rollNo;                 //details of student
    int engMarks,mathsMarks,scienceMarks,totalMarks;        //marks of student
    public static Scanner ob;
    Student(String name,int rollNo,int engMarks,int mathsMarks,int scienceMarks)        //parameterized constructor
    {
        this.engMarks=engMarks;
        this.mathsMarks=mathsMarks;
        this.scienceMarks=scienceMarks;
        this.name=name;
        this.rollNo=rollNo;
        this.totalMarks=(this.engMarks+this.mathsMarks+this.scienceMarks);              //this = current object  
    }
}

/*
 
Create a Package Engineering which has two classes as Student and Marks. Accept (n) student detail like roll no, Subject name, Student name, calculate total marks  
in the class Student Write display () method to display details and sort () method to sort the students records as per increasing order of the total marks. 
The function sort must be statically defined to invoke it without referring any object. Both the functions write in the Marks class.
Create a main class which will use package and calculate total marks and display all the records of the student in the increasing order of the their total marks


 */