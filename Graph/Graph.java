package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
  private class Node {
    String label;

    public Node(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }
  }

  private Map<String, Node> nodes = new HashMap<>();
  private Map<Node, List<Node>> adjacencyList = new HashMap<>();

  public void addNode(String label) {
    var node = new Node(label);
    nodes.putIfAbsent(label, node);
    adjacencyList.putIfAbsent(node, new ArrayList<>());
  }

  public void removeNode(String label) {
    var node = nodes.get(label);
    if (node == null)
      return;

    for (var n : adjacencyList.keySet()) {
      adjacencyList.get(n).remove(node);
    }
    adjacencyList.remove(node);
    nodes.remove(label);
  }

  public void addEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null || from == to)
      throw new IllegalArgumentException();

    adjacencyList.get(fromNode).add(toNode);
  }

  public void removeEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null)
      return;

    adjacencyList.get(fromNode).remove(toNode);
  }

  // Traversal methods
  public void dfs(String root) {
    var node = nodes.get(root);
    if (node == null)
      return;

    dfsHelper(node, new HashSet<>());
  }

  public void dfs(String root, boolean iterative) {
    var node = nodes.get(root);
    if (node == null)
      return;

    Set<Node> visited = new HashSet<>();
    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      var currentNode = stack.pop();

      if (visited.contains(currentNode))
        continue;

      System.out.println(currentNode);
      visited.add(currentNode);

      for (var neighbour : adjacencyList.get(currentNode)) {
        if (!visited.contains(neighbour)) {
          stack.push(neighbour);
        }
      }
    }

  }

  private void dfsHelper(Node root, Set<Node> visited) {
    var edges = adjacencyList.get(root);

    System.out.println(root);
    visited.add(root);

    for (var node : edges) {
      if (!visited.contains(node)) {
        dfsHelper(node, visited);
      }
    }
  }

  public void bfs(String root) {
    var node = nodes.get(root);
    if (node == null)
      return;

    Set<Node> visited = new HashSet<>();

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      var currentNode = queue.remove();

      if (visited.contains(currentNode))
        continue;

      System.out.println(currentNode);
      visited.add(currentNode);

      for (var neighbour : adjacencyList.get(currentNode)) {
        if (!visited.contains(neighbour))
          queue.add(neighbour);
      }
    }
  }

  // topological sort
  public void topologicalSort() {
    Stack<Node> stack = new Stack<>();
    Set<Node> visited = new HashSet<>();

    for (var node : nodes.values()) {
      if (!visited.contains(node))
        topologicalSortHelper(node, visited, stack);
    }

    while (!stack.empty()) {
      System.out.println(stack.pop());
    }
  }

  private void topologicalSortHelper(Node node, Set<Node> visited, Stack<Node> stack) {
    if (visited.contains(node))
      return;

    visited.add(node);

    for (var neighbour : adjacencyList.get(node)) {
      topologicalSortHelper(neighbour, visited, stack);
    }

    stack.push(node);
  }

  // cycle detection
  public boolean hasCycle() {
    Set<Node> all = new HashSet<>();
    all.addAll(nodes.values());

    Set<Node> visiting = new HashSet<>();
    Set<Node> visited = new HashSet<>();

    while (!all.isEmpty()) {
      var node = all.iterator().next();
      if (hasCycleHelpr(node, all, visiting, visited))
        return true;
    }

    return false;
  }

  private boolean hasCycleHelpr(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
    all.remove(node);
    visiting.add(node);

    for (var neighbour : adjacencyList.get(node)) {
      if (visited.contains(neighbour))
        continue;

      if (visiting.contains(neighbour))
        return true;

      if (hasCycleHelpr(neighbour, all, visiting, visited))
        return true;
    }

    visiting.remove(node);
    visited.add(node);

    return false;
  }

  public void print() {
    for (var vertex : adjacencyList.keySet()) {
      var connectedTo = adjacencyList.get(vertex);
      if (!connectedTo.isEmpty()) {
        System.out.println(vertex + " is connected to " + connectedTo);
      }
    }
  }

}
