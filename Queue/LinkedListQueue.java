package Queue;

import java.util.LinkedList;

public class LinkedListQueue {
  LinkedList<Integer> items = new LinkedList<>();


  // enqueue item
  public void enqueue(int item) {
    items.add(item);
  }

  // dequeue item
  public int dequeue() {
    return items.removeFirst();
  }

  // isEmpty
  public boolean isEmpty() {
    return items.isEmpty();
  }

  // peek 
  public int peek() {
    return items.peekFirst();
  }

  // size 
  public int size() {
    return items.size();
  }

  // toString
  @Override
  public String toString() {
    return items.toString();
  }
  
}
