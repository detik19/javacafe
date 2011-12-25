package sample0;

class Account
{   
   private double balance; // instance variable that stores the balance

   // constructor  
   public Account( double initialBalance )
   {
      if ( initialBalance > 0.0 ) 
         balance = initialBalance; 
   }

   public void credit( double amount )
   {      
      balance = balance + amount;
   }

   public double getBalance()
   {
      return balance;
   }

}