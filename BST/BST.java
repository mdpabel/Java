package BST;

public class BST {
  private class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node root;
  
  public void insert(int value) {
    var node = new Node(value);

    if (root == null) {
      root = new Node(value);
      return;
    }

    var parent = getParent(value);

    if (parent.value > value) {
      parent.left = node;
    } else {
      parent.right = node;
    }

  }


  private Node getParent(int value) {
    var node = root;
    Node parent = root;

    while (node != null) {
      parent = node;
      if (node.value > value) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    return parent;
  }
  

  @Override
    public String toString() {
        return inorderTraversal(root);
    }

    private String inorderTraversal(Node node) {
        StringBuilder sb = new StringBuilder();
        inorderTraversal(node, sb, 0);
        return sb.toString();
    }

    private void inorderTraversal(Node node, StringBuilder sb, int depth) {
        if (node != null) {
            inorderTraversal(node.right, sb, depth + 1);
            sb.append("  ".repeat(depth)).append(node.value).append("\n");
            inorderTraversal(node.left, sb, depth + 1);
        }
    }

}


/*
     5
  2     7
1   3  6   8

2
 */