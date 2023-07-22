//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Fish Tank 2000
// Course: CS 300 Fall 2021
//
// Author: Luke Erickson
// Email: lerickson7@wisc.edu
// Lecturer: Hobbes LeGault
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
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////


import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class Decoration {
  private static PApplet processing;
  private PImage image;
  private float x;
  private float y;
  private boolean isDragging;
  private static int oldMouseX;
  private static int oldMouseY;

  public Decoration(PApplet processing, float x, float y, String imageFileName) {
    // processing: PApplet reference to the display window of the Fish Tank
    // application
    Decoration.processing = processing;
    // x: x-position of this decoration object
    this.x = x;
    // y: y-position of this decoration object
    this.y = y;
    // imageFileName: filename of the image to be loaded for this object
    this.image = processing.loadImage(imageFileName);
    this.isDragging = false;
  }

  // Returns the image of this decoration object
  public PImage getImage() {
    return this.image;
  }

  // Returns the x-position of this decoration object
  public float getPositionX() {
    return this.x;
  }

  // Returns the y-position of this decoration object
  public float getPositionY() {
    return this.y;
  }

  // Checks whether this decoration object is being dragged
  // returns true if the object is being dragged, false otherwise
  public boolean isDragging() {
    return this.isDragging;
  }

  // Starts dragging this decoration object
  // Sets the oldMouseX and oldMouseY to the current position of the mouse
  public void startDragging() {
    this.isDragging = true;
    oldMouseX = processing.mouseX;
    oldMouseY = processing.mouseY;
  }

  // Stops dragging this decoration object
  public void stopDragging() {
    this.isDragging = false;
  }

  // Checks whether the mouse is over this decoration object
  public boolean isMouseOver() {
    int decoWidth = this.getImage().width;
    int decoHeight = this.getImage().height;

    // checks if the mouse is over the provided fish
    return processing.mouseX >= this.getPositionX() - decoWidth / 2
        && processing.mouseX <= this.getPositionX() + decoWidth / 2
        && processing.mouseY >= this.getPositionY() - decoHeight / 2
        && processing.mouseY <= this.getPositionY() + decoHeight / 2;
  }

  // Moves this decoration object with dx and dy
  public void move(int dx, int dy) {
    // dx move to the x-position of this decoration object
    // dy move to the y-position of this decoration object
    this.x += dx;
    this.y += dy;
  }

  // Draws this decoration object to the display window.
  // This method sets also the position of this object to follow the moves of the
  // mouse if it is being dragged
  public void draw() {
    // 1. if this decoration is dragging, move it with (dx, dy) to follow the moves of the mouse
    // [HINT] use the current position (processing.mouseX and processing.mouseY)
    // of the mouse with respect to the old position of the mouse to compute dx and dy moves
    // Make sure to update oldMouseX and oldMouseY after moving the decoration
    if (this.isDragging) {
      this.move(processing.mouseX - oldMouseX, processing.mouseY - oldMouseY);
      oldMouseX = processing.mouseX;
      oldMouseY = processing.mouseY;
    }

    // 2. draw this decoration to the display window by calling processing.image() method
    processing.image(this.image, this.x, this.y);
  }

}
