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

public class Heap_Lec2_v2 implements PriorityQueueADT<String> {

  // data field
  private ArrayList<String> heap;
  
  public Heap_Lec2_v2() {
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
        swap(newDataIndex, parentIndex);
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
    // 1. get the best value out of the root
    String best = this.heap.get(0);
    
    // 2. replace the root with the last leaf
    if (this.heap.size() > 1)
      this.heap.set(0, this.heap.remove(this.heap.size()-1));
    else return this.heap.remove(0);
    
    // 3. percolate DOWN:
    boolean keepSwapping = true;
    int currentIndex = 0;
    while (keepSwapping) {
      
      // - get the child indexes
      int left = 2*currentIndex + 1;
      int right = 2*currentIndex + 2;
      
      if (left >= this.heap.size()) {
        // currentIndex has no children - is a leaf, we're done
        keepSwapping = false;
      }
      else if (this.heap.get(currentIndex).compareTo(this.heap.get(left)) < 0) {
        // will need to swap with greater of left and right children if right exists
        // does right exist
        if (right < this.heap.size()) {
          // if it does, swap with greater of left and right
          int larger = (heap.get(left).compareTo(heap.get(right)) > 0) ? left : right;
          swap(currentIndex, larger);
          currentIndex = larger;
        }
        else {
          // otherwise swap with left, there is no right child
          swap(currentIndex, left);
          keepSwapping = false;
        }
      }
      else if (right < this.heap.size() && 
          this.heap.get(currentIndex).compareTo(this.heap.get(right)) < 0) {
        // will need to swap with RIGHT child
        swap(currentIndex, right);
        currentIndex = right;
      }
      else {
        // no swap, we're done
        keepSwapping = false;
      }
    }
    
    // 4. return the best value
    return best;
  }
  
  private void swap(int index1, int index2) {
    String temp = this.heap.get(index1);
    this.heap.set(index1, this.heap.get(index2));
    this.heap.set(index2, temp);
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
    Heap_Lec2_v2 test = new Heap_Lec2_v2();
    
    System.out.println("isEmpty: "+test.isEmpty());
    test.insert("Elias");
    System.out.println("isEmpty: "+test.isEmpty());
    
    test.insert("Jon");
    test.insert("Martin");
    test.insert("Gertrude");
    test.insert("Sasha");
    test.insert("Tim");
    
    ArrayList<String> sorted = new ArrayList<String>();
    while (!test.isEmpty()) sorted.add(test.removeBest());
    System.out.println("sorted: "+Arrays.toString(sorted.toArray()));
  }
  
}
