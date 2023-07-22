import java.util.ArrayList;
public class ArrayListDemo {

  public static void main(String[] args) {
    
    ArrayList<Integer> demo = new ArrayList<Integer>();
    int demoNum = 500;
    
    //as you increase demoNum, inserting at the front takes longer and longer
    //this is because you have to shift each individual value in the arrayList over
    //every time you add an element to the beginning
    //and the computer has to expand the arrayList size
    
    System.out.println("Starting...");
    
    //add at end (append)
    for(int i = 0; i < demoNum; i++)
      demo.add(i);
    
    System.out.println("Done adding! Demo size: " + demo.size());
    
    //reassign existing values
    for(int i = 0; i < demoNum; i++)
      demo.set(i, 0);
    
    System.out.println("Done setting! Demo size: " + demo.size());
    
    //insert at the front
    for(int i = 0; i < demoNum; i++)
      demo.add(0, 0);
    
    System.out.println("Done inserting at the front! Demo size: " + demo.size());
  }
  
}
