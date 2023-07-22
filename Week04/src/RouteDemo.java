/*
 * Instantiable class representing a climbing route
 */
public class RouteDemo {

  // data fields
  private String grade;
  private String comments;
  private int numAttempts;
  private boolean[] routeSent;
  private long[] timestamps;
  
  private static int numRoutes = 0;

  // constructor
  public RouteDemo (String grade) {
    this(grade, 100);
  }
  
  public RouteDemo (String grade, int arrayLength) {
    if (grade.length() == 2 && grade.charAt(0) == 'V' && grade.charAt(1) >= '0'
        && grade.charAt(1) <= '7')
      this.grade = grade;
    else
      throw new IllegalArgumentException("That's not a grade!");
    
    this.comments = "";
    this.numAttempts = 0;
    this.routeSent = new boolean[arrayLength];
    this.timestamps = new long[arrayLength];
    RouteDemo.numRoutes++;
  }
  
  public RouteDemo (RouteDemo toCopy) {
    this.grade = toCopy.grade;
    this.comments = toCopy.comments;
    // etc
  }
  
  // accessor method
  public static int getNumRoutes() {
    return RouteDemo.numRoutes;
  }
  
  // accessor method
  public String getGrade() {
    // using "this." in this situation communicates to the reader that i am referring to a
    // global variable
    return this.grade;
  }

  // accessor method
  public boolean compareGrade(RouteDemo otherRoute) {
    // we don't have to call "getGrade()" for otherRoute b/c we are in otherRoute's class
    return otherRoute.grade.equals(this.grade);
  }

  // mutator method
  public void setGrade(String grade) {
    if (grade.length() == 2 && grade.charAt(0) == 'V' && grade.charAt(1) >= '0'
        && grade.charAt(1) <= '7')
      this.grade = grade;
  }

}
