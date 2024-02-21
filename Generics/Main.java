package Generics;

public class Main {
  public static void main(String[] args) {
    var users = new GenericsList<User>();
    var instructors = new GenericsList<Instructor>();

    Utils.addUser(users);
    Utils.addUser(instructors);

  }

}
