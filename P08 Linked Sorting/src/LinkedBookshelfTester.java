//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Linked Sorting
// Course: CS 300 Fall 2021
//
// Author: Luke Erickson
// Email: lerickson7@wisc.edu
// Lecturer: Hobbes
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
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////


/**
 * Tests to make sure that the LinkedBookshelf class performs as expected
 * 
 * @author luke erickson
 *
 */
public class LinkedBookshelfTester {

  /**
   * tests the correctness of the LinkedNode class
   * 
   * @return true if the class functions as expected
   */
  public static boolean testLinkedNode() {
    try { 
   // test constructor
      String data1 = "ball";
      LinkedNode str1 = new LinkedNode(data1);

      String data2 = "hulahoop";
      LinkedNode str2 = new LinkedNode(data2);


      // test accessor
      if (!str1.getData().equals(data1))
        return false;

      // test mutator and accessor
      str1.setNext(str2);
      if (!str1.getNext().equals(str2))
        return false;

      try {
        str2.getNext();
      } catch (NullPointerException e) {
        return true;
      }
    } catch (Exception e) {
      System.out.println("A non-expected exception has been thrown");
      return false;
    }
    


    return true;
  }

  public static boolean testClear() {
    try {
    Book.resetGenerator();

    LinkedBookshelf b = new LinkedBookshelf();

    // add 3 books to LinkedBookshelf
    b.appendBook(new Book("declaration of independence", 17));
    b.appendBook(new Book("breakfast of champions", 322));
    b.appendBook(new Book("one flew over the cuckoo's nest", 325));

    // clear these books
    b.clear();

    // b should be empty
    if (!b.isEmpty())
      return false;

    // b should have a size of 0
    if (b.size() != 0)
      return false;

    try {
      // front should be null
      if (b.getFirst() != null)
        return false;

      // back should be null
      if (b.getLast() != null)
        return false;
    } catch (NullPointerException e) {
      // no problem detected
    }
    } catch (Exception e) {
      System.out.println("A non-expected exception has been thrown");
      return false;
    }

    return true;
  }

  /**
   * Tests the correctness of LinkedBookshelf's appendBook() method
   * 
   * @return true if appendBook() functions as expected
   */
  public static boolean testAddBooks() {
    try {
      Book.resetGenerator();
      
      LinkedBookshelf b = new LinkedBookshelf();

      // add 3 books to LinkedBookshelf
      b.appendBook(new Book("common sense", 17, "paine", "thomas"));
      b.appendBook(new Book("breakfast of champions", 322, "vonnegut", "kurt"));
      b.appendBook(new Book("one flew over the cuckoo's nest", 325, "kesey", "ken"));

      if (b.size() != 3)
        return false;

      // System.out.println(b.get(2));

      if (!b.getFirst().toString().equals("0: \"common sense\", paine, thomas (17)"))
        return false;
      
      //System.out.println(b.getNode(0).getNext());

      if (!b.get(1).toString().equals("1: \"breakfast of champions\", vonnegut, kurt (322)"))
        return false;

      if (!b.getLast().toString().equals("2: \"one flew over the cuckoo's nest\", kesey, ken (325)"))
        return false;
    } catch (Exception e) {
      System.out.println("A non-expected exception has been thrown");
      return false;
    }

    

    return true;
  }

  /**
   * Tests the correctness of LinkedBookshelf's sort() method
   * 
   * @return true if sort() works as expected
   */
  public static boolean testSortBooks() {
    try {
    Book.resetGenerator();

    LinkedBookshelf b = new LinkedBookshelf();

    // add 3 books to LinkedBookshelf
    b.appendBook(new Book("common sense", 17, "paine", "thomas"));
    b.appendBook(new Book("breakfast of champions", 322, "vonnegut", "kurt"));
    b.appendBook(new Book("one flew over the cuckoo's nest", 325, "kesey", "ken"));

    b.sort(b, Attribute.AUTHOR);

    //System.out.println(b);
    } catch (Exception e) {
      System.out.println("A non-expected exception has been thrown");
      return false;
    }

    return true;
  }

  /**
   * Ensures all tester methods work correctly
   * 
   * @return true if all tests return true, false otherwise
   */
  public static boolean runAllTests() {
    return testLinkedNode() && testClear() && testAddBooks() && testSortBooks();
  }

  /**
   * Starts the application
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    runAllTests();
  }
}
