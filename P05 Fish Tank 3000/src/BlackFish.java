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

/**
 * BlackFish describes the constructor and methods for a black fish within the tank
 * 
 * @author Luke Erickson
 *
 */

public class BlackFish extends Fish {
  private TankObject source;
  private TankObject destination;

  /**
   * @param source tank object the fish starts at
   * @param destination tank object the fish ends at
   */
  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }

  /**
   * makes one speed move towards destination
   */
  public void moveTowardsDestination() {
    int dx = (int) (destination.getX() - getX());
    int dy = (int) (destination.getY() - getY());
    int d = (int) Math.sqrt(dx * dx + dy * dy);

    setX(getX() + (speed() * (destination.getX() - getX())) / d);
    setY(getY() + (speed() * (destination.getY() - getY())) / d);

  }

  /**
   * https://stackoverflow.com/questions/23302698/java-check-if-two-rectangles-overlap-at-any-point,
   * user ThePatelGuy gave a good explanation of how to check if two rectangles overlap.
   * This helped me write my isOver() method for the BlackFish Class
   * 
   * @param other tank object
   * @return true if the images of the two tank objects overlap
   */
  public boolean isOver(TankObject other) {
    // 2 rectangles overlap if (x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2)
    if (getX() - getImage().width / 2 < other.getX() + other.image.width / 2
        && other.getX() - other.getImage().width / 2 < getX() + getImage().width / 2
        && getY() - getImage().height / 2 < other.getY() + other.getImage().height / 2
        && other.getY() - other.getImage().height / 2 < getY() + getImage().height / 2)
      return true;
    return false;


  }

  /**
   * Overrides Fish.swim() method
   * Moves the fish
   * Switches source and destination if the destination is reached
   */
  @Override
  public void swim() {
    // move the fish towards its destination
    moveTowardsDestination();
    // if destination is reached (meaning this fish is over its destination,
    // switch source and destination
    if (isOver(destination)) {
      TankObject temp = new TankObject(0, 0, "images" + File.separator + "flower.png");
      temp = source;
      source = destination;
      destination = temp;
    }

  }


}
