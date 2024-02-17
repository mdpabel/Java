package Inheritence;

public class UpCastingDownCasting {
  public static void main(String[] args) {
    // var control = new UIControl(true);
    var textBox = new TextBox(true);
    // print(control); 
    print(textBox); 
  }

  public static void print(UIControl control) {// upcasting
    // Upcasting: The 'control' object is implicitly casted to UIControl,
    // treating any subclass instance as its superclass type.
    if (control instanceof TextBox) {
      // Downcasting: As 'control' is determined to be an instance of TextBox,
      // we explicitly cast it back to TextBox to access TextBox-specific methods.
      var box = (TextBox) control; // downcasting
      box.setText("Hello world");
    }

    System.out.println(control);
  }
}


// upcasting: Casting an object to one of its super types 
// downcasting: casting an object to one of its sub types