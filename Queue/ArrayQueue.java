package Queue;

import java.util.Arrays;
import java.util.Stack;

public class ArrayQueue {
  private int[] items;
  private int rear;
  public int front;
  private int count;

  public ArrayQueue(int capacity) {
    items = new int[capacity];
  }

  // Enqueue
  public void enqueue(int item) {
    if (count == items.length) {
      throw new IllegalStateException();
    }
    int index = getIndex(rear);
    items[index] = item;
    rear++;
    count++;
  }

  // Dequeue

  public int dequeue() {
    if (count == 0) {
      throw new IllegalStateException();
    }
    int index = getIndex(front);
    int item = items[index];
    items[index] = 0;
    count--;
    front++;
    return item;
  }

  private int getIndex(int index) {
    return index % items.length;
  }

  // peek 
  public int peek() {
     if (count == 0) {
      throw new IllegalStateException();
    }
    int index = getIndex(front);
    return items[index];
  }

  // isEmpty
  public boolean isEmpty() {
    return count == 0;
  }

  // reverse first k elements

  public void reverse(int k) {
    // 10, 20, 30, 40, 50   3 
    // 10, 20, 30
    // 40, 50 
    // 30, 20, 10, 40, 50
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    
    for (int i = 0; i < k; i++) {
      if (i < k) {
        stack1.push(dequeue());
      }
    }

    while (!isEmpty()) {
        stack2.push(dequeue());
    }

    while (!stack1.isEmpty()) {
      enqueue(stack1.pop());;
    }
    
    while (!stack2.isEmpty()) {
      enqueue(stack2.pop());;
    }

  }

  // toString
  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}
