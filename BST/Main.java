package BST;

public class Main {
  public static void main(String[] args) {
    BST bst = new BST();
    bst.insert(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(8);
    System.out.println("BST:");
    System.out.println(bst);
    System.out.println("Removing 3:");
    bst.remove(3);
    System.out.println(bst);
  }
}
