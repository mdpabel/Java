package Lambda;

import java.util.function.Function;

public class FunctionInterface {
  public static void main(String[] args) {
    Function<String, String> replaceColon = str -> str.replace(":", "=");
    Function<String, String> addBraces = str -> "{" + str + "}";

    var res = replaceColon.andThen(addBraces).apply("key:value");
    res = addBraces.compose(replaceColon).apply("key:value");

    System.out.println(res);
  }
}
