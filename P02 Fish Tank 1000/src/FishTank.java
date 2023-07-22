//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Fish Tank 1000
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
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: No outside help used
// Online Sources: No outside help used
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTank {

  private static PApplet processing; // PApplet object that represents the graphic
  // interface of the JunglePark application
  private static PImage backgroundImage; // PImage object that represents the
  // background image
  private static Fish[] fishes; // perfect size array storing the different fish present
  // in the fish tank. These fish can be of different species.
  private static Random randGen; // Generator of random numbers

  public static void main(String[] args) {
    Utility.startApplication(); // starts the application
  }

  /**
   * Defines the initial environment properties of this application
   * 
   * @param processingObj a reference to the graphic display window of this application
   */
  public static void setup(PApplet processingObj) {

    processing = processingObj;


    // initializes the fishes array of length 8
    fishes = new Fish[8];

    randGen = new Random();

    // load the image of the background
    backgroundImage = processing.loadImage("images/background.png");

  }


  /**
   * Draws and updates the application display window. This callback method called in an infinite
   * loop.
   */
  public static void draw() {

    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);

    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != (null))
        fishes[i].draw();
    }



  }

  /**
   * Checks if the mouse is over a specific Fish whose reference is provided as input parameter
   *
   * @param Fish reference to a specific fish
   * @return true if the mouse is over the specific Fish object (i.e. over the image of the Fish),
   *         false otherwise
   */
  public static boolean isMouseOver(Fish Fish) {

    // if mouse is within the bounds of the fish, return true
    if (processing.mouseX < Fish.getPositionX() + Fish.getImage().width / 2
        && processing.mouseX > Fish.getPositionX() - Fish.getImage().width / 2
        && processing.mouseY < Fish.getPositionY() + Fish.getImage().height / 2
        && processing.mouseY > Fish.getPositionY() - Fish.getImage().height / 2)
      return true;

    return false;

  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {

    int x = 0;
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null) {
        // only drag the fish of lowest index position
        if (x == 0) {
          // if mouse is over a specific fish, start dragging that fish
          if (isMouseOver(fishes[i])) {
            fishes[i].setDragging(true);
            x = 1;
          }
        }
      }
    }

  }



  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased() {

    // if mouse is released, stop dragging the fish that was being dragged
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != (null))
        fishes[i].setDragging(false);
    }

  }


  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {

    // if 'f' is pressed, add a fish into the mix
    if (processing.key == 'f' || processing.key == 'F') {
      int x = 0;
      for (int i = 0; i < fishes.length; i++) {
        if (fishes[i] == null) {
          if (x == 0) {
            fishes[i] = new Fish(processing, (float) randGen.nextInt(processing.width),
                (float) randGen.nextInt(processing.height));
            x = 1;
          }
        }
      }
    }

    // if 'r' is pressed while mousing over a fish, remove the fish of lowest index position
    if (processing.key == 'r' || processing.key == 'R') {

      int x = 0;

      for (int i = 0; i < fishes.length; i++) {
        if (fishes[i] != null) {
          if (isMouseOver(fishes[i])) {
            if (x == 0) {
              fishes[i] = null;
              x = 1;
            }
          }
        }
      }



    }


  }
}
