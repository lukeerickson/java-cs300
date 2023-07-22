// we're going to use an oversized array to mimic an arrayList

// Bob is an unbounded generic
public class OversizedArray<Bob> {

  // data fields
  private int size;
  private Object[] array;

  // constructor
  public OversizedArray(int capacity) {
    // if capacity is 0, then set it to 1
    // else, keep it the same
    array = new Object[capacity==0?1:capacity];
    size = 0;
  }

  // OVERLOAd the constructor
  public OversizedArray() {
    this(10);
  }

  // accessors
  public Bob get(int index) {
    if (index >= 0 && index < size)
      return (Bob) array[index];
    throw new IndexOutOfBoundsException("xD");
  }

  public int size() {
    return this.size;
  }
  
  // mutators
  public void add(Bob b) {
    if(size < array.length) {
      array[size] = b;
      size++;
    }
    else {
      Object[] temp = new Object[array.length*2+1];
      for(int i = 0; i < size; i++) {
        temp[i] = array[i];
      }
      array = temp;
      // recursion, bitch
      add(b);
    }
      //fuck yuo luke
      
  }

}
