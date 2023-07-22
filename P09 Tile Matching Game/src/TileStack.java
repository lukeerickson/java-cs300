import java.util.Iterator;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title:    P09 Tile Matching Game
//Course:   CS 300 Fall 2021
//
//Author:   Luke Erickson
//Email:    lerickson7@wisc.edu
//Lecturer: Hobbes
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    (name of your pair programming partner)
//Partner Email:   (email address of your programming partner)
//Partner Lecturer's Name: (name of your partner's lecturer)
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//___ Write-up states that pair programming is allowed for this assignment.
//___ We have both read and understand the course Pair Programming Policy.
//___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons:         (identify each by name and describe how they helped)
//Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Creates a Stack that Tile objects can be stored in
 * 
 * @author lukee
 *
 */
public class TileStack implements StackADT, Iterable<Tile> {

  private Node top;
  private int size;
  
  /**
   * Constructs an empty TileStack
   */
  public TileStack() {
    top = null;
    size = 0;
  }
  
  /**
   * Pushes a Tile Object to the top of the stack
   */
  @Override
  public void push(Object element) {
    size++;
    Node prevTop = top;
    top = new Node((Tile) element);
    top.setNext(prevTop);
  }

  /**
   * Returns and removes the Tile at the top of the stack
   */
  @Override
  public Object pop() {
    size--;
    Node prevTop = top;
    top = top.getNext();
    return prevTop.getTile();
  }

  /**
   * Returns the Tile at the top of the stack
   */
  @Override
  public Object peek() {
    return top.getTile();
  }

  /**
   * Returns true if Stack is empty
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns size of stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Creates an Iterator object to iterate thru the Stack
   */
  @Override
  public Iterator<Tile> iterator() {
    Iterator<Tile> i = new TileListIterator(top);
    return i;
  }

}
