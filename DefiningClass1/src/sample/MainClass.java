package sample;

public class MainClass
{
  public static void main(String[] a)
  {
    Animal pet = new Animal("a");
    if (pet.getClass() == Animal.class)
    {
      System.out.println("it is an animal!");
    }
  }
}