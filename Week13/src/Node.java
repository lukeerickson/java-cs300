
public class Node {
  
  // data fields
  private Integer data;
  private Node left;
  private Node right;
  
  // constructor
  public Node(Integer i) {
    data = i;
    left = null;
    right = null;
  }
  
  public Node(Integer i, Node left, Node right) {
    data = i;
    this.left = left;
    this.right = right;
  }
  
  // accessors
  public Integer getData() {
    return data;
  }
  
  public Node getLeft() {
    return left;
  }
  
  public Node getRight() {
    return right;
  }
  
  // mutators
  public void setLeft(Node newLeft) {
    left = newLeft;
  }
  
  public void setRight(Node newRight) {
    right = newRight;
  }
}
