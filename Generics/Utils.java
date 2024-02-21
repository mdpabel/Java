package Generics;

public class Utils {
  public static <T extends Comparable<T>> T max(T a, T b) {
    return a.compareTo(b) > 0 ? a : b;
  }

  public static <K, V> void keyValue(K key, V value) {
    System.out.println(key + "=" + value);
  }

  public static void printUser(User user) {
    System.out.println(user);
  }

  public static void printUsers(GenericsList<? extends User> users) {
    users.get(0);
    // users.add(new User("Hello"));
    System.out.println(users.size());
  }

  public static void addUser(GenericsList<? super Instructor> users) {
    // users.add(new User("he"));
  }
}
