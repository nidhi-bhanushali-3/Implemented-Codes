import java.util.*;

public class MarksOutOfRangeException extends Exception
{
	public MarksOutOfRangeException(String exceptionMsg) 
  {
		super(exceptionMsg);
	}
	public String toString()
  {
		return "Marks Should be in range [0-100] .\n Please Enter correct Marks!";
	}
}

public class userExceptions
{
	public static Scanner ob = new Scanner(System.in);
	public static void main(String args[])
  {
		int marks;
		System.out.print("Enter the marks of the student	= ");
		marks=ob.nextInt();

		try
    {
			checkMarks(marks);
			/*
			if(marks<0 || marks>100)
      {
				throw new MarksOutOfRangeException("Marks Should be in range [0-100] .\nPlease Enter correct Marks!");
			}
      else
      {
				System.out.println("Marks entered successfully!");
			}
      */
		}
		catch(MarksOutOfRangeException e)
    {
			//e.printStackTrace();
			System.out.println(e);
		}

	}
	public static void checkMarks(int marks) throws MarksOutOfRangeException//this calling method must have throws...
  {
		if(marks<0 || marks>100)
    {
			throw new MarksOutOfRangeException("Marks Should be in range [0-100] .\n Please Enter correct Marks!");
		}
		else
    {
			System.out.println("Marks entered successfully!");
		}
	}
}



/*
User Defined Exception 
Write a program which accepts marks of a student (between 0 to 100) and checks whether it is within the range or not. If it is within the range then it displays “marks entered successfully”, if not then it throws the exception of user defined class “MarksOutOfRangeException”. The class should contain appropriate toString method to describe object the class with the out of range marks entered by the user.
*/
