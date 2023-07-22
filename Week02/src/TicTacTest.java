
public class TicTacTest {
  /*
   * make a move in tic-tac-toe
   * 
   * Inputs: space ID (1-9), x or o
   * 
   * Typical input: 5, 'o' -> true
   * Illegal input: 10, 'u' -> false
   * 
   */
  
  public static boolean testMakeMove() {
    //in the test method, these variables should be defined in the method itself
    int moveSpace = 5;
    char piece = 'o';
    
    boolean expected = true;
    
    //pretending we have another class called TicTacToe w/ a method called makeMove(m,n)
    //making sure the move is legal
    //if the move is illegal (it does not match the expected outcome), return false
    //else (the move is legal), return true
    if (TicTacToe.makeMove(moveSpace, piece) != expected) {
      return __;
    }
    return ___;
  }
  
}
