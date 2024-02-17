package Inheritence;

public class CheckBox extends UIControl{
  public CheckBox(boolean isEnabled) {
    super(isEnabled);
  }

  public void render() {
    System.out.println("Rendering checkbox...");
  }
}
