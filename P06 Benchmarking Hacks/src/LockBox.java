import java.util.Random;

public class LockBox {
  protected static Random randGen;
  private String password;
  private boolean isOpen;
  
  /**
   * Creates a new LockBox and generates its password
   * 
   * @param passwordLength
   */
  public LockBox(int passwordLength) {
    if(randGen == null)
      randGen = new Random();
    if(passwordLength <= 0)
      throw new IllegalArgumentException("Invalid password length");
    
    // generate a random number of the proper length passwordLength
    int temp = randGen.nextInt((int) Math.pow(10, passwordLength));
    //System.out.println("password" + temp);
    Integer converted = temp;   
    this.password = converted.toString();
    
  }
  
  /**
   * opens the lockbox if the guess is correct
   * 
   * @param guess at figuring out the password
   */
  public void authenticate(String guess) {
    if(guess.equals(password))
      isOpen = true;
  }
  
  /**
   * @return lockbox's password
   */
  public String hackMe() {
    return password;
  }
  
  /**
   * @return whether the lockbox is unlocked or not
   */
  public boolean isOpen() {
    return isOpen;
  }
  
  /**
   * locks the lockbox
   */
  public void reset() {
    isOpen = false;
  }
}