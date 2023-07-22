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
 * (describe the class!)
 */
public class ClimbingTracker {
  /**
   * Adds a successful climb to an oversized array of completed climbs
   * 
   * @param send    = the oversized array containing the completed climbs
   * @param numSend = the size of send
   * @param grade   = the climb being newly added to send
   * @return the size of send following trying to add a new climb to send
   */
  public static int sendClimb(String[] send, int numSend, String grade) {

    // checks to see that "grade" is a valid grade for a climb
    if (!grade.substring(0, 1).equals("V") || Integer.parseInt(grade.substring(1)) < 0
        || Integer.parseInt(grade.substring(1)) > 7)
      return numSend;

    // checks to see that there is room for another grade in the successful climbs array
    if (numSend >= send.length)
      return numSend;

    // add the newest completed climb to the send array
    send[numSend] = grade;

    // add 1 to numSend so that the next climb added does not override this climb in the array
    return numSend + 1;

  }

  /**
   * Adds a failed climb to an oversized array of failed climbs
   * 
   * @param fail    = the oversized array containing the failed climbs
   * @param numFail = the size of send
   * @param grade   = the climb being newly added to fail
   * @return the size of fail following trying to add a new climb to fail
   */
  public static int failClimb(String[] fail, int numFail, String grade) {
    // checks to see that "grade" is a valid grade for a climb
    if (!grade.substring(0, 1).equals("V") || Integer.parseInt(grade.substring(1)) < 0
        || Integer.parseInt(grade.substring(1)) > 7)
      return numFail;
    // checks to see that there is room for another grade in the failed climbs array
    if (numFail >= fail.length)
      return numFail;

    // add the newest fail climb to the fail array
    fail[numFail] = grade;

    return numFail + 1;
  }

  /**
   * averages the grade of a user's most recent successful and failed climbs
   * 
   * @param send          = the oversized array containing the user's completed climbs
   * @param numSend       = the size of send
   * @param fail          = the oversize array containing the user's failed climbs
   * @param numFail       = the size of fail
   * @param historyLength = how far back the user wants to average climbs from
   * @return a string containing the user's average send and fail grades
   */
  public static String getStats(String[] send, int numSend, String[] fail, int numFail,
      int historyLength) {

    double sumSend = 0;
    double sumFail = 0;

    double avgSend = 0;
    double avgFail = 0;

    if (numSend > historyLength) {
      for (int i = numSend - historyLength; i < numSend; i++)
        sumSend += Integer.parseInt(send[i].substring(1));
      avgSend = sumSend / historyLength;
    }

    else {
      for (int i = 0; i < numSend; i++)
        sumSend += Integer.parseInt(send[i].substring(1));
      avgSend = sumSend / numSend;
    }

    if (numFail > historyLength) {
      for (int i = numFail - historyLength; i < numFail; i++)
        sumFail += Integer.parseInt(fail[i].substring(1));
      avgFail = sumFail / historyLength;
    }

    else {
      for (int i = 0; i < numFail; i++)
        sumFail += Integer.parseInt(fail[i].substring(1));
      avgFail = sumFail / numFail;
    }

    // we create an output statement with the average number of successful and failed climbs
    String output = "";

    // we check to see if enough climbs have been completed to accurately find their average grade
    if (historyLength <= 0 || numSend <= 0)
      output += "send: --\n";
    else {
      output += "send: ";
      output += avgSend;
      output += "\n";
    }

    // we check to see if enough climbs have been failed to accurately find their average grade
    if (historyLength <= 0 || numFail <= 0)
      output += "fail: --\n";
    else {
      output += "fail: ";
      output += avgFail;
      output += "\n";
    }

    return output;

  }

  /**
   * creates a histogram documenting the successes and fails of all of the user's climbd
   * 
   * @param send          = the oversized array containing the user's completed climbs
   * @param numSend       = the size of send
   * @param fail          = the oversize array containing the user's failed climbs
   * @param numFail       = the size of fail
   * @return a string displaying the user's successful and failed climbs
   */
  public static String getHistogram(String[] send, int numSend, String[] fail, int numFail) {

    int highestGrade = 0;

    // if no data has been collected, the user receives an error message
    if (numSend == 0 && numFail == 0)
      return "Error: No data to display\n";

    // find the highest grade the users has collected and work down from there
    for (int i = 0; i < numSend; i++) {
      if (highestGrade < Integer.parseInt(send[i].substring(1)))
        highestGrade = Integer.parseInt(send[i].substring(1));
    }

    for (int i = 0; i < numFail; i++) {
      if (highestGrade < Integer.parseInt(fail[i].substring(1)))
        highestGrade = Integer.parseInt(fail[i].substring(1));
    }

    // create output to display the histogram
    String output = "";

    // work through each grade, and add +'s and -'s for each climb
    for (int i = 0; i <= highestGrade; i++) {
      output += ("V" + i + ": ");
      for (int j = 0; j < numFail; j++) {
        if (Integer.parseInt(fail[j].substring(1)) == i)
          output += "- ";
      }

      for (int k = 0; k < numSend; k++) {
        if (Integer.parseInt(send[k].substring(1)) == i)
          output += "+ ";
      }

      output += "\n";

    }

    return output;
  }
}
