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
    if (root == null) {
      root = new Node(value);
      return;
    }

    Node currentNode = root;
    while (true) {
      if (currentNode.value > value) {
        if (currentNode.left == null) {
          currentNode.left = new Node(value);
          break;
        } else {
          currentNode = currentNode.left;
        }
      } else {
        if (currentNode.right == null) {
          currentNode.right = new Node(value);
          break;
        } else {
          currentNode = currentNode.right;
        }
      }
    }
  }

  public boolean contains(int value) {
    Node currentNode = root;
    while (currentNode != null) {
      if (currentNode.value > value) {
        currentNode = currentNode.left;
      } else if (currentNode.value < value) {
        currentNode = currentNode.right;
      } else {
        return true;
      }
    }
    return false;
  }

  public void remove(int value) {
    root = remove(root, value);
  }

  private Node remove(Node currentNode, int value) {
    if (currentNode == null) {
      return null;
    }

    if (value < currentNode.value) {
      currentNode.left = remove(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = remove(currentNode.right, value);
    } else {
      if (currentNode.left != null && currentNode.right != null) {
        currentNode.value = getMinValue(currentNode.right);
        currentNode.right = remove(currentNode.right, currentNode.value);
      } else if (currentNode.left != null) {
        currentNode = currentNode.left;
      } else if (currentNode.right != null) {
        currentNode = currentNode.right;
      } else {
        currentNode = null;
      }
    }
    return currentNode;
  }

  private int getMinValue(Node node) {
    int minValue = node.value;
    while (node.left != null) {
      minValue = node.left.value;
      node = node.left;
    }
    return minValue;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    inorderTraversal(root, sb, 0);
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
