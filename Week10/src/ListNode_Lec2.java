/**
 * doubly-linked list node
 */
public class ListNode_Lec2 <T> {
  
  // data fields
  private T data;
  private ListNode_Lec2<T> prev;
  private ListNode_Lec2<T> next;
  
  // constructor
  public ListNode_Lec2(T data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
  
  // mutators
  public void setNext(ListNode_Lec2<T> newNext) { 
    next = newNext;
  }
  
  public void setPrev(ListNode_Lec2<T> newPrev) { 
    prev = newPrev;
  }
  
  // accessors
  public T getData() {
    return this.data;
  }
  
  public ListNode_Lec2<T> getPrev() {
    return this.prev;
  }
  
  public ListNode_Lec2<T> getNext() {
    return this.next;
  }

}
