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
 * This class models a Tile of a specific color
 *
 */
/**
 * @author mouna
 *
 */
public class Tile {
  private Color color; // color of this Tile

  /**
   * Creates a Tile with a specific color
   * 
   * @param color color to be assigned to this tile
   */
  public Tile(Color color) {
    this.color = color;
  }

  /**
   * Gets the color of this tile
   * 
   * @return the color of this tile
   */
  public Color getColor() {
    return color;
  }


  /**
   * Returns a string representation of this tile
   * 
   * @return the color of this tile as a string
   */
  @Override
  public String toString() {
    return color.name();
  }


  /**
   * Checks whether this tile equals to the other object provided as input
   * @return true if other is a Tile and has the same color as this tile
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Tile) {
      return this.getColor().equals(((Tile) other).getColor());
    }
    else
      return false;
      
}
}
