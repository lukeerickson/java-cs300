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


import java.util.zip.DataFormatException;

/**
 * This class tests the ExceptionalClimbing class, ensuring that all exceptions are handled
 * appropriately
 */

public class ExceptionalClimbingTester {

  /**
   * If runAllTests() returns true, return a message stating that all tests were successful Else,
   * return a message stating that not all tests were successful
   */
  public static void main(String[] args) {

    if (runAllTests())
      System.out.println("All methods work as expected!");
    else
      System.out.println("Something isnt working right...");
  }

  /**
   * Checks if all other test methods return true
   * 
   * @return true if all other test methods return true Else, return false
   */
  public static boolean runAllTests() {
    if (testSendClimb() && testFailClimb() && testGetStats() && testGetHistogram())
      return true;
    return false;
  }


  /**
   * Checks whether sendClimb() works as expected
   * 
   * @return true if sendClimb() throws IllegalArgumentException or DataFormatException (and their
   *         corresponding messages) when it should and false otherwise
   */
  public static boolean testSendClimb() {

    try {
      int size1 = 0;
      String successfulClimbs1[] = new String[100];
      String grade1 = "V0";

      // send a climb of grade "V0" via sendClimb()
      // completely valid input should cause no exceptions to be thrown
      try {
        ExceptionalClimbing.sendClimb(successfulClimbs1, size1, grade1);
      } catch (IllegalArgumentException iae) {
        return false;
      } catch (DataFormatException dfe) {
        return false;
      }

      int size2 = 0;
      String successfulClimbs2[] = new String[100];
      String grade2 = "sffdfd";

      // send a climb of grade "sffdfd" via sendClimb()
      // should cause an illegal argument exception b/c an invalid grade is inputed
      try {
        ExceptionalClimbing.sendClimb(successfulClimbs2, size2, grade2);
      } catch (IllegalArgumentException iae) {
        if (!iae.getMessage().equals(grade2 + " is not a valid grade"))
          return false;
      } catch (DataFormatException dfe) {
        return false;
      }

      int size3 = 100;
      String successfulClimbs3[] = new String[100];
      String grade3 = "V0";

      // inputing a full array should result in an illegal argument exception
      try {
        ExceptionalClimbing.sendClimb(successfulClimbs3, size3, grade3);
      } catch (IllegalArgumentException iae) {
        if (!iae.getMessage().equals("Cannot add new value to full length " + size3 + " array"))
          return false;
      } catch (DataFormatException dfe) {
        return false;
      }

      int size4 = 7;
      String successfulClimbs4[] = new String[100];
      String grade4 = "V3";

      // sending over an array of invalid size should result in a data format exception
      try {
        ExceptionalClimbing.sendClimb(successfulClimbs4, size4, grade4);
      } catch (IllegalArgumentException iae) {
        return false;
      } catch (DataFormatException dfe) {
        if (!dfe.getMessage().equals("invalid oversized array"))
          return false;
      }

      int size5 = 100;
      String successfulClimbs5[] = new String[100];
      String grade5 = "bogus";

      // send a climb of grade "bogus" & a full array via sendClimb()
      // should cause an illegal argument exception b/c an invalid grade is inputed
      try {
        ExceptionalClimbing.sendClimb(successfulClimbs5, size5, grade5);
      } catch (IllegalArgumentException iae) {
        if (!iae.getMessage().equals(grade5 + " is not a valid grade"))
          return false;
      } catch (DataFormatException dfe) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    
    // if everything has ran as it should, return true
    return true;

  }

  /**
   * Checks whether failClimb() works as expected
   * 
   * @return true if failClimb() throws IllegalArgumentException or DataFormatException (and their
   *         corresponding messages) when it should and false otherwise
   */
  public static boolean testFailClimb() {

    try {
      int size1 = 0;
      String failedClimbs1[] = new String[100];
      String grade1 = "V0";

      // fail a climb of grade "V0" via failClimb()
      // completely valid input should cause no exceptions to be thrown
      try {
        ExceptionalClimbing.failClimb(failedClimbs1, size1, grade1);
      } catch (IllegalArgumentException iae) {
        return false;
      } catch (DataFormatException dfe) {
        return false;
      }

      int size2 = 0;
      String failedClimbs2[] = new String[100];
      String grade2 = "sffdfd";

      // fail a climb of grade "sffdfd" via failClimb()
      // should cause an illegal argument exception b/c an invalid grade is inputed
      try {
        ExceptionalClimbing.failClimb(failedClimbs2, size2, grade2);
      } catch (IllegalArgumentException iae) {
        if (!iae.getMessage().equals(grade2 + " is not a valid grade"))
          return false;
      } catch (DataFormatException dfe) {
        return false;
      }

      int size3 = 100;
      String failedClimbs3[] = new String[100];
      String grade3 = "V0";

      // inputting a full array should result in an illegal argument exception
      try {
        ExceptionalClimbing.failClimb(failedClimbs3, size3, grade3);
      } catch (IllegalArgumentException iae) {
        if (!iae.getMessage().equals("Cannot add new value to full length " + size3 + " array"))
          return false;
      } catch (DataFormatException dfe) {
        return false;
      }

      int size4 = 7;
      String failedClimbs4[] = new String[100];
      String grade4 = "V3";

      // inputting an array of invalid size should result in a data format exception
      try {
        ExceptionalClimbing.failClimb(failedClimbs4, size4, grade4);
      } catch (IllegalArgumentException iae) {
        return false;
      } catch (DataFormatException dfe) {
        if (!dfe.getMessage().equals("invalid oversized array"))
          return false;
      }

      int size5 = 100;
      String failedClimbs5[] = new String[100];
      String grade5 = "bogus";

      // fail a climb of grade "bogus" & input a full array via failClimb()
      // should cause an illegal argument exception b/c an invalid grade is inputed
      try {
        ExceptionalClimbing.failClimb(failedClimbs5, size5, grade5);
      } catch (IllegalArgumentException iae) {
        if (!iae.getMessage().equals(grade5 + " is not a valid grade"))
          return false;
      } catch (DataFormatException dfe) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    // if everything has ran as it should, return true
    return true;

  }

  /**
   * Checks whether getStats() works as expected
   * 
   * @return true if getStats() throws IllegalArgumentException or RuntimeException (and their
   *         corresponding messages) in the appropriate circumstances, and false otherwise
   */
  public static boolean testGetStats() {

    try {
      String[] successfulClimbs1 = {"V0", "V1", null};
      int sizeSucc1 = 2;
      String[] failedClimbs1 = {null};
      int sizeFail1 = 0;
      int historyLength1 = 2;

      // input a valid array and an empty array
      // completely valid input should cause no exceptions to be thrown
      try {
        ExceptionalClimbing.getStats(successfulClimbs1, sizeSucc1, failedClimbs1, sizeFail1,
            historyLength1);
      } catch (IllegalArgumentException iae) {
        return false;
      } catch (RuntimeException re) {
        return false;
      }

      String[] successfulClimbs2 = {};
      int sizeSucc2 = 0;
      String[] failedClimbs2 = {};
      int sizeFail2 = 0;
      int historyLength2 = 2;

      // inputing 2 empty arrays should cause a runtime exception
      try {
        ExceptionalClimbing.getStats(successfulClimbs2, sizeSucc2, failedClimbs2, sizeFail2,
            historyLength2);
      } catch (IllegalArgumentException iae) {
        return false;
      } catch (RuntimeException re) {
        if (!re.getMessage().equals("no climbs provided"))
          return false;
      }

      String[] successfulClimbs3 = {"V0", "V1", null};
      int sizeSucc3 = 2;
      String[] failedClimbs3 = {"V6", "V7", "V0"};
      int sizeFail3 = 3;
      int historyLength3 = 0;

      // input an invalid history length
      // this should cause an illegal argument exception
      try {
        ExceptionalClimbing.getStats(successfulClimbs3, sizeSucc3, failedClimbs3, sizeFail3,
            historyLength3);
      } catch (IllegalArgumentException iae) {
        if (!iae.getMessage().equals(historyLength3 + " is not a valid history length"))
          return false;
      } catch (RuntimeException re) {
        return false;
      }

      String[] successfulClimbs4 = {};
      int sizeSucc4 = 0;
      String[] failedClimbs4 = {};
      int sizeFail4 = 0;
      int historyLength4 = -27;

      // inputting 2 empty arrays should cause a runtime exception
      // illegal argument exception should never be thrown
      try {
        ExceptionalClimbing.getStats(successfulClimbs4, sizeSucc4, failedClimbs4, sizeFail4,
            historyLength4);
      } catch (IllegalArgumentException iae) {
        return false;
      } catch (RuntimeException re) {
        if (!re.getMessage().equals("no climbs provided"))
          return false;
      }
    } catch (Exception e) {
      return false;
    }

    // if everything ran as it should, return true
    return true;

  }

  /**
   * Checks whether getHistogram() works as expected
   * 
   * @return true if getHistogram() throws RuntimeException and its corresponding message under the
   *         appropriate conditions, and false otherwise
   */
  public static boolean testGetHistogram() {

    try {
      String[] successfulClimbs1 = {"V0", "V1", null};
      int succSize1 = 2;
      String[] failedClimbs1 = {};
      int failSize1 = 0;

      // input a valid array and an empty array
      // completely valid input should cause no exceptions to be thrown
      try {
        ExceptionalClimbing.getHistogram(successfulClimbs1, succSize1, failedClimbs1, failSize1);
      } catch (RuntimeException re) {
        return false;
      }

      String[] successfulClimbs2 = {};
      int succSize2 = 0;
      String[] failedClimbs2 = {};
      int failSize2 = 0;

      // input 2 empty arrays
      // should result in a RuntimeException
      try {
        ExceptionalClimbing.getHistogram(successfulClimbs2, succSize2, failedClimbs2, failSize2);
      } catch (RuntimeException re) {
        if (!re.getMessage().equals("no climbs provided"))
          return false;
      }
    } catch (Exception e) {
      return false;
    }
    
    

    return true;
  }

}
