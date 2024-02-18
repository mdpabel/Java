package Exceptions;

import java.io.IOException;

public class RethrowingEx {
  public void show() throws IOException {
    var acc = new Account();
    try {
      acc.deposit(-100);
    } catch (IOException e) {
      System.out.println("Logging...");
      throw e;
    }
  }
}
