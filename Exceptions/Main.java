package Exceptions;


public class Main {
  public static void main(String[] args) {
    var acc = new Account();

    Math.pow(1, 2);
    
    try {
      acc.withdraw(100);
    } catch (AccountException e) {
      var causedBy = e.getCause();
      System.out.println(causedBy.getMessage());
    }
    
  }
}
