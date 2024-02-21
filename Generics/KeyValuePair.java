package Generics;

public class KeyValuePair<K, V extends Number> {
  private K key;
  private V value;

  public KeyValuePair(K key, V value) {
    this.key = key;
    this.value = value;
  }
}
