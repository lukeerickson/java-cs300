//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Fish Tank 3000
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
// Online Sources:  https://stackoverflow.com/questions/23302698/java-check-if-two-rectangles-overlap-at-any-point,
//                  user ThePatelGuy gave a good explanation of how to check if two rectangles overlap.
//                  This helped me write my isOver() method for the BlackFish Class
//
///////////////////////////////////////////////////////////////////////////////

/**
 * AddOrangeFishButton describes the constructor and methods of a button that adds an orange fish to
 * the tank
 * 
 * @author Luke Erickson
 *
 */

public class AddOrangeFishButton extends Button {
  /**
   * @param x position of the button
   * @param y position of the button
   */
  public AddOrangeFishButton(float x, float y) {
    super("Add Orange", x, y);
  }

  /**
   * overrides tankListener.mousePressed() 
   * adds the button to objects
   */
  @Override
  public void mousePressed() {
    this.tank.addObject(new Fish());
  }
}
