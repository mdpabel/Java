package Generics;

import java.util.Arrays;

public class GenericsList<T> {
  @SuppressWarnings("unchecked")
  T[] list = (T[]) new Object[5];
  private int count;

  public void add(T item) {
    if (count == list.length) {
      throw new ArrayIndexOutOfBoundsException();
    }

    list[count++] = item;
  }

  public T get(int index) {
    return list[index];
  }

  public int size() {
    return count;
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOfRange(list, 0, count));
  }
}
