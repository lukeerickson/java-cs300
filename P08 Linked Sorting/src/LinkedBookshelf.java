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
 * Defines a singly-linked-list containing Book objects
 * 
 * @author luke erickson
 *
 */
public class LinkedBookshelf {
  private LinkedNode<Book> front;
  private LinkedNode<Book> back;
  private int size;
  private Attribute sortedBy;

  /**
   * Default LinkedBookshelf constructor
   * 
   * @param sortedBy indicates how we compare and sort the books in this bookshelf
   */
  public LinkedBookshelf() {
    this.front = null;
    this.back = null;
    this.size = 0;
    this.sortedBy = Attribute.ID;
  }

  /**
   * gets the length of this object
   * 
   * @return how many items are in this object
   */
  public int size() {
    return this.size;
  }

  /**
   * Checks to see if LinkedBookshelf is empty
   * 
   * @return true if LinkedBookshelf is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Concatenates a String defining the LinkedBookshelf class
   * 
   * @return String summarizing the given object
   */
  public String toString() {
    String str = this.sortedBy + "\n";

    LinkedNode<Book> current = front;

    while (current != null) {
      str += current.getData() + "\n";
      current = current.getNext();
      // System.out.println(current.getNext());
    }
    // System.out.println(str);
    return str;
  }

  /**
   * gets the node noted by the inputted index
   * 
   * @param index to check
   * @return node at given index
   */
  public LinkedNode<Book> getNode(int index) {
    if (index < 0 || index > this.size - 1)
      throw new IndexOutOfBoundsException("Out of bounds index");

    LinkedNode<Book> current = front;
    int i = 0;

    while (current != null) {
      if (i == index)
        return current;
      current = current.getNext();
      i++;
    }

    return current;

  }

  /**
   * gets the Book at the inputted index
   * 
   * @param index to check
   * @return Book at given index
   */
  public Book get(int index) {
    if (index < 0 || index > size() - 1)
      throw new IndexOutOfBoundsException("Out of bounds index");

    LinkedNode<Book> current = front;
    int i = 0;

    while (current != null) {
      if (i == index)
        return current.getData();
      current = current.getNext();
      i++;
    }

    return null;
  }

  /**
   * gets first Book object in the LinkedBookshelf
   * 
   * @return first Book Object
   */
  public Book getFirst() {
    if (front == null)
      return null;
    else
      return this.front.getData();
  }

  /**
   * gets last Book object in the LinkedBookshelf
   * 
   * @return last Book object
   */
  public Book getLast() {
    if (back == null)
      return null;
    else
      return this.back.getData();
  }

  /**
   * Clears LinkedBookshelf object of its contents
   */
  public void clear() {
    this.front = null;
    this.back = null;
    this.size = 0;
  }

  /**
   * Adds Book to end of LinkedBookshelf
   * 
   * @param toAdd element we want to add to the end
   */
  public void appendBook(Book toAdd) {
    LinkedNode<Book> l = new LinkedNode(toAdd);
    // if the list is empty, make toAdd the front
    if (isEmpty()) {
      front = l;
      back = l;
    }
    // if the list already has elements, add toAdd to the back
    else {
      back.setNext(l);
      back = l;
    }
    size++;

  }

  /**
   * Adds Book to correct location in sorted linked list
   * 
   * @param toAdd element we want to add
   */
  public void insertBook(Book toAdd) {
    LinkedNode<Book> l = new LinkedNode(toAdd);

    // if the list is empty, make toAdd the front
    if (isEmpty()) {
      front = l;
      back = l;
    }

    LinkedNode<Book> current = front;
    LinkedNode<Book> last = null;

    // if current is greater than l, swap l and current
    if (current.getData().compareTo(l.getData(), sortedBy) > 0) {
      l.setNext(current);
      size++;
      return;
    }

    // iterate thru list & swap as needed
    while (current != null) {
      if (current.getData().compareTo(l.getData(), sortedBy) > 0) {
        last.setNext(l);
        l.setNext(current);
        size++;
        return;
      }
      last = current;
      current = current.getNext();
    }

    appendBook(toAdd);

  }

  /**
   * Uses insertion sort to organize Books within LinkedBookshelf
   * 
   * @param b        given LinkedBookshelf object
   * @param sortedBy how we're going to sort this LinkedBookshelf
   */
  public static void sort(LinkedBookshelf b, Attribute sortedBy) {

    LinkedBookshelf sorted = new LinkedBookshelf();
    LinkedNode<Book> current = b.front;

    // int i = 0;

    sorted.sortedBy = Attribute.AUTHOR;
    
    //System.out.println(current.getNext());

    while (current != null) {
      //System.out.println(current);
      sorted.insertBook(current.getData());
      current = current.getNext();
    }
    
    //for(int i = 0; i < b.size(); i ++) {
      //sorted.appendBook(b.get(i));
    //}
    
    b.clear();
    current = new LinkedNode(sorted.getFirst());
    
    while(current != null) {
      b.appendBook(current.getData());
      current = current.getNext();
    }
  }

}
