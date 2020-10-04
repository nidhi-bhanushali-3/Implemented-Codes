#include <stdio.h>
#include <string.h>
#include <stdlib.h>
typedef struct bank{
int acc_no;
int adhar_no;
double balance;
}Bank;
Bank B[10];
double intr[10];
void bank_func(Bank b[10]);
void create_acc(Bank b[10]);
double check_bal(int);
void withdrawl(double w,int an);
void deposit(double d,int an);
double calc(int an);
int main() 
{ int i,j,n,go;
do{
bank_func(B);
printf("DO U WANT TO CONTINUE? 1. YES  0. NO\n ");
scanf("%d",&go);
}while(go);
  return 0;
  for(i=0;i<10;i++)
  printf("THE ACC=[%d] HAS AADHAR NO= %d  BALANCE = RS % lf ",i+1,B[i].adhar_no,B[i].balance);
}//main ends

void bank_func(Bank b[10])
{
 int i,j,n,ch,an; double bal1[10],amt,in,w1,d1;
  do{
  here:
  printf(" WELCOME TO BANK \n");
  printf(" 1. CREATE ACCOUNT\n");
  printf(" 2. CHECK BALANCE \n");
  printf(" 3. WITHDRAWL AMOUNT FROM ACCOUNT\n");
  printf(" 4. DEPOSIT AMOUNT TO ACCOUNT\n");
  printf(" 5. CALCULATE INTEREST \n");
  printf(" ENTER CHOICE  BETWEEN 1-5\n");
  scanf("%d",&ch);
  switch(ch)
  {
   case 1:
   create_acc(B);
   break;
   case 2:
    printf("ENTER THE ACCOUNT NO WHOSE BALANCE IS TO BE CHECKED\n");
    scanf("%d",&an);
    bal1[an-1]=check_bal(an);

   break;
   case 3:
   printf("ENTER THE ACCOUNT NO TO WITHDRAW \n");
   scanf("%d",&an);
   printf("ENTER THE AMOUNT TO WITHDRAW\n");
   scanf("%lf",&amt);
    withdrawl(amt,an);
    printf("THE ACC NO %d HAS %lf BALANCE & INTEREST =%lf",an,B[an-1].balance,intr[an-1]);
   break;
   case 4:
   printf("ENTER THE ACCOUNT NO TO DEPOSIT \n");
   scanf("%d",&an);
   printf("ENTER THE AMOUNT TO DEPOSIT\n");
   scanf("%lf",&amt);
   deposit(amt,an);
   printf("THE ACC NO %d HAS %lf BALANCE & INTEREST =%lf",an,B[an-1].balance,intr[an-1]);
   break;
   case 5:
    printf("ENTER THE ACCOUNT NO TO SEE INTEREST\n");
   scanf("%d",&an);
   in=calc(an);
   printf("THE ACC NO %d HAS %lf BALANCE & INTEREST =%lf",an,B[an-1].balance,intr[an-1]);
   break;

   case 0:
   printf("Exiting!");
   break;
   default:
   printf("ENTER VALID CHOICE");goto here;
   break;
  }//switch ends
  }while(ch!=0);
}
void create_acc(Bank b[10])
{ int j,ans,n1;
 static int i=0;
 printf(" ENTER NO OF ACCOUNTS TO BE CREATED\n");
 scanf("%d",&n1);
 if(n1<=10){
 for(i=0;i<n1;i++)
 {
  printf("YOU CAN CREATE ACCOUNT BY GIVING AADHAR NO\n");
  scanf("%d",&b[i].adhar_no);
  b[i].acc_no=(i+1);
  printf(" WOULD YOU CREATE ACCOUNT WITH OR WITHOUT CHEQUE BOOK?\n");
  printf(" ENTER \n 1. WITH CHEQUE BOOK\n 2. WITHOUT CHEQUE BOOK\n");
  scanf("%d",&ans);
  if(ans==1){
    printf(" YOU NEED TO DEPOSIT 1000 RS AS MINIMUM BALANCE WITH CHEQUE BOOK\n");here1:
    printf(" ENTER AMOUNT TO BE DEPOSITED\n");
    scanf("%lf",&b[i].balance);
    if(b[i].balance<1000)
    {
      printf(" YOU NEED TO DEPOSIT 1000 RS AS MINIMUM BALANCE WITH CHEQUE BOOK\n");goto here1;
    }
  }
  else{
   printf(" YOU NEED TO DEPOSIT 500 RS AS MINIMUM BALANCE WITHOUT CHEQUE BOOK\n");here2:
   printf(" ENTER AMOUNT TO BE DEPOSITED\n");
    scanf("%lf",&b[i].balance);
    if(b[i].balance<500)
    {
      printf(" YOU NEED TO DEPOSIT 500 RS AS MINIMUM BALANCE WITHOUT CHEQUE BOOK\n");goto here2;
    }
  }
 }
 }
}//create
double check_bal(int an)
{
 return B[an-1].balance;
}//
void withdrawl(double w,int an)
{
 if(B[an-1].balance>w)
 {
   B[an-1].balance-=w;
 }
 else{
   printf("INSUFFICIENT BALANCE");
 }
}
void deposit(double d,int an)
{
 B[an-1].balance+=d;
}
double calc(int an)
{
  intr[an-1]=(B[an-1].balance*0.03);
 return intr[an-1];
}

//getc(stdin);
//fflush(stdin);
//gets();
//scanf("",&);
//printf(" \n");

/*
 Write a C program for Banking Transactions. Create a structure Bank maintaining the account details of 10 account holders with account number, Aadhar card number and balance.
Create a separate function and pass bank structure array to it and perform the following:
Write a menu driven program for the following in the function for:
–	Account opening with minimum balance 500 rupees without cheque book and 1000 rupees with cheque book. Consider Aadhar card for opening account
–	Transaction ‘Check balance’
–	Transaction ‘ Withdrawal’ which confirms balance and then withdraw amount
–	Transaction ‘Deposit
–	Calculate interest as 3% on monthly deposits and reflect in the balance
*/
