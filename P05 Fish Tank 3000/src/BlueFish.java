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
 * BlueFish describes the constructor and methods for a blue fish within the tank
 * 
 * @author Luke Erickson
 *
 */

public class BlueFish extends Fish {
  
    /**
     * defines the basic constructor for a blue fish
     */
    public BlueFish() {
      super(2, "images" + File.separator + "blue.png");
    }
    
    /**
     * Moves horizontally the fish one speed step from right to left.
     */
    @Override
    public void swim() {
      setX(getX() - speed());
      if(getX() < 0)
        setX(tank.width);
    }
}
