package Trie;

public class Main {
  public static void main(String[] args) {
    var trie = new Trie();
    trie.insert("hello");
    trie.insert("helo");
    trie.insert("hi");

    trie.traverse();

    // System.out.println(trie.contains(null));

  }
}
