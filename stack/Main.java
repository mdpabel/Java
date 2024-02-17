package stack;


public class Main {
  public static void main(String[] args) {


    var stack = new StackUsingQueue();

    stack.push(2);
    stack.push(3);
    stack.push(4);

    // System.out.println(stack.peak()); 

    System.out.println(stack.pop());

    System.out.println(stack.toString());

  }
}
