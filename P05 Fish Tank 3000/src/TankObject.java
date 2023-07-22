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



import processing.core.PImage;
import processing.core.PApplet;

/**
 * TankObject describes the constructor and methods available to a TankObject created within the
 * FishTank
 * 
 * @author Luke Erickson
 *
 */

public class TankObject implements TankListener {
  protected static FishTank tank; // PApplet object which represents
  // the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  // is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse

  /**
   * constructor for the TankObject class
   * 
   * @param x             - x position
   * @param y             - y position
   * @param imageFileName - name of the file to be loaded
   */
  public TankObject(float x, float y, String imageFileName) {
    image = tank.loadImage(imageFileName);
    this.x = x;
    this.y = y;
    isDragging = false;
  }


  /**
   * Sets the PApplet graphic display window for all TankObjects
   * 
   * @param tank object representing display window
   */
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank;
  }

  /**
   * Moves this tank object with dx and dy
   * 
   * @param dx move to the x-position of this tank object
   * @param dy move to the y-position of this tank object
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }


  /**
   * @return x position of the tank object
   */
  public float getX() {
    return x;
  }

  /**
   * @return y position of the tank object
   */
  public float getY() {
    return y;
  }

  /**
   * Sets the x-position of this object
   * 
   * @param x value to be set
   */
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Sets the x-position of this object
   * 
   * @param x value to be set
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * @return image of the tank object
   */
  public PImage getImage() {
    return image;
  }

  /**
   * Getter of the isDragging field.
   * 
   * @return true if this object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this tank object
   */
  public void startDragging() {
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    this.isDragging = true;
  }

  /**
   * Stops dragging this tank object
   */
  public void stopDragging() {
    this.isDragging = false;
  }

  /**
   * overrides the tankListener.draw() method
   * draw this object to the tank
   */
  @Override
  public void draw() {
    // if the object is dragging, set its position to follow the mouse moves
    if (this.isDragging) {
      int dx = tank.mouseX - oldMouseX;
      int dy = tank.mouseY - oldMouseY;
      move(dx, dy);
      oldMouseX = tank.mouseX;
      oldMouseY = tank.mouseY;
    }

    // draw the object at its current position
    tank.image(this.image, this.x, this.y);
  }

  /**
   * overrides the tankListener.mousePressed() method
   * starts dragging this object
   */
  @Override
  public void mousePressed() {
    this.startDragging();
  }

  /**
   * overrides the tankListener.mouseReleased() method
   * stops dragging this object
   */
  @Override
  public void mouseReleased() {
    this.stopDragging();
  }

  /**
   *overrides the tankListener.isMouseOver() method
   *checks if the mouse is over this object
   */
  @Override
  public boolean isMouseOver() {
    return tank.mouseX >= x - image.width / 2 && tank.mouseX <= x + image.width / 2
        && tank.mouseY >= y - image.height / 2 && tank.mouseY <= y + image.height / 2;
  }


}
