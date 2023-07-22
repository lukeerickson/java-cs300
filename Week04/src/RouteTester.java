
public class RouteTester {

  public static void main(String[] args) {
    System.out.println(RouteDemo.getNumRoutes());
    
    // do something better here in practice
    // make a back-up constructor that can't have a checked exception
    RouteDemo x = null; // declare
    try {
      x = new RouteDemo("yolo"); //initialize
      // if the constructor throws the exception, x is never initialized
    } catch (IllegalArgumentException iae) {
      System.out.println("Bad input");
    }
    
    System.out.println(RouteDemo.getNumRoutes());
    
    RouteDemo y; // declare
    y = new RouteDemo("V7"); // initialize
    
    System.out.println(RouteDemo.getNumRoutes());
    
    x.setGrade("yolo");
    
    System.out.println(x.getGrade()+", "+y.getGrade()); 
    // we don't affect the getGrade() of y when we set the getGrade() of x
    
    y.setGrade("V0");
    
    System.out.println(x.getGrade()+", "+y.getGrade());
    
    System.out.println(x.compareGrade(y));

  }

}
