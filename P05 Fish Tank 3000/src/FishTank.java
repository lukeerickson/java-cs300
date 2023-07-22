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
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * FishTank creates a graphical user interface and display window meant to look like a fish tank
 * 
 * @author Luke Erickson
 *
 */

public class FishTank extends PApplet {
  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers

  private TankObject log;
  private TankObject ship;
  private TankObject shell;
  private TankObject flower;

  /**
   * Sets the size of this PApplet to 800 width x 600 height
   */
  @Override
  public void settings() {
    size(800, 600);
  }

  // Defines initial environment properties such as screen size and
  // loads the background image and fonts as the program starts.
  // It also initializes all data fields.
  // The above IS NOT a javadoc style method header!
  /**
   * Sets up GUI and creates objects to be interacted with within the display windows
   */
  @Override
  public void setup() {
    // Set and display the title of the display window
    this.getSurface().setTitle("Fish Tank 3000");
    // Set the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER);
    // Set the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS);
    // rectMode(CORNERS) interprets the first two parameters of rect() method
    // as the location of one corner, and the third and fourth parameters as
    // the location of the opposite corner.
    // rect() method draws a rectangle to the display window

    this.focused = true; // Confirms that our Processing program is focused,
    // meaning that it is active and will accept mouse or keyboard input.

    // sets the text alignment to center
    this.textAlign(PApplet.CENTER, PApplet.CENTER);

    // load the background image and store the loaded image to backgroundImage
    // Note that you can call the loadImage() method directly (this.loadImage())
    backgroundImage = loadImage("images" + File.separator + "background.png");

    // create an empty array list of objects
    objects = new ArrayList<TankListener>();

    // set randGen to the reference of a new Random objects
    randGen = new Random();

    // set the display window for TankObject
    TankObject.setProcessing(this);
    
    // add decorations to the tank
    flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
    log = new TankObject(580, 470, "images" + File.separator + "log.png");
    shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
    ship = new TankObject(280, 535, "images" + File.separator + "ship.png");

    objects.add(flower);
    objects.add(log);
    objects.add(shell);
    objects.add(ship);
    
    // add two black fish to the tank
    objects.add(new BlackFish(log, flower));
    objects.add(new BlackFish(shell, flower));
    
    // set the display window for Button
    Button.setProcessing(this);
    
    // add buttons to the display window
    objects.add(new AddBlueFishButton(43, 16));
    objects.add(new AddOrangeFishButton(129, 16));
    objects.add(new AddYellowFishButton(215, 16));
    objects.add(new ClearTankButton(301, 16));
    

  }

  /**
   *Continuously draws and updates the application display window
   */
  @Override
  public void draw() {
    // clear the display window by drawing the background image
    image(backgroundImage, width / 2, height / 2);

    // traverse the objects list and draw each of the objects to this display window
    for (int i = 0; i < objects.size(); i++) {
      objects.get(i).draw();
    }
  }


  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    // traverse the objects list and call mousePressed method
    // of the first object being clicked in the list
    for (int i = 0; i < objects.size(); i++) {
      if (objects.get(i).isMouseOver()) {
        objects.get(i).mousePressed();
        break; // only the object at the lowest index will start dragging if there are objects
               // overlapping
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    // traverse the objects list and call each object's mouseReleased() method
    for (int i = 0; i < objects.size(); i++)
      objects.get(i).mouseReleased();
  }
 
  /**
   * adds an instance of TankListener passed as input to the objects arraylist
   * 
   * @param object to be added to objects arrayList
   */
  public void addObject(TankListener object) {
    objects.add(object);
  }

  /**
   * Removes instances of the class Fish from this tank
   */
  public void clear() {
    for(int i = 0; i < objects.size(); i++) {
      if(objects.get(i) instanceof Fish) {
        objects.remove(i);
        i--;
      }
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  @Override
  public void keyPressed() {
    
    switch (Character.toUpperCase(key)) {
      case 'O': // add a new orange fish
        objects.add(new Fish());
        break;
      case 'Y': // add a new yellow fish of speed 2
        objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
        break;
      case 'B': // add a new blue fish
        objects.add(new BlueFish());
        break; 
      case 'R': // delete the clicked fish if any
        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish && objects.get(i).isMouseOver()) {
            objects.remove(i);
            break;
          }
        }
        break;
      case 'S': // cause all fish to start swimming
        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish)
            ((Fish) objects.get(i)).startSwimming();
        }
        break;
      case 'X': // cause all fish to stop swimming
        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish)
            ((Fish) objects.get(i)).stopSwimming();
        }
        break;
      case 'C': // remove all fish from the tank
        clear();
        break;

    }

  }


  /**
   * This main method starts the application
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    PApplet.main("FishTank"); // do not add any other statement to the main method
    // The PApplet.main() method takes a String input parameter which represents
    // the name of your PApplet class

  }

}
