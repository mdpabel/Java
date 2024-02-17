package Inheritence;

public class Main {
  public static void main(String[] args) {
    UIControl[] controls = { new CheckBox(false), new TextBox(true) };

    for (var control : controls) {
      control.render();
    }
  }
}
