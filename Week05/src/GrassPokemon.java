
public class GrassPokemon extends Pokemon {
  
  // data fields
  private String subtype;
  
  public GrassPokemon(String name) {
    super(name);
    this.subtype = "normal";
  }
  
  public GrassPokemon() {
    super("Bulbasaur");
  }
  
  public GrassPokemon(String name, String subtype) {
    super(name);
    this.subtype = subtype;
  }
  
  public void GrassPokemonOnly() {
    System.out.println("lol");
  }
  
  @Override
  public String toString() {
    return super.toString() + ", " + this.subtype;
  }
}
