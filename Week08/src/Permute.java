import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lukee
 *
 */
public class Permute {
  
  public static int count = 0;

  /**
   * Problem: come with all of the permutations of a given string ('abcde')
   * 
   * Base case: one letter (all permutations of a are a)
   * Recursive case: hold one letter constant, permute the rest
   * 
   */
  
  public static void permute(String fixed, String toPermute) {
    // base case
    if(toPermute.length() == 1) {                           
      count++;
      System.out.println(fixed+toPermute + count);
    }
      
    // recursive case --> chop off different letters from toPermute and add them to fixed
    else {
      for(int i = 0; i < toPermute.length(); i++) {
        permute(fixed + toPermute.charAt(i), toPermute.substring(0,i) + toPermute.substring(i+1));       
      }
    }
  }
  
  public static void main(String[] args) {
    permute("", "abcde");

  }

}
