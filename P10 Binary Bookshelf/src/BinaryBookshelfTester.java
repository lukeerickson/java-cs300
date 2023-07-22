import java.util.ArrayList;

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
 * Tests the BinaryBookshelf class 
 * 
 * @author lukee
 *
 */
public class BinaryBookshelfTester {

  /**
   * Ensures that TreeNode class works as expected
   * 
   * @return true if TreeNode's methods work as expected
   */
  public static boolean testTreeNode() {
    try {
      // scenario 1 - TreeNode w/ no children
      TreeNode<String> t = new TreeNode<String>("billy");

      if (t.getLeft() != null)
        return false;
      if (t.getRight() != null)
        return false;
      if (!t.getData().equals("billy"))
        return false;
      if (!t.toString().equals("billy"))
        return false;

      // scenario 2 - a simple collection of tree nodes
      TreeNode<String> a = new TreeNode<String>("apple");
      TreeNode<String> b = new TreeNode<String>("banana");
      a.setLeft(b);

      if (!a.getLeft().equals(b))
        return false;
      if (b.getLeft() != null)
        return false;

      a.setLeft(null);
      if (a.getLeft() != null)
        return false;

      // scenario 3 - multi argument constructor
      TreeNode<String> y = new TreeNode<String>("y");
      TreeNode<String> z = new TreeNode<String>("z");
      TreeNode<String> x = new TreeNode<String>("x", y, z);

      if (!x.getLeft().equals(y))
        return false;
      if (!x.getRight().equals(z))
        return false;

    } catch (Exception e) {
      // unexpected exception
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of an empty tree
   * 
   * @return true if BinaryBookshelf's methods work
   */
  public static boolean testEmptyTree() {
    try {
      // scenario 1 - invalid constructor inputs
      // empty sortlist array
      Attribute[] s1 = {};
      try {
        BinaryBookshelf b1 = new BinaryBookshelf(s1);
        // System.out.println("muj");
        return false;
      } catch (IllegalArgumentException e) {
        // exception expected
      }

      // sortlist array of length other than 4
      Attribute[] s2 = new Attribute[] {Attribute.AUTHOR, Attribute.TITLE};
      try {
        BinaryBookshelf b2 = new BinaryBookshelf(s2);
        return false;
      } catch (IllegalArgumentException e) {
        // exception expected
      }

      // 2 elements that are the same
      Attribute[] s3 =
          new Attribute[] {Attribute.AUTHOR, Attribute.TITLE, Attribute.AUTHOR, Attribute.ID};
      try {
        BinaryBookshelf b3 = new BinaryBookshelf(s3);
        return false;
      } catch (IllegalArgumentException e) {
        // exception expected
      }

      // something other than Attribute.AUTHOR at index 0
      Attribute[] s4 =
          new Attribute[] {Attribute.PAGECOUNT, Attribute.TITLE, Attribute.AUTHOR, Attribute.ID};
      try {
        BinaryBookshelf b4 = new BinaryBookshelf(s4);
        return false;
      } catch (IllegalArgumentException e) {
        // exception expected
      }

      // scenario 2 - valid input
      Attribute[] s5 =
          new Attribute[] {Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT, Attribute.ID};
      BinaryBookshelf b5 = new BinaryBookshelf(s5);

      if (b5.size() != 0)
        return false;
      if (b5.isEmpty() != true)
        return false;
      if (!b5.toString().equals(""))
        return false;
      if (b5.getRoot() != null)
        return false;
      //if (!b5.getAttributeOrder()
          //.equals("1: " + s5[0] + "\n2: " + s5[1] + "\n3: " + s5[2] + "\n4: " + s5[3] + "\n"))
        //return false;
      if (b5.contains(new Book("blorg", 376)))
        return false;
      if (!b5.getBooksByAuthor​("jorg").equals(new ArrayList<Book>()))
        return false;

    } catch (Exception e) {
      // unexpected exception
      return false;
    }

    return true;
  }

  /**
   * Makes sure that the insertBook() method works as expected
   * 
   * @return true if method works as expected
   */
  public static boolean testInsertBook() {
    try {
      // scenario 1 - insert into empty tree
      Attribute[] s1 =
          new Attribute[] {Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT, Attribute.ID};
      BinaryBookshelf b1 = new BinaryBookshelf(s1);

      if (b1.size() != 0)
        return false;
      if (b1.isEmpty() != true)
        return false;

      Book m = new Book("mumbo", 8, "jean", "billy");
      b1.insertBook(m);

      if (b1.isEmpty())
        return false;
      if(b1.size() != 1)
        return false;
      if (!b1.getRoot().getData().equals(m))
        return false;
      
      // scenario 2 - insert another, smaller element into the tree
      Book j = new Book("jebediah", 19, "garcia", "patrick");
      b1.insertBook(j);

      if (!b1.getRoot().getLeft().getData().equals(j))
        return false;
      if(b1.size() != 2)
        return false;

      // scenario 3 - insert a book with the same author as the first book
      Book z = new Book("zebras for free", 2933, "jean", "billy");
      b1.insertBook(z);

      if (!b1.getRoot().getRight().getData().equals(z))
        return false;

      // scenario 4 - insert an identical book
      try {
        b1.insertBook(j);
        return false;
      } catch (IllegalArgumentException e) {
        // exception expected
      }

    } catch (Exception e) {
      // unexpected exception
      System.out.println("woah");
      return false;
    }

    return true;
  }

  /**
   * Makes sure that the contains() method works as expected
   * 
   * @return true if contains() works as expected
   */
  public static boolean testContains() {
    try {
      // scenario 1 - non-recursive case
      Attribute[] s =
          new Attribute[] {Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT, Attribute.ID};
      BinaryBookshelf b = new BinaryBookshelf(s);
      Book l = new Book("lemons", 1, "lemons", "lemons");
      b.insertBook(l);

      if (!b.contains(l))
        return false;
      if (b.contains(new Book("blorng", 376)))
        return false;

      // scenario 2 - recursive case
      // create 5 books and 5 nodes
      Book c = new Book("c", 12, "c", "c");
      Book y = new Book("y", 18, "y", "y");
      Book a = new Book("a", 13, "a", "a");
      Book e = new Book("e", 2, "e", "e");
      TreeNode<Book> tl = b.getRoot();
      TreeNode<Book> tc = new TreeNode<Book>(c);
      TreeNode<Book> ty = new TreeNode<Book>(y);
      TreeNode<Book> ta = new TreeNode<Book>(a);
      TreeNode<Book> te = new TreeNode<Book>(e);

      // create binary search tree (in proper order, by author)
      tl.setLeft(tc);
      tl.setRight(ty);
      tc.setLeft(ta);
      tc.setRight(te);

      if (!b.contains(l))
        return false;
      if (!b.contains(a))
        return false;
      if (!b.contains(e))
        return false;
      if (b.contains(new Book("blorng", 376)))
        return false;

    } catch (Exception e) {
      // exception unexpected
      System.out.println("error");
      return false;
    }

    return true;
  }

  /**
   * Tests the getBooksByAuthor() method
   * 
   * @return true if getBooksByAuthor() works as expected
   */
  public static boolean testGetBooksByAuthor() {
    try {
      // scenario 1 - non-recursive case
      Attribute[] s =
          new Attribute[] {Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT, Attribute.ID};
      BinaryBookshelf b = new BinaryBookshelf(s);
      Book l = new Book("harry potter", 200, "jk", "rowling");
      b.insertBook(l);

      ArrayList<Book> arrayList1 = new ArrayList<Book>();
      arrayList1 = b.getBooksByAuthor​(l.getAuthor());

      if (arrayList1.size() != 1)
        return false;

      ArrayList<Book> arrayList2 = new ArrayList<Book>();
      arrayList2 = b.getBooksByAuthor​("ben");

      if (arrayList2.size() != 0)
        return false;

      // scenario 2 - recursive case
      // create 5 books and 5 nodes
      Book c = new Book("c", 12, "c", "c");
      Book y = new Book("y", 18, "y", "y");
      Book a = new Book("a", 13, "c", "c");
      Book e = new Book("e", 2, "e", "e");
      TreeNode<Book> tl = b.getRoot();
      TreeNode<Book> tc = new TreeNode<Book>(c);
      TreeNode<Book> ty = new TreeNode<Book>(y);
      TreeNode<Book> ta = new TreeNode<Book>(a);
      TreeNode<Book> te = new TreeNode<Book>(e);
      // tc and ta have the same author

      // create binary search tree (in proper order, by author)
      tl.setLeft(tc);
      tl.setRight(ty);
      tc.setLeft(ta);
      tc.setRight(te);
      
      ArrayList<Book> arrayList3 = b.getBooksByAuthor​(y.getAuthor());
      if (arrayList3.size() != 1)
        return false;
      
      ArrayList<Book> arrayList4 = b.getBooksByAuthor​(c.getAuthor());
      if (arrayList4.size() != 2)
        return false;
      
      ArrayList<Book> arrayList5 = b.getBooksByAuthor​("tony");
      if (arrayList5.size() != 0)
        return false;
      
    } catch (Exception e) {
      // unexpected exception
      return false;
    }

    return true;
  }

  /**
   * Main method for the BinaryBookshelfTester class
   * 
   * @param args 
   */
  public static void main(String[] args) {
    System.out.println(testInsertBook());
  }

}
