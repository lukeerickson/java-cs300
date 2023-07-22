//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Folder Explorer
// Course: CS 300 Fall 2021
//
// Author: Luke Erickson
// Email: lerickson7@wisc.edu
// Lecturer: Hobbes
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
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * Provides a user interface to explore and search for items within a folder
 * 
 * @author luke erickson
 *
 */
public class FolderExplorer {
  /**
   * Iteratively looks through currentDirectory and returns an arrayList of the names of its
   * contents
   * 
   * @param currentDirectory: the file we are looking through
   * @return an ArrayList of the names of the contents of currentDirectory
   * @throws NotDirectoryException if currentDirectory is not a directory or is null
   */
  public static ArrayList<String> getContents(File currentDirectory) throws NotDirectoryException {

    // throw an exception if currentDirectory is not a directory or is null
    if (!currentDirectory.isDirectory() || currentDirectory == null)
      throw new NotDirectoryException("The given file is not a directory");

    ArrayList<String> str = new ArrayList<String>();

    // search through currentDirectory and add the name of each file to str
    for (int i = 0; i < currentDirectory.list().length; i++) {
      str.add(currentDirectory.list()[i]);
    }

    return str;

  }

  /**
   * Recursively looks through currentDirectory and returns an ArrayList of all of its contents as
   * well as the contents of all sub-directories
   * 
   * @param currentDirectory: the file we are looking through
   * @return an ArrayList of the names of the deep contents of currentDirectory
   * @throws NotDirectoryException if currentDirectory is not a directory or is null
   */
  public static ArrayList<String> getDeepContents(File currentDirectory)
      throws NotDirectoryException {

    // throw an exception if currentDirectory is not a directory or is null
    if (!currentDirectory.isDirectory() || currentDirectory == null)
      throw new NotDirectoryException("The given file is not a directory");

    ArrayList<String> str = new ArrayList<String>();

    // search through currentDirectory and add the name of each file to str
    for (int i = 0; i < currentDirectory.list().length; i++) {
      // base case --> if the given index is a file, add it to str
      if (currentDirectory.listFiles()[i].isFile())
        str.add(currentDirectory.list()[i]);
      // recursive case --> if the given index is a directory, call getDeepContents
      // to search through that directory
      else
        str.addAll(getDeepContents(currentDirectory.listFiles()[i]));
    }

    return str;

  }

  /**
   * Recursively searches through the given currentDirectory and its sub-directories for a file
   * whose name matches fileName
   * 
   * @param currentDirectory: the file we are looking through
   * @param fileName:         the name of the file we are searching for
   * @return the name of the file found
   * @throws NoSuchElementException if currentDirectory is not a directory or is null
   */
  public static String lookupByName(File currentDirectory, String fileName)
      throws NoSuchElementException {

    // throw an exception if currentDirectory is not a directory or is null,
    // or if fileName amounts to null
    if (fileName == null || !currentDirectory.isDirectory() || currentDirectory == null)
      throw new NoSuchElementException("The given element doesn't exist");

    // call helper method to recursively search for fileName
    String str = lookupByNameHelper(currentDirectory, fileName);

    // if the file isn't found, throw an exception
    if (str.equals(""))
      throw new NoSuchElementException("This file does not exist");

    return str;

  }

  private static String lookupByNameHelper(File currentDirectory, String fileName) {

    String str = "";

    // search through currentDirectory and look for the given file
    for (int i = 0; i < currentDirectory.list().length; i++) {
      // base case --> if the given index is a file, check if it has the same name as fileName
      if (currentDirectory.listFiles()[i].isFile()) {
        if (currentDirectory.listFiles()[i].getName().equals(fileName)) {
          return currentDirectory.listFiles()[i].getPath();
        }

      }
      // recursive case --> if the given index is a directory, call lookupByName
      // to search through that directory
      else
        str += lookupByNameHelper(currentDirectory.listFiles()[i], fileName);
    }

    return str;
  }

  /**
   * Recursively searches through the given currentDirectory and its sub-directories for files whose
   * names contains fileName
   * 
   * @param currentDirectory: the file we are searching through
   * @param key:              the keyword we are looking for
   * @return an ArrayList containing the names of the files matching the key
   * @throws NotDirectoryException if currentDirectory is not a directory or is null
   */
  public static ArrayList<String> lookupByKey(File currentDirectory, String key)
      throws NotDirectoryException {

    // throw an exception if currentDirectory is not a directory or is null
    if (!currentDirectory.isDirectory() || currentDirectory == null)
      throw new NotDirectoryException("The given file is not a directory");

    ArrayList<String> str = new ArrayList<String>();

    // search through currentDirectory and add the name of matching files to str
    for (int i = 0; i < currentDirectory.list().length; i++) {
      // base case --> if the given index matches the key, add it to str
      if (currentDirectory.listFiles()[i].isFile()) {
        if (currentDirectory.listFiles()[i].getName().contains(key)) {
          str.add(currentDirectory.listFiles()[i].getName());
        }
      }
      // recursive case --> if the given index is a directory, call lookupByKey
      // to search through that directory
      else
        str.addAll(lookupByKey(currentDirectory.listFiles()[i], key));
    }

    return str;

  }

  /**
   * Recursively searches through the given currentDirectory and its sub-directories for files whose
   * size are between sizeMin and sizeMax
   * 
   * @param currentDirectory: the file we are searching through
   * @param sizeMin:          minimum file size
   * @param sizeMax:          maximum file size
   * @return an ArrayList of files within the given size parameters
   * @throws NotDirectoryException if currentDirectory is not a directory or is null
   */
  public static ArrayList<String> lookupBySize(File currentDirectory, long sizeMin, long sizeMax)
      throws NotDirectoryException {

    // throw an exception if currentDirectory is not a directory or is null
    if (!currentDirectory.isDirectory() || currentDirectory == null)
      throw new NotDirectoryException("The given file is not a directory");

    ArrayList<String> str = new ArrayList<String>();

    // search through currentDirectory and add the name of each file to str
    for (int i = 0; i < currentDirectory.list().length; i++) {
      // base case --> if the given index is the correct size, add it to str
      if (currentDirectory.listFiles()[i].isFile()) {
        // System.out.println(currentDirectory.listFiles()[i].length());
        if (currentDirectory.listFiles()[i].length() >= sizeMin
            && currentDirectory.listFiles()[i].length() <= sizeMax) {
          str.add(currentDirectory.list()[i]);

        }
      }

      // recursive case --> if the given index is a directory, call lookupBySize
      // to search through that directory
      else
        str.addAll(lookupBySize(currentDirectory.listFiles()[i], sizeMin, sizeMax));
    }

    return str;
  }

}
