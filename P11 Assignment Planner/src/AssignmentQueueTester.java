//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P11 Assignment Planner
// Course:   CS 300 Fall 2021
//
// Author:   Luke Erickson
// Email:    lerickson7@wisc.edu
// Lecturer: Hobbes
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * Tester class for the AssignmentQueue implementation of PriorityQueueADT
 */
public class AssignmentQueueTester {
  /**
   * Tests the functionality of the constructor for AssignmentQueue Should implement at least the
   * following tests:
   *
   * - Calling the AssignmentQueue with an invalid capacity should throw an IllegalArgumentException
   * - Calling the AssignmentQueue with a valid capacity should not throw any errors, and should
   * result in a new AssignmentQueue which is empty, and has size 0
   *
   * @return true if the constructor of AssignmentQueue functions properly
   * @see AssignmentQueue#AssignmentQueue(int)
   */
  public static boolean testConstructor() {
    try {
      // scenario 1 - call constructor using invalid capacity
      try {
        AssignmentQueue a1 = new AssignmentQueue(-1);
        return false;
      } catch (IllegalArgumentException e) {
        // exception expected
      }

      // scenario 2 - call constructor using valid capacity
      AssignmentQueue a2 = new AssignmentQueue(7);

      if (!a2.isEmpty())
        return false;
      if (a2.size() != 0)
        return false;

    } catch (Exception e) {
      // exception unexpected
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of the enqueue() and peek() methods Should implement at least the
   * following tests:
   *
   * - Calling peek on an empty queue should throw a NoSuchElementException 
   * - Calling enqueue on a
   * queue which is empty should add the Assignment, and increment the size of the queue 
   * - Calling
   * enqueue on a non-empty queue should add the Assignment at the proper position, and increment
   * the size of the queue. Try add at least 5 assignments 
   * - Calling peek on a non-empty queue
   * should always return the Assignment with the earliest due date 
   * - Calling enqueue on a full
   * queue should throw an IllegalStateException 
   * - Calling enqueue with a null Assignment should
   * throw a NullPointerException
   *
   * @return true if AssignmentQueue.enqueue() and AssignmentQueue.peek() function properly
   */
  public static boolean testEnqueue() {
    try {
      // scenario 1 - call peek() on empty queue
      AssignmentQueue a = new AssignmentQueue(6);
      try {
        a.peek();
        return false;
      } catch (NoSuchElementException e) {
        // exception expected
      }
      
      // scenario 2 - call enqueue() on empty queue
      Assignment e1 = new Assignment("cs quiz", 12, 14, 17);
      a.enqueue(e1);
      
      if(!a.peek().equals(e1))
        return false;
      if(a.size() != 1)
        return false;
      
      // scenario 3 - call enqueue() on non-empty queue
      Assignment e2 = new Assignment("cs program", 12, 14, 22);
      Assignment e3 = new Assignment("cs pre-quiz", 12, 10, 22);
      Assignment e4 = new Assignment("math hw", 12, 15, 22);
      Assignment e5 = new Assignment("history paper", 12, 15, 22);
      Assignment e6 = new Assignment("video final cut", 12, 15, 10);
      a.enqueue(e2);
      a.enqueue(e3);
      a.enqueue(e4);
      a.enqueue(e5);
      a.enqueue(e6);
  
      if(a.size() != 6)
        return false;
      if(!a.peek().equals(e3))
        return false;
      
      // scenario 4 - call enqueue() on a full assignment queue
      try {
        a.enqueue(e2);
        return false;
      } catch (IllegalStateException xd) {
        // exception expected
      }
      
      // scenario 5 - call enqueue() w/ a null assignment
      AssignmentQueue b = new AssignmentQueue(6);
      try {
        b.enqueue(null);
        return false;
      } catch (NullPointerException e) {
        // exception expected
      }
     
    } catch (Exception e) {
      // exception unexpected
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of dequeue() and peek() methods. The peek() method must return without
   * removing the assignment with the highest priority in the queue. The dequeue() method must
   * remove, and return the assignment with the highest priority in the queue. The size must be
   * decremented by one, each time the dequeue() method is successfully called. Try to check the
   * edge cases (calling peek and dequeue on an empty queue, and calling dequeue on a queue of size
   * one). For normal cases, try to consider dequeuing from a queue whose size is at least 6. Try to
   * consider cases where percolate-down recurses on left and right.
   * 
   * @return true if AssignmentQueue.dequeue() and AssignmentQueue.peek() function properly
   */
  public static boolean testDequeuePeek() {
    try {
      // Scenario 1 - call peek() and dequeue() on an empty queue
      AssignmentQueue a = new AssignmentQueue(6);
      try {
        a.peek();
        return false;
      } catch (NoSuchElementException e) {
        // exception expected
      }
      try {
        a.dequeue();
        return false;
      } catch (NoSuchElementException e) {
        // exception expected
      }
      
      // Scenario 2 - call peek() and dequeue() on a queue of size 1
      Assignment e1 = new Assignment("cs quiz", 12, 14, 17);
      a.enqueue(e1);
      
      if(!a.peek().equals(e1))
        return false;
      if(a.size() != 1)
        return false;
      if(!a.dequeue().equals(e1))
        return false;
      if(a.size() != 0)
        return false;
      
      // Scenario 3 - call peek() and dequeue on a queue of size 6
      Assignment e2 = new Assignment("cs program", 12, 14, 22);
      Assignment e3 = new Assignment("cs pre-quiz", 12, 10, 22);
      Assignment e4 = new Assignment("math hw", 12, 15, 22);
      Assignment e5 = new Assignment("history paper", 12, 15, 22);
      Assignment e6 = new Assignment("video final cut", 12, 15, 10);
      a.enqueue(e1);
      a.enqueue(e2);
      a.enqueue(e3);
      a.enqueue(e4);
      a.enqueue(e5);
      a.enqueue(e6);
      
      // size 6 - "cs pre-quiz" is @ front of queue
      if(!a.peek().equals(e3))
        return false;
      if(!a.dequeue().equals(e3))
        return false;
      if(a.size() != 5)
        return false;
      
      // size 5 - "cs quiz" is @ front of queue
      if(!a.peek().equals(e1))
        return false;
      if(!a.dequeue().equals(e1))
        return false;
      if(a.size() != 4)
        return false;
      
      // size 4 - "cs program" is @ front of queue
      if(!a.peek().equals(e2))
        return false;
      if(!a.dequeue().equals(e2)) // null pointer
        return false;
      if(a.size() != 3)
        return false;
      
      // size 3 - "video final cut" is @ front of queue
      if(!a.peek().equals(e6))
        return false;
      if(!a.dequeue().equals(e6))
        return false;
      if(a.size() != 2)
        return false;
      
      // size 2 - "math hw" is @ front of queue
      if(!a.peek().equals(e4))
        return false;
      if(!a.dequeue().equals(e4))
        return false;
      if(a.size() != 1)
        return false;
      
      // size 1 - "history paper" is @ front of queue
      if(!a.peek().equals(e5))
        return false;
      if(!a.dequeue().equals(e5))
        return false;
      if(a.size() != 0)
        return false;
      
    } catch (IllegalArgumentException e) {
      // exception unexpected
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of the clear() method Should implement at least the following
   * scenarios: 
   * - clear can be called on an empty queue with no errors
   * - clear can be called on a
   * non-empty queue with no errors 
   * - After calling clear, the queue should contain no Assignments
   *
   * @return true if AssignmentQueue.clear() functions properly
   */
  public static boolean testClear() {
    try {
      // scenario 1 - call clear() on an empty queue
      AssignmentQueue a = new AssignmentQueue(6);
      a.clear();
      
      // scenario 2 - call clear() on a non-empty queue
      Assignment e1 = new Assignment("cs quiz", 12, 14, 17);
      Assignment e2 = new Assignment("cs program", 12, 14, 22);
      Assignment e3 = new Assignment("cs pre-quiz", 12, 10, 22);
      Assignment e4 = new Assignment("math hw", 12, 15, 22);
      Assignment e5 = new Assignment("history paper", 12, 15, 22);
      Assignment e6 = new Assignment("video final cut", 12, 15, 10);
      a.enqueue(e1);
      a.enqueue(e2);
      a.enqueue(e3);
      a.enqueue(e4);
      a.enqueue(e5);
      a.enqueue(e6);
      
      a.clear();
      
      if(a.size() != 0)
        return false;
      
    } catch (Exception e) {
      // exception unexpected
      return false;
    }

    return true;
  }

  /**
   * Tests all the methods of the AssignmentQueue class
   * 
   */
  public static boolean runAllTests() {
    return testConstructor() && testEnqueue() && testDequeuePeek() && testClear();
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
