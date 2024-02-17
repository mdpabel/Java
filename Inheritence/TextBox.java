package Inheritence;

public class TextBox extends UIControl {
  private String text = "";

  public TextBox(boolean isEnabled) {
    super(isEnabled);
  }

  public void render() {
    System.out.println("Rendering textbox...");
  }

  public void setText(String text) {
    this.text = text;
  }

  public void clearText() {
    this.text = "";
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return text;
  }
}
