
public class Lec2Stack implements StackADT<Double>{
  
  // data fields
  private Double[] data;
  private int top;
  
  // constructor
  public Lec2Stack(int capacity) {
    data = new Double[capacity];
    top = 0;
  }

  @Override
  public void push(Double newElement) {
    if (top < data.length)
      data[top++] = newElement;
  }

  @Override
  public Double pop() {
    if (!isEmpty())
      return data[--top];
    return null;
  }

  @Override
  public Double peek() {
    if (top > 0)
      return data[top-1];
    return null;
  }

  @Override
  public boolean isEmpty() {
    return top == 0;
  }
  
  public static void main(String[] args) {
    Lec2Stack test = new Lec2Stack(10);
    System.out.println("Is Empty: "+test.isEmpty()); // true
    test.push(12.34);
    System.out.println("Is Empty: "+test.isEmpty()); // false
    
    System.out.println(test.pop()); // 12.34
    System.out.println("Is Empty: "+test.isEmpty()); // true
    System.out.println(test.data[0]);
    test.push(17.0);
    System.out.println(test.peek());
  }

}
