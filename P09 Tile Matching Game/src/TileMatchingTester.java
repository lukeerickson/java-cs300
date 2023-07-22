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
 * Tests to make sure that other classes in this assignment work as expected
 * 
 * @author lukee
 *
 */
public class TileMatchingTester {

  /**
   * Makes sure that Tile's equals() method works as expected
   * 
   * @return true if method works as expected
   */
  public static boolean tileEqualsTester() {
    try {
      // scenario 1 --> compare Tile to non-tile object
      Tile t = new Tile(Color.BLACK);
      String str = "blahfhd";

      if (t.equals(str))
        return false;

      // scenario 2 --> compare Tile to Tile of same color
      Tile a = new Tile(Color.ORANGE);
      Tile b = new Tile(Color.ORANGE);

      if (!a.equals(b))
        return false;

      // scenario 3 --> compare Tile to Tile of different color
      if (a.equals(t))
        return false;

      // scenario 4 --> compare a Tile to itself
      if (!t.equals(t))
        return false;

      // scenario 5 --> compare Tile to null
      if (t.equals(null))
        return false;
    } catch (Exception e) {
      // not expected
      return false;
    }
   

    return true;
  }

  /**
   * Makes sure that the TileListIterator class works as expected
   * 
   * @return true if class works as expected
   */
  public static boolean tileListIteratorTester() {
    
    try {
   // creates a chain of linked nodes, where a is the head node
      Node c = new Node(new Tile(Color.BLACK));
      Node b = new Node(new Tile(Color.YELLOW), c);
      Node a = new Node(new Tile(Color.BLUE), b);

      b.setNext(c);

      // creates an iterator w/ a as the head
      TileListIterator tli = new TileListIterator(a);

      // scenario 1 --> first call of Iterator.next() should return the first item in the list
      if (!tli.next().equals(a.getTile()))
        return false;

      // scenario 2 --> calling Iterator.hasNext() on head should return true
      if (!tli.hasNext())
        return false;

      // scenario 3 --> second call of Iterator.next() should return the second item in the list
      if (!tli.next().equals(b.getTile()))
        return false;

      // scenario 4 --> third call of Iterator.next() should return the third item in the list
      if (!tli.next().equals(c.getTile()))
        return false;

      // scenario 5 --> calling Iterator.hasNext() on tail should return false and throw an exception
      try {
        if (tli.hasNext())
          return false;
      } catch (NullPointerException e) {
        // exception expected
      }

      // scenario 6 --> forth call of Iterator.next() should return null and throw an exception
      try {
        if (tli.next() != null)
          return false;
      } catch (NoSuchElementException e) {
        // exception expected
      }
    } catch (Exception e) {
      // exception unexpected
      return false;
    }
    

    return true;
  }

  /**
   * Makes sure that the TileStack class works as expected
   * 
   * @return true if class works as expected
   */
  public static boolean tileStackTester() {

    try {
      TileStack ts = new TileStack();
      
      // scenario 1 --> newly created TileStack should be empty & have a size of 0
      if(!ts.isEmpty() || ts.size() != 0)
        return false;
      
      // scenario 2 --> push an element into TileStack
      Node a = new Node(new Tile(Color.BLUE));
      ts.push(a);
      
      if(ts.isEmpty() || ts.size() != 1)
        return false;
      
      if(!ts.peek().equals(a))
        return false;
      
      // scenario 3 --> push another element into TileStack
      Node b = new Node(new Tile(Color.BLACK));
      ts.push(b);
      
      if(!((Node) ts.peek()).getNext().equals(a))
        return false;
      
      if(ts.isEmpty() || ts.size() != 2)
        return false;
      
      // scenario 4 --> pop the top
      if(!ts.pop().equals(b))
        return false;
      
      if(ts.isEmpty() || ts.size() != 1)
        return false;
      
      // scenario 5 --> pop the top again
      if(!ts.pop().equals(a))
        return false;
      
      if(!ts.isEmpty() || ts.size() != 0)
        return false;
    } catch (Exception e) {
      // exception unexpected
      return false;
    }
    
    
    return true;
  }
  
  /**
   * Makes sure that the TileMatchingGame class works as expected
   * 
   * @return true if class works as expected
   */
  public static boolean tileMatchingGameTester() {
    try {
      
      // Scenario 1 --> create a new TileMatchingGame
      TileMatchingGame tmg = new TileMatchingGame(5);
      
      if(tmg.getColumnsNumber() != 5)
        return false;
      
      // Scenario 2 --> add a tile
      Node a = new Node(new Tile(Color.BLUE));
      
      tmg.dropTile(a.getTile(), 0);
      
      //System.out.println(tmg.column(0));
      
      if(!tmg.column(0).equals(a.getTile().toString()))
        return false;
      
      // Scenario 3 --> add another tile to the same index
      Node b = new Node(new Tile(Color.BLACK));
      
      tmg.dropTile(b.getTile(), 0);
      
      //System.out.println(tmg.column(0));
      
      //String str = a.getTile().toString() + " " + b.getTile().toString();
      
      //if(!tmg.column(0).equals(str))
        //return false;
      
      // Scenario 4 --> add a tile to a new index
      Node c = new Node(new Tile(Color.ORANGE));
      
      tmg.dropTile(c.getTile(), 1);
      
      // Scenario 5 --> clear column 0
      tmg.clearColumn(0);
      
      //System.out.println(tmg.column(0));
      
      if(tmg.column(0) != "")
        return false;
      
      // scenario 6 --> restart game
      tmg.restartGame();
      
      if(tmg.column(0) != "")
        return false;
      
      if(tmg.column(1) != "")
        return false;
      
    } catch (Exception e) {
      // exception unexpected
      return false;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    tileEqualsTester();
    tileMatchingGameTester();
    tileListIteratorTester();
    tileStackTester();

  }

}
