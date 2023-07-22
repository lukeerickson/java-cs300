//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P04 Fish Tank 2000
// Course:   CS 300 Fall 2021
//
// Author:   Luke Erickson
// Email:    lerickson7@wisc.edu
// Lecturer: Hobbes LeGault
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
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A program that draws a fish tank with moving and interactable fish and decorations
 * 
 * @author luke erickson
 */

public class FishTank {
  private static PApplet processing; // PApplet object which represents the graphic interface
                                     // of the Fish Tank application
  private static PImage backgroundImage; // PImage object which represents the background image
  private static Fish[] fishes; // array storing the current fishes present in the tank
  private static Random randGen; // Generator of random numbers

  // circular indexed array of fish images names
  private static String[] images =
      new String[] {"orange.png", "blue.png", "yellow.png", "black.png"};
  // index of next fish image index in the circular array images
  private static int nextImageIndex;

  // can be changed to alter how fast all of the fish in the tank move
  private static int fishSpeed;

  // array storing the decoration objects present in the tank
  private static Decoration[] decorations;

  /**
   * Defines initial environment properties such as screen size and to load background images and
   * fonts as the program starts. It also initializes all data fields.
   * 
   * @param processingObj a PApplet object that represents the display window of the Fish Tank
   *                      application
   */
  public static void setup(PApplet processingObj) {
    processing = processingObj;
    backgroundImage = processing.loadImage("images" + File.separator + "background.png");
    fishes = new Fish[8];
    randGen = new Random();

    fishSpeed = 5;

    decorations = new Decoration[4];

    decorations[0] =
        new Decoration(processingObj, 430, 60, "images" + File.separator + "flower.png");
    decorations[1] = new Decoration(processingObj, 580, 470, "images" + File.separator + "log.png");
    decorations[2] =
        new Decoration(processingObj, 65, 520, "images" + File.separator + "shell.png");
    decorations[3] =
        new Decoration(processingObj, 280, 535, "images" + File.separator + "ship.png");
  }

  /**
   * Continuously draws and updates the application display window
   * 
   */
  public static void draw() {
    // clear the display window by drawing the background image
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);

    // traverse the decorations array and draw each of the decorations present in the tank
    for (int i = 0; i < decorations.length; i++)
      if (decorations[i] != null)
        decorations[i].draw();

    // traverse the fishes array and draw each of the fish present in the tank
    for (int i = 0; i < fishes.length; i++)
      if (fishes[i] != null)
        fishes[i].draw();
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    // traverse the decorations array and start dragging a decoration if the mouse is over it
    for (int i = 0; i < decorations.length; i++) {
      if (decorations[i] != null && decorations[i].isMouseOver()) {
        decorations[i].startDragging();
        break; // only the decoration at the lowest index will start dragging if there are decorations
               // overlapping
      }
    }

    // traverse the fishes array and start dragging a fish if the mouse is over it
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null && fishes[i].isMouseOver()) {
        fishes[i].startDragging();
        break; // only the fish at the lowest index will start dragging if there are fishes
               // overlapping
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased() {
 // traverse the decorations array and stop dragging any decoration
    for (int i = 0; i < decorations.length; i++) {
      if (decorations[i] != null)
        decorations[i].stopDragging();
    }
    
    // traverse the fishes array and stop dragging any fish
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null)
        fishes[i].stopDragging();
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {

    switch (Character.toUpperCase(processing.key)) {
      case 'F': // add a new fish if the maximum numbers of fish allowed to be
                // present in the tank is not reached
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] == null) {
            fishes[i] = new Fish(processing, (float) randGen.nextInt(processing.width),
                (float) randGen.nextInt(processing.height), fishSpeed,
                "images" + File.separator + images[nextImageIndex]);
            nextImageIndex = (nextImageIndex + 1) % images.length;
            break;
          }
        }
        break;
      case 'R': // delete the clicked fish if any
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] != null && fishes[i].isMouseOver()) {
            fishes[i] = null;
            break;
          }
        }
      case 'S': // cause all fish to start swimming
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] != null) {
            fishes[i].startSwimming();
          }

        }
        break;
      case 'X': // cause all fish to stop swimming
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] != null) {
            fishes[i].stopSwimming();
          }
        }
        break;

    }

  }



  /**
   * This main method starts the application
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    // starts the application
    Utility.startApplication();

  }

}
