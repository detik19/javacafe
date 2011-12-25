package sample;

class Animal
{
  public Animal(String aType)
  {
    type = aType;
  }
  public String toString()
  {
    return "This is a " + type;
  }
  private String type;
}