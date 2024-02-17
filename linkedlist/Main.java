package linkedlist;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    var linkedList = new LinkedList();

    linkedList.addFirst(2);
    linkedList.addFirst(1);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    // linkedList.reverse();

    int val = linkedList.kthNodeFromTheEnd(4);
   
    System.out.println(val);

    var arr = linkedList.toArray();
   
    System.out.println(Arrays.toString(arr));
  }
}
