package sample1;

class B 
{
	  static A a = new A(1);
	  static A staticA = new A(2);

	  B() 
	  {
	    System.out.println("Table()");
	    staticA.f(1);
	  }

	  void f2(int marker) 
	  {
	    System.out.println("f2(" + marker + ")");
	  }

}