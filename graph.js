class Node {
  constructor(label) {
    this.label = label;
  }
}

class Graph {
  constructor() {
    this.nodes = {}; // string: node
    this.adjancyList = new Map(); // node: node[]
  }

  addNode(label) {
    const node = new Node(label);
    this.nodes[label] = node;
    this.adjancyList.set(node, []);
  }

  addEdge(from, to) {
    const fromNode = this.nodes[from];
    const toNode = this.nodes[to];

    if (!fromNode || !toNode) return;

    this.adjancyList.set(fromNode, [...this.adjancyList.get(fromNode), toNode]);
  }

  print() {
    const keys = this.adjancyList.keys();
    for (const key of keys) {
      console.log(
        key.label + ' => ' + this.adjancyList.get(key).map((v) => v.label),
      );
    }
  }
}

const graph = new Graph();
graph.addNode('a');
graph.addNode('b');
graph.addNode('c');
graph.addNode('d');
graph.addEdge('a', 'b');
graph.addEdge('a', 'c');
graph.addEdge('a', 'd');

graph.addEdge('b', 'd');

graph.print();
