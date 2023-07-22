
public class Treeversals {

  // left - self - right
  public static String inorder(Object root) {
    String result = "";
    // base case: root is a leaf
    // return root.toString
    // base case: root is null
    // return empty String
    
    // recursive case
    // result = inorder(root's left if it exists)
    // result += root.toString
    // result += inorder(root's right if it exists)
    return result;
  }
  
  // self - left - right
  public static String preorder(Object root) {
    String result = "";
    // base case: root is a leaf
    // return root.toString
    // base case: root is null
    // return empty String
    
    // recursive case
    // result += root.toString
    // result += preorder(root's left)
    // result += preorder(root's right)
    return result;
  }
  
  // left - right - self
  public static String postorder(Object root) {
    String result = "";
    // base case: root is null
    // return empty String
    
    // recursive case
    // result += post(left)
    // result += post(right)
    // result += root
    return result;
  }
  
}
