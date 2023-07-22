import java.util.ArrayList;
import java.util.Arrays;

/*    0   1   2   3   4   5   6   7   8
 * [ 96, 81, 32, 75, 72, 16,  4, 34, 50, ... ]
 * 
 * Child Nodes:
 * 0: L 1, R 2
 * 1: L 3, R 4
 * 2: L 5, R 6
 * 3: L 7, R 8
 * 4: L 9 (etc)
 * 
 * i: L 2i+1, R 2i+2
 * 
 * odd index = left child
 * 
 * Parent Nodes:
 * 8's parent: 3
 * 7: 3
 * 6: 2
 * 5: 2
 * 4: 1
 * 3: 1
 * 2: 0
 * 1: 0
 * 
 * i: (i-1)/2 because integer division
 */

public class Heap_Lec2 implements PriorityQueueADT<String> {

  // data field
  private ArrayList<String> heap;
  
  public Heap_Lec2() {
    heap = new ArrayList<String>();
  }

  @Override
  public void insert(String newData) {
    // 1. add the newData to the end of the heap
    this.heap.add(newData);
    if (this.heap.size() == 1) return;
    
    // 2. percolate UP if heap was not empty:
    boolean keepSwapping = true;
    int newDataIndex = this.heap.size()-1;
    
    while (keepSwapping) {
      // add a little debugging output:
      System.out.println(Arrays.toString(this.heap.toArray()));
      
      // check newData against parent's value
      int parentIndex = (newDataIndex-1)/2;
      if (this.heap.get(newDataIndex).compareTo(this.heap.get(parentIndex)) > 0) {
        
        // if newData > parent, swap
        String temp = this.heap.get(newDataIndex);
        this.heap.set(newDataIndex, this.heap.get(parentIndex));
        this.heap.set(parentIndex, temp);
        newDataIndex = parentIndex;
        
        // stop if swapped into root
        if (newDataIndex == 0) keepSwapping = false;
      }
      
      // stop if no swap
      else {
        keepSwapping = false;
      }
    }
    
    // add a little debugging output:
    System.out.println(Arrays.toString(this.heap.toArray()));
  }

  @Override
  public String removeBest() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * O(1)
   * Returns the thing at the root node without removing it
   * @return largest string in heap or null if it's empty
   */
  @Override
  public String peekBest() {
    // need an isempty check!
    if (this.heap.isEmpty()) return null;
    return this.heap.get(0);
  }

  /**
   * O(1)
   * Checks whether the heap is empty or not
   * @return true iff the heap is empty
   */
  @Override
  public boolean isEmpty() {
    return this.heap.size() == 0;
  }
  
  public static void main(String[] args) {
    Heap_Lec2 test = new Heap_Lec2();
    
    System.out.println("isEmpty: "+test.isEmpty());
    test.insert("Elias");
    System.out.println("isEmpty: "+test.isEmpty());
    
    test.insert("Jon");
    test.insert("Martin");
  }
  
}
