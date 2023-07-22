//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P09 Tile Matching Game
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
 * Creates an array of TileStacks that keeps track of Tiles
 * 
 * @author lukee
 *
 */
public class TileMatchingGame {
  private TileStack[] columns;
  
  /**
   * Creates a columns array of length columnCount
   * 
   * @param columnCount length of array
   */
  public TileMatchingGame(int columnCount) {
    columns = new TileStack[columnCount];
    for(int i = 0; i < columnCount; i++)
      columns[i] = new TileStack();
  }
  
  /**
   * Removes TileStack from a column
   * 
   * @param index column to have info removed
   */
  public void clearColumn(int index) {
    columns[index] = null;
  }
  
  /**
   * Produces string representation of a column
   * 
   * @param index column to return
   * @return string representation of column
   */
  public String column(int index) {
    if(columns[index] == null)
      return "";
    
    TileListIterator tli = (TileListIterator) columns[index].iterator();
    String str = "";
    
    while(tli.next() != null) {
      str += tli.next().toString();
      if(tli.hasNext())
        str += " ";
    }
      
    
    return str;
  }
  
  /**
   * Add a tile to a TileStack
   * 
   * @param tile to be added
   * @param index to add tile at
   */
  public void dropTile(Tile tile, int index) {
    Node n = new Node(tile);
    columns[index].push(n);
  }
  
  /**
   * Gets number of columns in columns
   * 
   * @return number of columns
   */
  public int getColumnsNumber() {
    return columns.length;
  }
  
  /**
   * Clear all columns
   */
  public void restartGame() {
    // clear all columns
    for(int i = 0; i < getColumnsNumber(); i++)
      clearColumn(i);
  }
  
  /**
   * return string representation of class object
   */
  public String toString() {
    String str = "GAME COLUMNS:\n";
    // iterate and return the toString() of each column
    for(int i = 0; i < getColumnsNumber(); i++)
      str += i + ": " + column(i) + "\n";
    return str;
    
  }
}
