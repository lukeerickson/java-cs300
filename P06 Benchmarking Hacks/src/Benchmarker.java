
public class Benchmarker {

  /**
   * Times how long it takes to brute force the box open
   * 
   * @param ph is the PasswordHacker to be used
   * @return the length of time it takess to open the box
   */
  public static long timeBruteForce(PasswordHacker ph) {
    long start = System.currentTimeMillis();
    ph.bruteForce();
    long end = System.currentTimeMillis();
    return end - start;
  }
  
  /**
   * Times how long it takes to hack the box open
   * 
   * @param ph is the PasswordHacker to be used
   * @return the length of time it takes to open the box
   */
  public static long timeHack(PasswordHacker ph) {
    long start = System.currentTimeMillis();
    ph.hack();
    long end = System.currentTimeMillis();
    return end - start;
  }
  
  /**
   * Compares the time it takes to brute force vs hack the password
   * 
   * @param passwordLength of the password to be guessed
   * @param numRuns is the number of times each method is tried
   * @return a message stating the different times it took each method to run
   */
  public static String race(int passwordLength, int numRuns) {
    long brute = 0;
    long hack = 0;
    
    // run each method an amount of times equivalent to numRuns
    for(int i = 0; i < numRuns; i++) {
      PasswordHacker ph = new PasswordHacker(passwordLength);
      brute += timeBruteForce(ph);
      hack += timeHack(ph);
    }
    
    // average each time out
    brute /= numRuns;
    hack /= numRuns;
    
    return "Brute force " + passwordLength + ": " + brute + "\nHack " + passwordLength + ": " + hack;
  }
  
  /**
   * Starts the application
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
      System.out.println(race(7,10));
   }

}
