package Lambda;

import java.util.function.UnaryOperator;

public class UnaryOperatorInterface {
  public static void main(String[] args) {
    UnaryOperator<Integer> square = n -> n * n;
    UnaryOperator<Integer> increment = n -> n + 1;

    var res = increment.andThen(square).apply(1);

    System.out.println(res);
  }
}
