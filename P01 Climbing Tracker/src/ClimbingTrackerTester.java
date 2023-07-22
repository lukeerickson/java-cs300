//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Climbing Tracker
// Course: CS 300 Fall 2021
//
// Author: Luke Erickson
// Email: lerickson7@wisc.edu
// Lecturer: (Mouna Kacem or Hobbes LeGault)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Utkarsh Sehgal
// Partner Email: usehgal@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class tests the ClimbingTracker class, ensuring that all methods function as expected
 * 
 */
public class ClimbingTrackerTester {

  /**
   * If runAllTests() returns true, return a message stating that all tests were successful Else,
   * return a message stating that not all tests were successful
   */
  public static void main(String[] args) {

    String output = "Conclusion\n";

    if (runAllTests())
      System.out.println(output + "All methods work as expected!");
    else
      System.out.println(output + "Something isnt working right...");
  }

  /**
   * Checks whether sendClimb() works as expected
   * 
   * @return true if sendClimb() returns an integer w/in the size of successfulClimbs and false
   *         otherwise
   */
  public static boolean testSendClimb() {
    int size = 0;
    String successfulClimbs[] = new String[100];

    // send a climb of grade "V0" via sendClimb()
    int climb1 = ClimbingTracker.sendClimb(successfulClimbs, size, "V0");
    if (climb1 <= 0 || climb1 > successfulClimbs.length)
      return false;
    size += 1;

    // send a climb of grade "V1" via sendClimb()
    int climb2 = ClimbingTracker.sendClimb(successfulClimbs, size, "V1");
    if (climb2 <= 0 || climb2 > successfulClimbs.length)
      return false;
    size += 1;

    // send a climb of grade "V0" via sendClimb()
    int climb3 = ClimbingTracker.sendClimb(successfulClimbs, size, "V0");
    if (climb3 <= 0 || climb3 > successfulClimbs.length)
      return false;
    size += 1;

    // send a climb of grade "V3" via sendClimb()
    int climb4 = ClimbingTracker.sendClimb(successfulClimbs, size, "V3");
    if (climb4 <= 0 || climb4 > successfulClimbs.length)
      return false;
    size += 1;

    // if sendClimb() works as expected each time it is called upon, return true
    return true;
  }

  /**
   * Checks whether failClimb() works as expected
   * 
   * @return true if failClimb() returns an integer w/in the size of failedClimbs and false
   *         otherwise
   */
  public static boolean testFailClimb() {
    int size = 0;
    String failedClimbs[] = new String[100];

    // fail a climb of grade "V0" via failClimb()
    int climb1 = ClimbingTracker.failClimb(failedClimbs, size, "V0");
    if (climb1 <= 0 || climb1 > failedClimbs.length)
      return false;
    size += 1;

    // fail a climb of grade "V0" via failClimb()
    int climb2 = ClimbingTracker.failClimb(failedClimbs, size, "V1");
    if (climb2 <= 0 || climb2 > failedClimbs.length)
      return false;
    size += 1;

    // fail a climb of grade "V0" via failClimb()
    int climb3 = ClimbingTracker.failClimb(failedClimbs, size, "V0");
    if (climb3 <= 0 || climb3 > failedClimbs.length)
      return false;
    size += 1;

    // fail a climb of grade "V0" via failClimb()
    int climb4 = ClimbingTracker.failClimb(failedClimbs, size, "V3");
    if (climb4 <= 0 || climb4 > failedClimbs.length)
      return false;
    size += 1;

    // if failClimb() works as expected each time it is called upon, return true
    return true;
  }



  /**
   * Checks whether getStats works as expected
   * 
   * @return true if getStats() returns a string containing "send" and "fail", and false otherwise
   */
  public static boolean testGetStats() {

    // test getStats() for the first time using the following variables
    String[] successfulClimbs1 = {"V0", "V1", null};
    int sizeSucc1 = 2;

    String[] failedClimbs1 = {"V0", "V1", null};
    int sizeFail1 = 2;

    // run getStats() using the given variables
    String stats1 =
        ClimbingTracker.getStats(successfulClimbs1, sizeSucc1, failedClimbs1, sizeFail1, 2);

    // print the output of getStats()
    System.out.println("Stats Test 1\n" + stats1);

    // if getStats() does not work as expected, return false
    if (!stats1.contains("send") || !stats1.contains("fail"))
      return false;

    // test getStats() for the second time using the following variables
    String[] successfulClimbs2 = {"V0", "V1", "V2", "V3", null};
    int sizeSucc2 = 4;

    String[] failedClimbs2 = {};
    int sizeFail2 = 0;

    // run getStats() using the given variables
    String stats2 =
        ClimbingTracker.getStats(successfulClimbs2, sizeSucc2, failedClimbs2, sizeFail2, 3);

    // print the output of getStats()
    System.out.println("Stats Test 2\n" + stats2);

    // if getStats() does not work as expected, return false
    if (!stats2.contains("send") || !stats2.contains("fail"))
      return false;

    return true;

  }

  /**
   * Checks whether getHistogram works as expected
   * 
   * @return true if getHistogram returns a string containing "V0: " or "Error" and false otherwise
   */
  public static boolean testGetHistogram() {

    String[] successfulClimbs1 = {"V0", "V1", null};
    int succSize1 = 2;

    String[] failedClimbs1 = {"V0", "V1", null};
    int failSize1 = 2;

    String histogram1 =
        ClimbingTracker.getHistogram(successfulClimbs1, succSize1, failedClimbs1, failSize1);

    System.out.println("Histogram 1\n" + histogram1);

    String[] successfulClimbs2 = {};
    int succSize2 = 0;

    String[] failedClimbs2 = {};
    int failSize2 = 0;

    String histogram2 =
        ClimbingTracker.getHistogram(successfulClimbs2, succSize2, failedClimbs2, failSize2);

    System.out.println("Histogram 2\n" + histogram2);

    // if getStats() does not work as expected, return false
    if ((histogram1.contains("V0: ") || histogram1.contains("Error"))
        && (histogram2.contains("V0: ") || histogram2.contains("Error")))
      return true;

    return false;
  }

  /**
   * Checks if all other test methods return true
   * 
   * @return true (signifying that all tests succeeded) if all other test methods return true 
   * Else, return false
   */
  public static boolean runAllTests() {
    if (testSendClimb() && testFailClimb() && testGetStats() && testGetHistogram())
      return true;

    return false;
  }
}
