class prac1
{
   public static void main(String a1[])
   {
      int n,i,j,k,ct=0,a,b,c;
      
      out:
         for (i=1;ct<10;i++)
         {
         mid:
            for (j=i+1;j<50;j++)
            {
              in:
                  for (k=j+1;k<50;k++)
                  {
                     if (ct==10)
                        break out;
                     else
                     {
                        a=i*i;
                        b=j*j;
                        c=k*k;
                        if((a+b)==c)
                        {
                           System.out.println(i+" "+j+" "+k);
                           ct++;
                        }
                     }
                  }
            }
         }
   }
}
