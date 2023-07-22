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


import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Fish describes the constructors and methods for a basic fish. It is the super class of more specific types of fish
 *
 */
public class Fish extends TankObject {

  private int speed; // swimming speed of this fish
  private boolean isSwimming; // indicates whether this fish is swimming or not

  /**
   * @param speed of the fish
   * @param fishImageFileName: name of the file to be loaded
   * @throws IllegalArgumentException
   */
  public Fish(int speed, String fishImageFileName) throws IllegalArgumentException {
    // call the Tank Object constructor and pass it the appropriate parameters
    super((float) tank.randGen.nextInt(tank.width), (float) tank.randGen.nextInt(tank.height),
        fishImageFileName);
    if (speed <= 0)
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    this.speed = speed;
  }

  /*
   * basic constructor that sets speed to 5 and loads an orange fish
   */
  public Fish() {
    this(5, "images" + File.separator + "orange.png");
  }

  /**
   *Overrides the draw() method implemented in the parent class.
   *This method sets the position of this fish to follow the
   *mouse moves if it is dragging, calls its swim() method
   *if it is swimming, and draws it to the display window.
   *You can use a partial overriding (call draw() method of
   *the super class and adds the behavior specific to drawing a fish.
   */
  public void draw() {
    super.draw();
    // if the fish is swimming, call its swim() method
    if (isSwimming) {
      swim();
    }
  }

  /**
   * @return true if fish is swimming, false otherwise
   */
  public boolean isSwimming() {
    return isSwimming;
  }

  /**
   * Starts swimming this fish
   */
  public void startSwimming() {
    this.stopDragging();
    this.isSwimming = true;
  }

  /**
   * Stops swimming this fish
   */
  public void stopSwimming() {
    this.isSwimming = false;
  }

  /**
   * @return the speed of tbis fish
   */
  public int speed() {
    return this.speed;
  }
 
  /**
   * Moves horizontally the fish one speed step from left to right.
   */
  public void swim() {
    setX((getX() + speed) % tank.width);
  }
  
}
