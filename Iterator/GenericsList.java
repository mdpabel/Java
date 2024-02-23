package Iterator;

import java.util.Arrays;
import java.util.Iterator;

public class GenericsList<T> implements Iterable<T> {
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

  @Override
  public Iterator<T> iterator() {
    return new ListIterator(this);
  }

  private class ListIterator implements Iterator<T> {
    private GenericsList<T> listIterator;
    private int index;

    public ListIterator(GenericsList<T> listIterator) {
      this.listIterator = listIterator;
    }

    @Override
    public boolean hasNext() {
      return index < listIterator.count;
    }

    @Override
    public T next() {
      return listIterator.list[index++];
    }

  }
}
