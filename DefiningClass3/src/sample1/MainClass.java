package sample1;

public class MainClass 
{
	static B t2 = new B();

	static C t3 = new C();
	  public static void main(String[] args) 
	  {
	    System.out.println("Creating new Cupboard() in main");
	    new C();
	    System.out.println("Creating new Cupboard() in main");
	    new C();
	    t2.f2(1);
	    t3.f3(1);
	  }

	  
	}