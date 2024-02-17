package Queue;

import java.util.Arrays;

public class PriorityQueue {
  private int[] items;
  private int count;
  
  public PriorityQueue(int capacity) {
    items = new int[capacity];
  }

  public void enqueue(int item) {
    if (isFull()) {
      throw new IllegalStateException();
    }
    shifting(item);
    count++;
  }
  
  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    return items[--count];
  }

  public boolean isEmpty() {
    return count == 0;
  }
  
  public boolean isFull() {
    return count == items.length;
  }


  private void shifting(int item) {
    int i;
    for (i = count - 1; i >= 0; i--) {
      if (items[i] > item) {
        items[i + 1] = items[i];
      } else {
        break;
      }
    }
    items[i + 1] = item;
  }
  
  
 
  

  @Override
  public String toString() {
    return Arrays.toString(items);
  }

}
