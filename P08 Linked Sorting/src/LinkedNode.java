//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P08 Linked Sorting
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


/**
 * Generic class that defines a node within a singly-linked-list
 * @author luke erickson
 * @param <T> the type of the value being boxed
 */
public class LinkedNode<T> {
  private T data;
  private LinkedNode<T> next;
  
  /**
   * 1st constructor for the LinkedNode class
   * 
   * @param data generic type
   */
  public LinkedNode(T data) {
    this.data = data;
    this.next = null;
  }
  
  /**
   * 2nd constructor for the LinkedNode class
   * 
   * @param data generic type
   */
  public LinkedNode(T data, LinkedNode<T> next) {
    this.data = data;
    this.next = next;
  }
  
  /**
   * gets next LinkedNode
   * 
   * @return next node
   */
  public LinkedNode<T> getNext() {
    return next;
  }
  
  /**
   * gets data type
   * 
   * @return data type
   */
  public T getData() {
    return this.data;
  }
  
  /**
   * Sets next node to input
   * 
   * @param next node
   */
  public void setNext(LinkedNode<T> next) {
    this.next = next;
  }
  
  /**
   * Concatenates a String defining the LinkedNode<T> class
   * 
   * @return String summarizing the given object
   */
  public String toString() {
    return data.toString();
  }
  

}
