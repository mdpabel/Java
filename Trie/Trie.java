package Trie;

import java.util.HashMap;

public class Trie {
  private class Node {
    private char value;
    private HashMap<Character, Node> children = new HashMap<>();
    private boolean isEndOfWord;

    public Node(char value) {
      this.value = value;
    }

    public boolean hasChild(char ch) {
      return children.containsKey(ch);
    }

    public void addChild(char ch) {
      children.put(ch, new Node(ch));
    }

    public Node getChild(char ch) {
      return children.get(ch);
    }

    public Node[] getChildren() {
      return children.values().toArray(new Node[0]);
    }

    @Override
    public String toString() {
      return "" + value;
    }
  }

  private Node root = new Node(' ');

  public void insert(String word) {
    var currentRoot = root;

    for (char ch : word.toCharArray()) {
      if (!currentRoot.hasChild(ch)) {
        currentRoot.addChild(ch);
      }
      currentRoot = currentRoot.getChild(ch);
    }

    currentRoot.isEndOfWord = true;
  }

  public boolean contains(String word) {
    if (word == null || word.length() == 0)
      return false;

    var currentRoot = root;

    for (char ch : word.toCharArray()) {
      if (!currentRoot.hasChild(ch)) {
        return false;
      }
      currentRoot = currentRoot.getChild(ch);
    }

    return currentRoot.isEndOfWord;
  }

  public void traverse() {
    traverse(root);
  }

  private void traverse(Node root) {
    System.out.println(root.value);

    for (var node : root.getChildren()) {
      traverse(node);
    }
  }

  public void remove(String word) {
  }

  private void remove(Node root) {
  }

  public void print() {
    print(root, "");
  }

  private void print(Node root, String prefix) {
    if (root == null)
      return;

    System.out.println(prefix + root.value + (root.isEndOfWord ? " (End)" : ""));

    for (var child : root.children.values()) {
      print(child, prefix + "  ");
    }
  }

}
