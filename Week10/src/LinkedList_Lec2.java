
public class LinkedList_Lec2 implements ListADT<Integer>{

  // data fields
  private ListNode_Lec2<Integer> head;
  private ListNode_Lec2<Integer> tail;
  private int size;
  
  // default constructor
  public LinkedList_Lec2() {
    head = null;
    tail = null;
    size = 0;
  }
  
  @Override
  public void add(Integer newObject) {
    ListNode_Lec2<Integer> toAdd = new ListNode_Lec2<Integer>(newObject);
    if (isEmpty()) {
      head = toAdd;
      tail = toAdd;
      size++;
    }
    else {
      tail.setNext(toAdd);
      toAdd.setPrev(tail);
      tail = toAdd;
      size++;
    }
  }

  @Override
  public boolean contains(Integer findObject) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void add(int index, Integer newObject) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Integer get(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int indexOf(Integer findObject) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Integer remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
