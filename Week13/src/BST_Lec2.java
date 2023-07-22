
public class BST_Lec2 {
  
  // data field
  private Node root;
  private int size;
  
  // constructor for completeness
  public BST_Lec2() {
    root = null;
    size = 0;
  }

  public boolean contains(Integer i) {
    return containsHelper(i, root);
  }
  
  private boolean containsHelper(Integer i, Node current) {
    // base cases:
    // current is null, done, failed
    if (current == null) return false;
    // current data = i, done, success
    if (current.getData() == i) return true;
    
    // recursive cases:
    // current data < i, go right
    if (current.getData() < i) return containsHelper(i, current.getRight());
    // current data > i, go left
    if (current.getData() > i) return containsHelper(i, current.getLeft());
    
    return false; // this will never actually happen
  }
  
  public void insertNode(Integer i) {
    // special case: empty tree
    if (root == null) {
      root = new Node(i);
      size++;
    }
    else {
      insertHelper(i, root);
    }
  }
  
  public void insertHelper(Integer i, Node current) {
    if (i < current.getData()) {
      // left
      if (current.getLeft() == null) {
        current.setLeft(new Node(i));
      }
      else {
        insertHelper(i, current.getLeft());
      }
    }
    else if (i > current.getData()) {
      // right
      if (current.getRight() == null) {
        current.setRight(new Node(i));
      }
      else {
        insertHelper(i, current.getRight());
      }
    }
    else {
      return;
    }
  }
  
  public static void main(String[] args) {
    BST_Lec2 bst = new BST_Lec2();
    bst.root = new Node(5);
    
    // build left subtree
    bst.root.setLeft(new Node(3, new Node(1), new Node(4)));
    // build right subtree
    bst.root.setRight(new Node(7, new Node(6), new Node(9, new Node(8), new Node(10))));
    
    System.out.println("BST contains 2: "+bst.contains(2));
    System.out.println("BST contains 6: "+bst.contains(6));
    
    bst.insertNode(2);
    System.out.println("BST contains 2: "+bst.contains(2));
  }
  
}
