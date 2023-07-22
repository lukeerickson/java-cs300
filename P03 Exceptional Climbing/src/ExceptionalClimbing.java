//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 ExceptionalClimbing
// Course: CS 300 Fall 2021
//
// Author: Luke Erickson
// Email: lerickson7@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: No outside help used
// Online Sources: No outside help used
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A version of the ClimbingTracker which uses exceptions for error handling
 * 
 * @author hobbes
 */

import java.util.zip.DataFormatException;

/**
 * A version of the ClimbingTracker which uses exceptions for error handling
 * 
 * @author hobbes
 */

public class ExceptionalClimbing {

  /**
   * Adds a successfully sent climb to the relevant array.
   * 
   * @param send    the array of successful climbs
   * @param numSend the current number of elements in the send array
   * @param grade   the grade of climb to be added, V0-V7
   * @return the new size of the send array
   * @throws IllegalArgumentException if an invalid grade is entered or the send array is full
   * @throws DataFormatException      if any element of send is null or if numSend is negative
   */
  public static int sendClimb(String[] send, int numSend, String grade)
      throws IllegalArgumentException, DataFormatException, Exception {

    // if the grade isn't valid, throw an IllegalArgumentException
    if (grade.length() != 2 || grade.charAt(0) != 'V' || !(Character.isDigit(grade.charAt(1))
        && '0' <= grade.charAt(1) && grade.charAt(1) <= '7'))
      throw new IllegalArgumentException(grade + " is not a valid grade");

    // if send is full, throw an IllegalArgumentException
    if (numSend == send.length) // it's full
      throw new IllegalArgumentException(
          "Cannot add new value to full length " + numSend + " array");

    // if any element of send is null, throw a DataFormatException
    for (int i = 0; i < numSend; i++) {
      if (send[i] == null)
        throw new DataFormatException("invalid oversized array");
    }

    // if numSend is negative, throw a DataFormatException
    if (numSend < 0)
      throw new DataFormatException("invalid oversized array");

    // add new climb
    send[numSend] = grade;
    return numSend + 1;
  }

  /**
   * Adds an unsuccessful climb to the relevant array.
   * 
   * @param fail    the array of failed climbs
   * @param numFail the current number of elements in the fail array
   * @param grade   the grade of climb to be added, V0-V7
   * @return the new size of the fail array
   * @throws IllegalArgumentException if an invalid grade is entered or the fail array is full
   * @throws DataFormatException      if any element of fail is null or if numFail is negative
   */
  public static int failClimb(String[] fail, int numFail, String grade)
      throws IllegalArgumentException, DataFormatException, Exception {

    // if the grade isn't valid, throw an IllegalArgumentException
    if (grade.length() != 2 || grade.charAt(0) != 'V'
        || !(Character.isDigit(grade.charAt(1)) && 48 <= grade.charAt(1) && grade.charAt(1) <= 55))
      throw new IllegalArgumentException(grade + " is not a valid grade");

    // if fail is full, throw an IllegalArgumentException
    if (numFail == fail.length)
      throw new IllegalArgumentException(
          "Cannot add new value to full length " + numFail + " array");

    // if any element of fail is null, throw a DataFormatException
    for (int i = 0; i < numFail; i++) {
      if (fail[i] == null)
        throw new DataFormatException("invalid oversized array");
    }

    // if numFail is negative, throw a DataFormatException
    if (numFail < 0)
      throw new DataFormatException("invalid oversized array");

    // add new failed climb
    fail[numFail] = grade;
    return numFail + 1;
  }

  /**
   * Calculates the average difficulty of the sent and failed climbs and returns the value as a
   * formatted string.
   * 
   * @param send          the array of sent climbs
   * @param numSend       the current number of elements in the send array
   * @param fail          the array of failed climbs
   * @param numFail       the current number of elements in the fail array
   * @param historyLength the quantity of climbs to calculate statistics over, counted from the
   *                      highest index backwards
   * @return a formatted string containing the average difficulty of sent and failed climbs
   * @throws RuntimeException         if both arrays are empty
   * @throws IllegalArgumentException if historyLength is 0 or negative
   */
  public static String getStats(String[] send, int numSend, String[] fail, int numFail,
      int historyLength) throws RuntimeException, IllegalArgumentException, Exception {

    if (numSend <= 0 && numFail <= 0)
      throw new RuntimeException("no climbs provided");

    if (historyLength <= 0)
      throw new IllegalArgumentException(historyLength + " is not a valid history length");

    // calculate send average
    String sendAvg = getAverage(send, numSend, historyLength);
    String failAvg = getAverage(fail, numFail, historyLength);

    // create result string
    String retval = "send: " + sendAvg + "\nfail: " + failAvg;
    return retval;
  }

  /**
   * A helper method to compute the average grade value over an array of climbs.
   * 
   * @param arr           the array to use
   * @param size          the size of the array
   * @param historyLength the quantity of climbs to calculate statistics over, counted from the
   *                      highest index backwards
   * @return the String representation of the average grade value
   */
  private static String getAverage(String[] arr, int size, int historyLength) {
    // check size/history
    if (historyLength <= 0 || size <= 0)
      return "--";

    double tot = 0;

    // if size <= historyLength, average is sum of grades / size
    if (size < historyLength) {
      for (int i = 0; i < size; i++) {
        tot += getGrade(arr[i]);
      }
      return "" + (tot / size);
    }

    // if size > historyLength, average is sum of last historyLength entries in arr / historyLength
    for (int i = size - historyLength; i < size; i++) {
      tot += getGrade(arr[i]);
    }
    return "" + (tot / historyLength);
  }

  /**
   * A helper method to convert a climb's grade to a numeric value using ASCII math.
   * 
   * @param grade the grade of a climb, V0-V7
   * @return the numeric value corresponding to the climb, 0-7
   */
  private static int getGrade(String grade) {
    return grade.charAt(1) - 48;
  }

  /**
   * Creates and returns a formatted histogram of climbs from V0 to the highest grade present of
   * sent (+) and failed (-) climbs.
   * 
   * @param send    the array of sent climbs
   * @param numSend the current number of elements in the send array
   * @param fail    the array of failed climbs
   * @param numFail the current number of elements in the fail array
   * @return the formatted histogram String
   * @throws RuntimeException if both arrays are empty
   */
  public static String getHistogram(String[] send, int numSend, String[] fail, int numFail)
      throws RuntimeException, Exception {
    // check that there is data
    if (numSend == 0 && numFail == 0)
      throw new RuntimeException("no climbs provided");

    // build from V0 on up
    int totalSend = 0;
    int totalFail = 0;
    int grade = 0;
    String retval = "";

    while (totalSend < numSend || totalFail < numFail) {

      retval += "V" + grade + ": ";

      // get fail count
      int failCount = getCount(fail, numFail, "V" + grade);
      totalFail += failCount;
      for (int i = 0; i < failCount; i++) {
        retval += "- ";
      }

      // get send count
      int sendCount = getCount(send, numSend, "V" + grade);
      totalSend += sendCount;
      for (int i = 0; i < sendCount; i++) {
        retval += "+ ";
      }

      // trim off the last space and add a newline
      retval = retval.substring(0, retval.length() - 1);
      retval += "\n";

      grade++;
    }

    // trim off the last newline
    retval = retval.substring(0, retval.length() - 1);

    return retval;
  }

  /**
   * A helper method to count the number of climbs in an array at a given grade
   * 
   * @param arr   an array of climbs, sent or failed
   * @param size  the number of values in that array
   * @param grade the grade to count
   * @return the number of climbs in array at the given grade
   */
  private static int getCount(String[] arr, int size, String grade) {
    int retval = 0;
    for (int i = 0; i < size; i++) {
      if (arr[i].equals(grade))
        retval++;
    }
    return retval;
  }
}
