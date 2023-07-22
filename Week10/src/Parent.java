
public class Parent {

  public String name;
  
  private int privateMethod() {
    return 5;
  }
  
  public void idk(String name) {
    this.name = name;
    //if (this instanceof Child) {
      this.somethingElse(5);
    //}
  }
  
  public void somethingElse(int y) {
    System.out.println("go away");
  }
  
}
