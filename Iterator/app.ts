class Node {
  val: number;
  next: Node | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

class LinkedList {
  root: Node | null;

  constructor() {
    this.root = null;
  }

  add(item: number) {
    let node = this.root;

    if (node === null) {
      this.root = new Node(item);
      return;
    }

    let temp = node;

    while (node != null) {
      temp = node;
      node = node.next;
    }

    temp.next = new Node(item);
  }

  // iterable;
  [Symbol.iterator]() {
    let node = this.root;
    return {
      next() {
        if (node) {
          const value = node.val;
          node = node.next;
          return {
            value: value,
            done: false,
          };
        } else {
          return {
            value: null,
            done: true,
          };
        }
      },
    };
  }
}

const list = new LinkedList();

list.add(1);
list.add(2);
list.add(3);

for (const item of list) {
  console.log(item);
}

export {};
