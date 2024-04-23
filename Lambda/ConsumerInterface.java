package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
  public static void main(String[] args) {
    var list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    Consumer<Integer> printNum = item -> System.out.println(item);
    Consumer<Integer> addTwoAndPrintNum = item -> System.out.println(item + 2);

    list.forEach(printNum.andThen(addTwoAndPrintNum).andThen(printNum));

  }
}
