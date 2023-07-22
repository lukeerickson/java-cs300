
public interface TankListener {
  // draws this tank object to the display window
  public void draw();

  // called each time the mouse is Pressed
  public void mousePressed();

  // called each time the mouse is Released
  public void mouseReleased();

  // checks whether the mouse is over this Tank GUI
  // return true if the mouse is over this tank GUI object, false otherwise
  public boolean isMouseOver();
}
