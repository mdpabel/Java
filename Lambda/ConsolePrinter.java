package Lambda;

public class ConsolePrinter {
  private int a = 10;

  public ConsolePrinter(String message) {
  }

  public static void test(String message) {
  }

  public void hello(String message) {
  }

  public void show() {
    greet(message -> System.out.println(this.a + message));
    greet(System.out::println);
    greet(ConsolePrinter::test);
    greet(ConsolePrinter::new);
    // greet(new ConsolePrinter()::hello);
  }

  // public void show() {
  // greet(new Printer() {
  // private int b = 10;

  // @Override
  // public void print(String message) {
  // System.out.println(this.b + message);
  // }
  // });
  // }

  public static void greet(Printer printer) {
    printer.print("Hello world!");
  }
}
