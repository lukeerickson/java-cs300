/**
 * base class for inheritance demo
 * @author lukee
 *
 */
public class Pokemon implements Battle, Comparable<Pokemon> {
/*
 * base class fields:
 * - type (String)
 * - hp (int)
 * - max hp
 * - status (string)
 * - name (string)
 * - cp (int)
 * - attacks (string[] length 4)
 * - lvl (int)
 * - isShiny (boolean)
 * 
 * base class methods:
 * - attack
 * - take damage
 * - getHP
 * - setHP
 * - getStatus
 * - setStatus
 * 
 * derived class fields:
 * - water, grass, fire
 * - list of possible attacks
 * - effective against
 * - weak against
 * 
 * derived class methods:
 * - attack (override)
 * - take damage (override)
 * - setStatus (override)
 * 
 */
  
  // data fields
  private String name;
  private int hp;
  private int level;
  
  // constructor
  public Pokemon (String name) {
    this.name = name;
    this.hp = 100;
    this.level = 1;
  }
  
  @Override
  public String toString() {
    return this.name + " (" + this.hp + "hp, lvl" + this.level + ")";
  }
  
  public int attack() {
    return 0;
  }
  
  public void heal(int hp) {
    
  }
  
  public boolean takeDamage(int hp, String type) {
    if (hp < 0)
      return true;
    this.hp -= hp;
    return this.hp > 0;
  }

  // negative integer --> this < o
  // zero --> this = 0
  // positive integer --> this > o
  @Override
  public int compareTo(Pokemon o) {
    return this.hp - o.hp;
  }
  
}
