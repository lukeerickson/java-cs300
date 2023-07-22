
public interface PriorityQueueADT <T extends Comparable<T>> {
  
  public void insert(T newData);
  
  public T removeBest();
  
  public T peekBest();
  
  public boolean isEmpty();
  
}