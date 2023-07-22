
public class ExceptionsDemo {

  public static int getValue(int[] arr, int index) {
    if (index >= 0 && index < arr.length) {
      return arr[index];
    }

    return -1;

  }

  public static double numberFormat() {
    String s = "17";

    // check that:
    // s is not blank
    // every char in s is a digit

    boolean allDigits = true;

    //for loop is skipped b/c i always equals 0
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i)))
        allDigits = false;
    }

    //you gotta check A LOT of stuff to make sure we return what we want to return
    //this is why exception handling is a thing!
    if (!s.isBlank() && allDigits)
      return Double.parseDouble(s);
    
    return -1;
  }

  public static void main(String[] args) {
    // types of exceptions:
    // array index out of bounds
    // null pointer <-- let's try it!
    // arithmetic (divide by zero)
    // number format
    // illegal argument
    // file not found
    // i/o
    // stack overflow
    // end of file
    // runtime

    int[] badArray = null;
    //System.out.print(getValue(badArray, 0));
    
    System.out.println(numberFormat());

  }
}
