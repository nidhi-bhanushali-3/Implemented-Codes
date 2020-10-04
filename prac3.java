import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner ob=new Scanner(System.in);
    int max,max2,split1,split2,i,j,n;
    int p=-1;//pos of max element
    System.out.println("Enter no of element in array ");
    n=ob.nextInt();
    int a[]=new int[n];
    int b[]=new int[n+1];
    
    System.out.println("Enter elements in array ");
    max=0;
    max2=-1;
    for(i=0;i<n;i++)
    {
      a[i]=ob.nextInt();
      if(max<a[i])
      {
        max=a[i];
        p=i;//index of max element
      }
    }
    for(i=0;i<n;i++)
    {
      if(max2<a[i] && a[i]<max)
      {
        max2=a[i];
      }
    }
    split1=max2;
    split2=max-max2;
    
    for(i=0,j=0;i<n && j<n+1;i++,j++)
    {

      if(i==p)
      {
        b[j]=split1;
        j++;
        b[j]=split2;
        continue;
      }
      else{
        b[j]=a[i];
        }
    }
    System.out.println("New array is :");
    for(i=0;i<n+1;i++)
    {
      System.out.print(" \t"+b[i]);
    }
    ob.close();
    
  }
}
