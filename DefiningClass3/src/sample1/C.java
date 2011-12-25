package sample1;

class C 
{
	  A a = new A(3);

	  static A staticA = new A(4);

	  C() 
	  {
	    System.out.println("Cupboard()");
	    staticA.f(2);
	  }

	  void f3(int marker) 
	  {
	    System.out.println("f3(" + marker + ")");
	  }

	  static A staticA2 = new A(5);
}

