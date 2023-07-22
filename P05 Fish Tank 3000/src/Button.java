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

import processing.core.PApplet;

/**
 * Button describes the constructor and methods allow for the functionality of a button on the display window
 * 
 * @author Luke Erickson
 *
 */

public class Button implements TankListener {

  private static final int WIDTH = 85; // Width of this Button
  private static final int HEIGHT = 32; // Height of this Button
  protected static FishTank tank; // PApplet object where this button will be displayed
  private float x; // x-position of this button in the display window
  private float y; // y-position of this button in the display window
  protected String label; // text/label which represents this button

  /**
   * Creates a new Button at a given position within the display window
   * and sets its label
   * 
   * @param label given to the button
   * @param x position of the button
   * @param y position of the button
   */
  public Button(String label, float x, float y) {
    this.label = label;
    this.x = x;
    this.y = y;
  }

  /**
   * Sets the PApplet graphic display window for all TankObjects
   * 
   * @param tank: display window
   */
  public static void setProcessing(FishTank tank) {
    Button.tank = tank;
  }

  /**
   * Overrides TankListener.draw() method
   * Draws this button to the display window
   */
  @Override
  public void draw() {
    tank.stroke(0);// set line value to black

    // if the mouse is over this button, sets the fill color to dark gray.
    if (isMouseOver())
      tank.fill(100);
    // Sets the fill color to light gray otherwise
    else
      tank.fill(200);

    // draw the button (rectangle with a centered text)
    tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button
  }

  /**
   * Overrides the TankListener.mousePressed() method
   * Implements the default behavior of this button when the mouse is pressed. 
   */
  @Override
  public void mousePressed() {
    // if the mouse is over this button, print
    // "A button was pressed." to the console
    if(isMouseOver())
      System.out.println("A button was pressed.");

  }

  /**
   * Overrides the TankListener.mouseReleased() method
   * Does nothing
   */
  @Override
  public void mouseReleased() {
    // Leave this method empty
  }

  /**
   * Overrides the TankListener.isMouseOver() method
  // checks if the mouse is over this object
   * 
   * @returns true if the mouse is over this button, and false otherwise
   */
  @Override
  public boolean isMouseOver() {
    return tank.mouseX >= x - WIDTH / 2 && tank.mouseX <= x + WIDTH / 2
        && tank.mouseY >= y - HEIGHT / 2 && tank.mouseY <= y + HEIGHT / 2;
  }



}
