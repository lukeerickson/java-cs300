import java.util.Iterator;
import java.util.NoSuchElementException;

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
 * Class object that allows the user to iterate thru TileStack
 * 
 * @author lukee
 *
 */
public class TileListIterator implements Iterator<Tile> {

  private Node current;

  /**
   * Creates a new iterator to iterate through a list of tiles starting from its head
   * 
   * @param head is a reference to the head of the linked list of tiles
   */
  public TileListIterator(Node head) {
    current = head;
  }

  /**
   * Returns true if TileStack has next element
   */
  @Override
  public boolean hasNext() {
    return current != null;
  }

  /**
   * Returns TileStack's next element
   */
  @Override
  public Tile next() {
    if(current == null)
      throw new NoSuchElementException("The next node is null");
    
    Node previous = current;
    current = current.getNext();
    return previous.getTile();
  }

}
