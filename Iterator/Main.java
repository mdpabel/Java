package Iterator;

public class Main {
  public static void main(String[] args) {
    GenericsList<Integer> list = new GenericsList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    var iterator = list.iterator();

    while (iterator.hasNext()) {
      int item = iterator.next();
      System.out.println(item);
    }
  }
}
