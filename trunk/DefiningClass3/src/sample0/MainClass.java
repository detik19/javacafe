package sample0;

public class MainClass 
{
	public static void main( String args[] ) 
	   {
	      Account account1 = new Account( 50.00 ); // create Account object
	      Account account2 = new Account( -7.53 ); // create Account object

	      System.out.printf( "account1 balance: $%.2f\n", account1.getBalance() );
	      System.out.printf( "account2 balance: $%.2f\n\n", account2.getBalance() );
	      
	      double depositAmount; // deposit amount read from user

	      depositAmount = 10.10;
	      account1.credit( depositAmount ); // add to account1 balance

	      System.out.printf( "account1 balance: $%.2f\n", account1.getBalance() );
	      System.out.printf( "account2 balance: $%.2f\n\n", account2.getBalance() );

	      depositAmount = 12.12; 
	      account2.credit( depositAmount ); // add to account2 balance

	      System.out.printf( "account1 balance: $%.2f\n", account1.getBalance() );
	      System.out.printf( "account2 balance: $%.2f\n", account2.getBalance() );
	   }

}
