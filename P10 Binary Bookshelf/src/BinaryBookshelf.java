import java.util.ArrayList;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Binary Bookshelf
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
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Defines the functionality for a binary search tree of nodes containing Book objects
 * 
 * @author lukee
 *
 */
public class BinaryBookshelf {
  private TreeNode<Book> root;
  private int size;
  private Attribute[] sortlist;

  /**
   * Constructs an empty bookshelf
   * 
   * @param sortlist defines priority of attributes to compare books against
   */
  public BinaryBookshelf(Attribute[] sortlist) {
    if (sortlist.length != 4 || sortlist[0] != Attribute.AUTHOR)
      throw new IllegalArgumentException("invalid sortlist");

    // count occurrence of each element in sortlist array to ensure that each element is unique
    int idCount = 0;
    int authorCount = 0;
    int titleCount = 0;
    int pageCount = 0;

    for (int i = 0; i < sortlist.length; i++) {
      if (sortlist[i].equals(Attribute.ID))
        idCount++;
      if (sortlist[i].equals(Attribute.AUTHOR))
        authorCount++;
      if (sortlist[i].equals(Attribute.TITLE))
        titleCount++;
      if (sortlist[i].equals(Attribute.PAGECOUNT))
        pageCount++;
    }

    // if an attribute occurs more than once, throw an exception
    if (idCount > 1 || authorCount > 1 || titleCount > 1 || pageCount > 1)
      throw new IllegalArgumentException("array elements are not unique");

    root = null;
    size = 0;
    this.sortlist = sortlist;
  }

  /**
   * Resets the bookshelf
   */
  public void clear() {
    root = null;
    size = 0;
    sortlist = null;
  }

  /**
   * Getter method for size() of the bst
   * Runtime complexity: O(1)
   * 
   * @return number of nodes in the bst
   */
  public int size() {
    return this.size;
  }

  /**
   * Tells us if there are any nodes in the bst
   * Runtime complexity: O(1)
   * 
   * @return true if bst is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Iterates thru sortlist of attributes and compares two book objects based on each attribute
   * 
   * @param one first book
   * @param two second book
   * @return positive int if one > two, negative int if one < two, and 0 if they're equal
   */
  protected int compareToHelper(Book one, Book two) {
    for (int i = 0; i < sortlist.length; i++) {
      if (one.compareTo(two, sortlist[i]) != 0)
        return one.compareTo(two, sortlist[i]);
    }
    return 0;
  }

  /**
   * Searches for the input book Runtime complexity: O(N) --> worst-case complexity is O(N), where N
   * is the height of the tree, because contains() would need to recurse thru each level of the tree
   * 
   * @param book to be search for
   * @return true if book is w/in bst
   */
  public boolean contains(Book book) {
    return containsHelper(book, root);
  }


  /**
   * Recursive helper method, searches for the Book under the current subtree
   * 
   * @param book to be searched for
   * @param current root
   * @return true if book is w/in bst
   */
  protected boolean containsHelper(Book book, TreeNode<Book> current) {
    // base cases:
    // current is null, done, failed
    if (current == null)
      return false;
    // current data = book, done, success
    if (current.getData().equals(book))
      return true;

    // recursive cases:
    // current data < book, go right
    if (current.getData().compareTo(book, Attribute.AUTHOR) < 0)
      return containsHelper(book, current.getRight());
    // current data > book, go left
    if (current.getData().compareTo(book, Attribute.AUTHOR) > 0)
      return containsHelper(book, current.getLeft());

    return false; // this will never actually happen
  }

  /**
   * Iterate thru sortlist arrayList and return a string representation of its contents
   * 
   * @return string representation of sortlist's contents
   */
  public String getAttributeOrder() {
    String str = "";

    for (int i = 0; i < sortlist.length; i++)
      str += i + 1 + ": " + sortlist[i] + "\n";

    return str;
  }

  /**
   * Looks for book's written by a given author
   * 
   * @param authorName to search for
   * @return an arrayList of books written by the given author
   */
  public ArrayList<Book> getBooksByAuthor​(String authorName) {
    return getBooksByAuthorHelper​(authorName, root);
  }

  /**
   * Recursive helper method, searches for books under the given subtree
   * 
   * @param authorName to search for
   * @param current root
   * @return an arrayList of books written by the given author
   */
  protected ArrayList<Book> getBooksByAuthorHelper​(String authorName, TreeNode<Book> current) {
    ArrayList<Book> b = new ArrayList<Book>();

    // base cases:
    // current is null, done
    if (current == null)
      return b;

    // recursive case: add each book in the binary tree to b
    b.add(current.getData());
    b.addAll(getBooksByAuthorHelper​(authorName, current.getLeft()));
    b.addAll(getBooksByAuthorHelper​(authorName, current.getRight()));

    ArrayList<Book> c = new ArrayList<Book>();

    // only return the books written by the desired author
    for (int i = 0; i < b.size(); i++) {
      if (b.get(i).getAuthor().equals(authorName))
        c.add(b.get(i));
    }

    return c;

  }

  /**
   * Returns a string representation of the bst
   * Runtime complexity: O(N) --> worst-case complexity is O(N), where N is the number of nodes in
   * the tree, because each node is visited once
   * @return string version of binary tree
   */
  public String toString() {
    return toStringHelper​(root);
  }

  /**
   * Recursive helper method, looks thru each node in the bst
   * 
   * @param current root
   * @return string representation of current node
   */
  protected String toStringHelper​(TreeNode<Book> current) {
    String str = "";

    if (current == null)
      return str;

    str += current.getData().toString() + "\n";
    str += toStringHelper​(current.getLeft());
    str += toStringHelper​(current.getRight());

    return str;
  }

  /**
   * Getter method for tree's root
   * 
   * @return tree's root
   */
  protected TreeNode<Book> getRoot() {
    return this.root;
  }

  /**
   * Adds a book to the tree in its correct location
   * 
   * @param book to be added to tree
   */
  public void insertBook(Book book) {
    // bookshelf cannot contain duplicate books
    if (this.contains(book))
      throw new IllegalArgumentException("duplicate book");
    insertBookHelper​(book, root);
  }

  /**
   * Recursive helper method, searches for correct place to add book
   * 
   * @param book to be added to tree
   * @param current root
   */
  protected void insertBookHelper​(Book book, TreeNode<Book> current) {

    // base case - root is null
    if (this.root == null) {
      root = new TreeNode<Book>(book);
      size++;
      return;
    }

    // recursive case - move down tree to find correct place to insert new node
    if (compareToHelper(book, current.getData()) < 0) {
      // if left child is null, insert new node here
      if(current.getLeft() == null) {
        TreeNode<Book>left = new TreeNode<Book>(book);
        current.setLeft(left);
        size++;
        return;
      }
      insertBookHelper​(book, current.getLeft());
    }
      
    else if (compareToHelper(book, current.getData()) > 0) {
      // if right child is null, insert new node here
      if(current.getRight() == null) {
        TreeNode<Book>right = new TreeNode<Book>(book);
        current.setRight(right);
        size++;
        return;
      }
      insertBookHelper​(book, current.getRight());
    }
      
  }

}
