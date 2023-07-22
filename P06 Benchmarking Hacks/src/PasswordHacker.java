
public class PasswordHacker {
  
  private LockBox toPick;
  private int passwordLength;
  
  /**
   * Creates a new PasswordHacker and calls for the creation of a new lockbox
   * 
   * @param passwordLength of the password to be set
   */
  public PasswordHacker(int passwordLength) {
    this.passwordLength = passwordLength;
    toPick = new LockBox(passwordLength);
  }
  
  /**
   * Obtain the password from the lockbox, and use it to open the lockbox
   * Complexity: O(1)
   * Reasoning: The same number of operations occur regardless of the number of
   * characters in the password
   */
  public void hack() {
    toPick.reset();
    toPick.authenticate(toPick.hackMe());
  }
  
  /**
   * Guess passwords until the lockbox opens
   * Complexity: O(N^2)
   * Reasoning: For each character added to the password, bruteForce() takes an
   * exponentially longer time to run
   */
  public void bruteForce() {
    
    toPick.reset();
    
    // try passwords until the lockbox opens
    for(int i = 0; i < (int) Math.pow(10, passwordLength); i++) {
      toPick.authenticate(generateGuess(i));
      if(toPick.isOpen())
        break;
    }
    
  }
  
  /**
   * Generate a password guess
   * 
   * @param count of attempts gone through
   * @return the password guess
   */
  public String generateGuess(int count) {
    Integer converted = count;
    String temp = converted.toString();     
         
    String guess = "";
    
    // if guess is shorter than passwordLength, add 0's until it is same length as passwordLength
    if(temp.length() < passwordLength)
      for(int i = 0; i < passwordLength - temp.length(); i++)
        guess += "0";
        
    guess += temp;
   
    // if guess is longer than passwordLength, shorten it to passwordLength
    int j = 1;
    
    if(guess.length() > passwordLength) {
      for(int i = guess.length(); i > passwordLength; i--) {
        guess = guess.substring(j);
        j++;
      }       
    }
      
    
    return guess;
    
  }

}
