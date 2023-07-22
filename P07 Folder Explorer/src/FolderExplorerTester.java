//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P07 Folder Explorer
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
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.List;
import java.util.NoSuchElementException;
import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tests to see that FolderExplorer's methods function as expected
 * 
 * @author luke erickson
 *
 */
public class FolderExplorerTester {

  /**
   * Tests to see that FileExplorer's getContents() method works correctly
   * 
   * @param folder: directory for getContents() to act upon
   * @return true if getContents() functions as expected, false otherwise
   */
  public static boolean testGetContents(File folder) {
    try {
      // Scenario 1
      // list the basic contents of the cs300 folder
      ArrayList<String> listContent = FolderExplorer.getContents(folder);

      // expected output must contain "exams preparation", "grades",
      // "lecture notes", "programs", "reading notes", "syllabus.txt",
      // and "todo.txt" only.
      String[] contents = new String[] {"exams preparation", "grades", "lecture notes", "programs",
          "reading notes", "syllabus.txt", "todo.txt"};

      List<String> expectedList = Arrays.asList(contents);

      // check the size and the contents of the output
      if (listContent.size() != 7) {
        System.out.println("Problem detected: cs300 folder must contain 7 elements.");
        return false;
      }

      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of cs300 folder.");
          return false;
        }
      }

      // Scenario 2 - list the contents of the grades folder
      File f = new File(folder.getPath() + File.separator + "grades");
      listContent = FolderExplorer.getContents(f);

      if (listContent.size() != 0) {
        System.out.println("Problem detected: grades folder must be empty.");
        return false;
      }

      // Scenario 3 - list the contents of the p02 folder
      f = new File(folder.getPath() + File.separator + "programs" + File.separator + "p02");
      listContent = FolderExplorer.getContents(f);

      if (listContent.size() != 1 || !listContent.contains("FishTank.java")) {
        System.out.println(
            "Problem detected: p02 folder must contain only " + "one file named FishTank.java.");
        return false;
      }

      // Scenario 4 - List the contents of a file
      f = new File(folder.getPath() + File.separator + "todo.txt");

      try {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getContents() must "
            + "throw a NotDirectoryException if it is provided an input which is not"
            + "a directory.");
        return false;
      } catch (NotDirectoryException e) { // catch only the expected exception
        // no problem detected
      }

      // Scenario 5 - List the contents of not found directory/file
      f = new File(folder.getPath() + File.separator + "music.txt");

      try {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getContents() must "
            + "throw a NotDirectoryException if the provided File does not exist.");
        return false;
      } catch (NotDirectoryException e) {
        // behavior expected
      }
    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests to see that the base case of FileExplorer's getDeepContents() method works correctly
   * 
   * @param folder: directory for getDeepContents() to act upon
   * @return true if the base case of getDeepContents() functions as expected, false otherwise
   */
  public static boolean testDeepGetContentsBaseCase(File folder) {
    try {
      // Scenario 1
      // list the basic contents of the reading notes folder
      ArrayList<String> listContent = FolderExplorer.getDeepContents(folder);

      String[] contents =
          new String[] {"zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt", "zyBooksCh4.txt"};
      List<String> expectedList = Arrays.asList(contents);

      // check the size and the contents of the output
      if (listContent.size() != 4) {
        System.out.println("Problem detected: reading notes folder must contain 4 files.");
        return false;
      }

      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of reading notes folder.");
          return false;
        }
      }

    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getDeepContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests to see that the recursive case of FileExplorer's getDeepContents() method works correctly
   * 
   * @param folder: directory for getDeepContents() to act upon
   * @return true if the recursive case of getDeepContents() functions as expected, false otherwise
   */
  public static boolean testDeepListRecursiveCase(File folder) {
    try {
      // Scenario 1
      // list the basic contents of the cs300 folder
      ArrayList<String> listContent = FolderExplorer.getDeepContents(folder);

      // expected output must contain "codeSamples.java", "outline.txt", "ExceptionHandling.txt",
      // "proceduralProgramming.txt", "UsingObjects.txt", "CreatingClasses.txt", "Generics.txt",
      // "Inheritance.txt", "AlgorithmAnalysis.txt", "Recursion.txt", "Sorting.txt",
      // "ClimbingTracker.java", "ClimbingTrackerTester.java", "FishTank.java",
      // "ExceptionalClimbing.java", "ExceptionalClimbingTester.java", "Program01.pdf",
      // "Program02.pdf", "Program03.pdf", "zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt",
      // "zyBooksCh4.txt", "syllabus.txt", "todo.txt" only.
      String[] contents = new String[] {"codeSamples.java", "outline.txt", "ExceptionHandling.txt",
          "proceduralProgramming.txt", "UsingObjects.txt", "CreatingClasses.txt", "Generics.txt",
          "Inheritance.txt", "AlgorithmAnalysis.txt", "Recursion.txt", "Sorting.txt",
          "ClimbingTracker.java", "ClimbingTrackerTester.java", "FishTank.java",
          "ExceptionalClimbing.java", "ExceptionalClimbingTester.java", "Program01.pdf",
          "Program02.pdf", "Program03.pdf", "zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt",
          "zyBooksCh4.txt", "syllabus.txt", "todo.txt"};

      List<String> expectedList = Arrays.asList(contents);

      // check the size and the contents of the output
      if (listContent.size() != 25) {
        System.out.println("Problem detected: cs300 folder must contain 25 files.");
        return false;
      }

      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of cs300 folder.");
          return false;
        }
      }

      // Scenario 2 - list the contents of the grades folder
      File f = new File(folder.getPath() + File.separator + "grades");
      listContent = FolderExplorer.getContents(f);

      if (listContent.size() != 0) {
        System.out.println("Problem detected: grades folder must be empty.");
        return false;
      }

      // Scenario 3 - list the contents of the p02 folder
      f = new File(folder.getPath() + File.separator + "programs" + File.separator + "p02");
      listContent = FolderExplorer.getContents(f);

      if (listContent.size() != 1 || !listContent.contains("FishTank.java")) {
        System.out.println(
            "Problem detected: p02 folder must contain only " + "one file named FishTank.java.");
        return false;
      }

      // Scenario 4 - List the contents of a file
      f = new File(folder.getPath() + File.separator + "todo.txt");

      try {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getDeepContents() must "
            + "throw a NotDirectoryException if it is provided an input which is not"
            + "a directory.");
        return false;
      } catch (NotDirectoryException e) { // catch only the expected exception
        // no problem detected
      }

      // Scenario 5 - List the contents of not found directory/file
      f = new File(folder.getPath() + File.separator + "music.txt");

      try {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getDeepContents() must "
            + "throw a NotDirectoryException if the provided File does not exist.");
        return false;
      } catch (NotDirectoryException e) {
        // behavior expected
      }
    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getDeepContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests to see that FileExplorer's lookupByName() method works correctly
   * 
   * @param folder: directory for lookupByName() to act upon
   * @return true if lookupByName() functions as expected, false otherwise
   */
  public static boolean testLookupByFileName(File folder) {

    try {
      // Scenario 1
      // list the basic contents of the reading notes folder
      String str = FolderExplorer.lookupByName(folder, "Sorting.txt");

      if (!str.equals("cs300\\lecture notes\\unit3\\Sorting.txt"))
        return false;

      // Scenario 2 - List the contents of not found directory/file
      File f = new File(folder.getPath() + File.separator + "music.txt");

      try {
        str = FolderExplorer.lookupByName(f, "Sorting.txt");
        System.out.println("Problem detected: Your FolderExplorer.lookupByName() must "
            + "throw a NoSuchElementException if the provided File does not exist.");
        return false;
      } catch (NoSuchElementException e) {
        // behavior expected
      }
      
      // Scenario 3 - try to find a file that doesn't exist
      try {
        str = FolderExplorer.lookupByName(folder, "boingo.txt");
        System.out.println("Problem detected: Your FolderExplorer.lookupByName() must "
            + "throw a NoSuchElementException if the provided File does not exist.");
        return false;
      } catch (NoSuchElementException e) {
        // behavior expected
      }

    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.lookupByName() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests to see that the base case of FileExplorer's lookupByKey() method works correctly
   * 
   * @param folder: directory for lookupByKey() to act upon
   * @return true if the base case of lookupByKey() functions as expected, false otherwise
   */
  public static boolean testLookupByKeyBaseCase(File folder) {
    try {
      // Scenario 1
      // list the basic contents of the reading notes folder
      ArrayList<String> listContent = FolderExplorer.lookupByKey(folder, ".txt");

      String[] contents =
          new String[] {"zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt", "zyBooksCh4.txt"};
      List<String> expectedList = Arrays.asList(contents);

      // check the size and the contents of the output
      if (listContent.size() != 4) {
        System.out.println("Problem detected: reading notes folder must contain 4 files.");
        return false;
      }

      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of reading notes folder.");
          return false;
        }
      }
      
   // Scenario 2
      // use a key that won't find anything
      ArrayList<String> listContent2 = FolderExplorer.lookupByKey(folder, "CDJFDJVDVJ");

      contents =
          new String[] {};
      expectedList = Arrays.asList(contents);

      // check the size and the contents of the output
      if (listContent2.size() != 0) {
        System.out.println("Problem detected: folder must contain 0 files.");
        return false;
      }

      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent2.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of reading notes folder.");
          return false;
        }
      }
   // Scenario 3 - List the contents of not found directory/file
      File f = new File(folder.getPath() + File.separator + "music.txt");

      try {
        ArrayList<String> listContent3 = FolderExplorer.lookupByKey(f, "Sorting.txt");
        System.out.println("Problem detected: Your FolderExplorer.lookupByName() must "
            + "throw a NotDirectoryException if the provided File does not exist.");
        return false;
      } catch (NotDirectoryException e) {
        // behavior expected
      }

    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.lookupByKey() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Tests to see that FileExplorer's lookupBySize() method works correctly
   * 
   * @param folder: directory for lookupBySize() to act upon
   * @return true if lookupBySize() functions as expected, false otherwise
   */
  public static boolean testLookupBySize(File folder) {

    try {
      // Scenario 1
      // list the basic contents of the reading notes folder
      ArrayList<String> listContent = FolderExplorer.lookupBySize(folder, 0, 100);

      String[] contents =
          new String[] {"zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt", "zyBooksCh4.txt"};
      List<String> expectedList = Arrays.asList(contents);

      // check the size and the contents of the output
      if (listContent.size() != 4) {
        System.out.println("Problem detected: reading notes folder must contain 4 files.");
        return false;
      }

      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of reading notes folder.");
          return false;
        }
      }

    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.lookupBySize() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * This main method starts the application
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    File cs300 = new File("cs300");

    System.out.println("testGetContents: " + testGetContents(cs300));
    System.out.println("testDeepGetContentsBaseCase: " + testDeepGetContentsBaseCase(
        new File(cs300.getPath() + File.separator + "reading notes")));
    System.out.println("testDeepGetContentsRecursiveCase: " + testDeepListRecursiveCase(cs300));
    System.out.println("testLookupByFileName: " + testLookupByFileName(cs300));
    System.out.println("testLookupByKeyBaseCase: "
        + testLookupByKeyBaseCase(new File(cs300.getPath() + File.separator + "reading notes")));
    System.out.println("testLookupBySize: "
        + testLookupBySize(new File(cs300.getPath() + File.separator + "reading notes")));
  }

}
