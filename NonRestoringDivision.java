import java.util.*;

class NonRestoringDivision {  //nonRestoringDivision

  public static void main(String[] args) {
    Scanner ob=new Scanner(System.in);
    int m,q,i,j,k,R,Q_;
    System.out.print("Enter M (Divisor) = ");
    m=ob.nextInt();
    System.out.print("Enter Q (Dividend) = ");
    q=ob.nextInt();
    int M[]=binary(m);
    int Q[]=binary(q);
    int M_[]=complement2(M); 
    int A[]=new int[M.length];
    System.out.print("M = \t");
    for(i=(M.length-1);i>=0;i--)    {
      System.out.print(M[i]+" ");
    }
    System.out.print("\t\t   -- M = \t");
    for(i=(M.length-1);i>=0;i--)    {
      System.out.print(M_[i]+" ");
    }
    System.out.print("\nQ = \t");
    for(i=(Q.length-1);i>=0;i--)    {
      System.out.print(Q[i]+" ");
    }
    System.out.print("\t\t     A = \t");
    for(i=(M.length-1);i>=0;i--)    {
      System.out.print(A[i]+" ");
    }System.out.println("\n   A\t\t Q      \t    \t    \t    STEP");
    display(A, Q);System.out.print("\t \t \t Initial");
    System.out.println("\n\t---\t---\t---\t---\t---\t---");
    for(i=Q.length-1;i>=0;i--){
      if(A[A.length-1]==1)
      {
        shift(A,Q);
        display(A,Q);
        System.out.println("\t \t \t Left Shift");//Left Shifting
        A=add(A,M);
        display(A,Q);
        System.out.println("\t \t \t A <-- A + M");
      }else if(A[A.length-1]==0){
        shift(A,Q);
        display(A,Q);
        System.out.println("\t \t \t Left Shift");//Left Shifting
        A=add(A,M_);
        display(A,Q);
        System.out.println("\t \t \t A <-- A - M");//A <-- A - M
      }
      if(A[Q.length-1]==1){  //Set Q0 = 0 
      Q[0]=0;
      display(A,Q);
      System.out.println("\t \t \t Set Q0 = 0 ");
      }else if(A[Q.length-1]==0){ //set Q0=1 
      Q[0]=1;
      display(A,Q);
      System.out.println("\t \t \t Set Q0 = 1 ");
      } System.out.println("\t---\t---\t---\t---\t---\t---");
    }
    if(A[A.length-1]==1){  //A[A.length-1]==1 then A <-- A + M
      A=add(A,M);
      display(A,Q);
      System.out.println("\t \t \t  A <-- A + M");
      System.out.println("\t---\t---\t---\t---\t---\t---");
    }
    R=decimal(A);Q_=decimal(Q);
    System.out.println("\tREMAINDER = "+R+"\tQUOTIENT = "+Q_);
    ob.close();
  }
  public static void display(int a[],int[] q) {//display A,Q
    for(int i=a.length-1;i>=0;i--)  {
      System.out.print(a[i]+" ");
    }System.out.print("\t");
    for(int i=q.length-1;i>=0;i--) {
      if(q[i]==9){  //to print _
        System.out.print("_ ");
      }else if(q[i]==0 ||q[i]==1){
      System.out.print(q[i]+" ");
      }
    }
  }
  public static int[] binary(int n) { //decimal to binary
    int bin[]=new int[5];
    int i=0,j;
    while(n!=0){
      bin[i]=n%2;
      n/=2;
      i++;
    }return bin;
  }
  static int decimal(int n[]) { //binary to decimal
    int D=0,i;
    for(i=0;i<n.length;i++) {
       D+=(n[i]*((int)Math.pow(2,i)));
    }return D;
  }
  public static int[] complement2(int n[]) {  //2s Complement
    int i,j,k;
    int c[]=new int[n.length],z[]=new int[n.length];
    for(i=0;i<c.length;i++){
      z[i]=0;
      if(n[i]==1){
        c[i]=0;
      }else{
        c[i]=1; 
      }
    }z[0]=1;
    int c2[]=add(c,z);
    return c2;
  }
  public static int[] add(int A[],int m1[])  {  //add() 
		int carry=0;
		int sum[]=new int[5];
		for(int i=0;i<5;i++){
			sum[i]=(A[i]+m1[i]+carry)%2;
			carry=(A[i]+m1[i]+carry)/2;
		}return sum;
	}
  public static void shift(int A[],int q[]) { //shift() left shift
		int i,b=q[(A.length-1)];  //  b=Q[A.length-1]
		for(i=A.length-1;i>0;i--){
			A[i]=A[i-1];
			q[i]=q[i-1]; 
		}
		A[0]=b;  //A[0]=b
    q[0]=9; //replacement for _ in Q0
    /*
    System.out.println("\nA");
    for(i=A.length-1;i>=0;i--)
    {
      System.out.print(A[i]+" ");
    }
    System.out.println("Q");
    for(i=A.length-1;i>=0;i--)
    {
      System.out.print(q[i]+" ");
    }
    */
	}
}
