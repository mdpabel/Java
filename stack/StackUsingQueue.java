package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class StackUsingQueue {
  Queue<Integer> queue1;
  Queue<Integer> queue2;

  public StackUsingQueue() {
    queue1 = new ArrayDeque<>();
    queue2 = new ArrayDeque<>();
  }

  public void push(int item) {
    queue1.add(item);
  }

  public int pop() {
    if (queue1.isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
        
    while (queue1.size() > 1) {
      queue2.add(queue1.poll());
    }
    int firstItem = queue1.poll();

    var temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    return firstItem;
  }


  public String toString() {
    return Arrays.toString(queue1.toArray());
  }
  
}

/**
 * [1,2,3]
 * [1,2]
 */