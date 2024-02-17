package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) {
    try {
      var file = new FileReader("file.txt");
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
}
