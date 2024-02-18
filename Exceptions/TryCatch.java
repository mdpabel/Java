package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TryCatch {
  public static void main(String[] args) {
    try(
        var fileReader = new FileReader("file.txt");
        var fileWriter = new FileWriter("file.txt");
    ) {
      var data = fileReader.read();
      new SimpleDateFormat().parse(null);
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (ParseException e) {
      e.printStackTrace();
    } 
    // finally {
    //   if (fileReader != null) {
    //     try {
    //       fileReader.close();
    //     } catch (Exception e) {
    //       // TODO: handle exception
    //     }
    //   }
    // }
  }
}
