package Lambda;

import java.util.function.Supplier;

public class SupplierInterface {
  public static void main(String[] args) {
    Supplier<Double> getRandom = () -> Math.random();

    System.out.println(getRandom.get());
  }
}
