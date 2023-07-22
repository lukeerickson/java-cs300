import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    
    // both of these are okay
    Parent p1 = new Parent();
    Parent p2 = new Child(); // why????
    // parent is super class
    
    // have to cast to access Child's data
    ((Child)p2).age = 5;
    
    // c2 is NOT okay
    Child c1 = new Child();
    //Child c2 = new Parent(); // nope
    Child c3 = (Child) p2;
    
    if (p1 instanceof Child) {
      Child c4 = (Child) p1;
    }
    
    Parent p3 = c3; // no explicit cast required to upcast!!
    
    // this does NOT require a cast, because name is public
    c1.name = "bob";

    
    ArrayList<Parent> par = new ArrayList<Parent>();
    par.add(c1); // why??
    
    p1.idk("jon");    // should not print hi
    p3.idk("martin"); // prints hi
    
    //p3.privateMethod();
    //p1.privateMethod();
  }

}
