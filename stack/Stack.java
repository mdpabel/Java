package stack;

import java.util.Arrays;

public class Stack {
  private int[] stack;
  private int count = 0;
  private int min = Integer.MAX_VALUE;
  private int max = Integer.MIN_VALUE;

  public Stack(int size) {
    stack = new int[size];
  }
  
  // push 
  public void push(int item) {
    if (count == stack.length) {
      throw new StackOverflowError();
    }
    stack[count++] = item;
  }

  // pop 
  public int pop() {
    if (count == 0) {
      throw new IllegalStateException();
    }
    return stack[--count];
  }

  // peak
  public int peak() {
    if (count == 0) {
      throw new IllegalStateException();
    }
    return stack[count - 1];
  }

  // isEmpty
  public boolean isEmpty() {
    return count == 0;
  }

  // min 
  public int min() {
    return min;
  }

  // max 
   public int max() {
    return max;
  }

  // toString 
  @Override
  public String toString() {
    int[] items = Arrays.copyOfRange(stack, 0, count);
    return Arrays.toString(items);
  }
}
