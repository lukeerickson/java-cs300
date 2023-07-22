
public class Averages {

  /**
   * strips a numeric value out of a string
   * 
   * @param s: the string to process
   * @return: the numeric value as a double
   * @throws NumberFormatException    if the string isn't formatted correctly
   * @throws IllegalArgumentException if the string doesn't start with a "V"
   */
  private static double getValue(String s)
      throws NumberFormatException, IllegalArgumentException, NullPointerException {
    // check is s is null
    if (s == null)
      throw new NullPointerException();

    // check that the first character is a "V"
    // could cause StringIndexOutOfBounds, NullPointer

    // putting "s.length() < 2" first prevents a NullPointer exception
    // so that "s.charAt(0)" never runs
    if (s.length() < 2)
      throw new IllegalArgumentException("Too short");
    if (s.charAt(0) != 'V')
      throw new IllegalArgumentException("Didn't start with 'V'");

    // strip off the leading character
    s = s.substring(1);

    // convert the rest to an double: could cause a NumberFormatException
    // we can't return an error message, however, so we'll deal with this elsewhere
    double result = Double.parseDouble(s);

    // return this double
    return result;
  }

  private static double getAverage(String[] array) throws Exception {
    // add up all the values in the array
    double total = 0;
    int numValues = 0;

    for (int i = 0; i < array.length; i++) {
      try {
        total += getValue(array[i]); // could cause exceptions!
        numValues++; // only happens if getValue() runs without error
      } catch (NullPointerException npe) {
        // skip that value: index i was empty
      } catch (NumberFormatException nfe) {
        // skip this value: wasn't a double
      } catch (IllegalArgumentException iae) {
        // skip this value: value present but not legal
        System.out.println(iae.getMessage());
      }
    }

    if (numValues == 0)
      throw new ArithmeticException("Not a single element survived");

    // divide by the length
    total /= numValues;

    // return the result
    return total;

  }

  public static String getAverages(String[] array1, String[] array2) throws Exception {
    // get the average value in each array individually
    double val1 = getAverage(array1);
    double val2 = getAverage(array2);

    // combine them into a single string
    String result = "one: " + val1 + "\ntwo: " + val2;

    // return this string
    return result;
  }

  public static void main(String[] args) throws Exception {
    // Create 2 arrays of string grades
    String[] one = new String[] {"V4.7", "V32.1", "V-124"};
    String[] two = new String[] {"V1", "V0.25", "V37", "VIX"};

    // get the average of both
    String result = getAverages(one, two);

    // display the result
    System.out.println(result);
  }
}
