import java.util.NoSuchElementException;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title:    P10 Binary Bookshelf
//Course:   CS 300 Fall 2021
//
//Author:   Luke Erickson
//Email:    lerickson7@wisc.edu
//Lecturer: Hobbes
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    (name of your pair programming partner)
//Partner Email:   (email address of your programming partner)
//Partner Lecturer's Name: (name of your partner's lecturer)
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//___ Write-up states that pair programming is allowed for this assignment.
//___ We have both read and understand the course Pair Programming Policy.
//___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons:         (identify each by name and describe how they helped)
//Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Defines the functionality for a TreeNode object, meant to make up a binary search tree
 * 
 * @author lukee
 *
 * @param <T> any object
 */
public class TreeNode<T> {
  private T data;
  private TreeNode<T> left;
  private TreeNode<T> right;


  /**
   * Constructs a node w/ no children
   * 
   * @param data object contained w/in node
   */
  public TreeNode(T data) {
    this.data = data;
  }

  /**
   * Constructs a node w/ 2 children
   * 
   * @param data object contained w/in node
   * @param left child
   * @param right child
   */
  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * Getter method for data contained w/in node
   * 
   * @return data w/in node
   */
  public T getData() {
    return data;
  }

  /**
   * Getter method for left child
   * 
   * @return left child
   */
  public TreeNode<T> getLeft() {
    return left;
  }

  /**
   * Getter method for right child
   * 
   * @return right child
   */
  public TreeNode<T> getRight() {
    return right;
  }

  /**
   * Sets a node's left child
   * 
   * @param left child
   */
  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  /**
   * Sets a node's right child
   * 
   * @param right child
   */
  public void setRight(TreeNode<T> right) {
    this.right = right;
  }

  /**
   * Returns a string representation of the node
   */
  public String toString() {
    return data.toString();
  }
}
