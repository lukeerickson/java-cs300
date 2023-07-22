import java.util.ArrayList;

public class Driver {
  public static void main(String[] args) {
    ArrayList<Pokemon> pokes = new ArrayList<Pokemon>();
    
    pokes.add(new Pokemon("Chimchar"));
    pokes.add(new GrassPokemon("Snivy", "ghost"));
    
    for(int i =0; i < pokes.size(); i++)
      System.out.println(pokes.get(i));
  }
}
