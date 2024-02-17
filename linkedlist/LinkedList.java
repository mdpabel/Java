package linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
  private Node first;
  private Node last;
  private int length = 0;

  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  // Add last
  public void addLast(int item) {
    var node = new Node(item);
    if (length == 0) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }
    length++;
  }
  // add first
  public void addFirst(int item) {
    var node = new Node(item);
    if (length == 0) {
      first = last = node;
    } else {
      node.next = first;
      first = node;
    }
    length++;
  }
  
  // index of;

  public int indexOf(int item) {
    int index = 0;
    var currentNode = first;
    while (currentNode != null) {
      if (currentNode.value == item) {
        return index;
      }
      currentNode = currentNode.next;
      index++;
    }

    return -1;
  }
  
  // contains

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }
  
  // remove first 
  public void removeFirst() {
    if (length == 0) {
      throw new NoSuchElementException();
    }

    if (length == 1) {
      first = null;
      last = null;
    } else {
      var second = first.next;
      first.next = null;
      first = second;
    }
    length--;
  }

  // remove last
  public void removeLast() {
    if (length == 0) {
      throw new NoSuchElementException();
    }

    if (length == 1) {
      first = last = null;
      return;
    } else {
      var currentNode = first;
      int lastIndex = length - 1;

      while (lastIndex >= 0) {
        currentNode = currentNode.next;
        lastIndex--;
      }

      last = currentNode;
      last.next = null;
    }
    length--;
  }
  
  // length
  public int size() {
    return length;
  }

  // toArray 

  public int[] toArray() {
    int[] array = new int[length];
    int i = 0;
    var node = first;

    while (length > i) {
      array[i] = node.value;
      node = node.next;
      i++;
    }

    return array;
  }

  // reverse

  public void reverse() {
    if (length == 0) {
      return;
    }

    Node prev = null;
    var curr = first;

    while (curr != null) {
      var next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }

    last = first;
    last.next = null;
    first = prev;
  }

  // kth Node From The End

  public int kthNodeFromTheEnd(int index) {
    var fast = first;

    for (int i = 0; i < index; i++) {
      fast = fast.next;
    }

    var slow = first;

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    return slow.value;
  }
  
  // Remove nth node from the end of the list

  public Node removeNthFromEnd(int n) {
        var fast = first;

        for (int i = 0; i < n; i++) {
          fast = fast.next;
        }
        
        // where the node to be removed is the head;
        if (fast == null) {
          var temp = first.next;
          first.next = null;
          first = temp;
          return first;
        }

        var slow = first;

        while (fast.next != null) {
          fast = fast.next;
          slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return first;
    }

}