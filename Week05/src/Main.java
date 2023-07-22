import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    // "GrassPokemon p1 = new Pokemon();" would not work
    Pokemon p1 = new GrassPokemon("Bulbasaur");
    Pokemon p2 = new Pokemon("Spheal");
    Pokemon p3 = new Pokemon("Eevee");
    
    Pokemon[] pokes = {p1, p2, p3};
    
    Random rand = new Random();
    p1.takeDamage(rand.nextInt(100), "normal");
    p2.takeDamage(rand.nextInt(100), "normal");
    p3.takeDamage(rand.nextInt(100), "normal");
    
    for(int i = 0; i < pokes.length; i++)
      System.out.println(pokes[i]);
    
    System.out.println(p1.compareTo(p2));
    
    ArrayList<Battle> pokes2 = new ArrayList<Battle>();
    pokes2.add(p1);
    pokes2.add(p2);
    pokes2.add(p3);
    pokes2.add(new Pokemon("Magikarp"));
    
    for(int i = 0; i < pokes2.size(); i++)
      System.out.println(pokes2.get(i));
    
   System.out.println(((Pokemon)pokes2.get(0)).compareTo((Pokemon)pokes2.get(1)));
    
    // sorts the array using compareTo()
    // makes a shallow copy of "pokes" and modifies its contents
    Arrays.sort(pokes);
    
    for(int i = 0; i < pokes.length; i++)
      System.out.println(pokes[i]);
    
    for(int i = 0; i < pokes.length; i++) {
      if(pokes[i] instanceof GrassPokemon)
        ((GrassPokemon) pokes[i]).GrassPokemonOnly();
    }
     
    
    
  }

}
 