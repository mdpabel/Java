package HashMap;

import java.util.LinkedList;

public class HashMap {
    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    private LinkedList<Node>[] items = new LinkedList[5];

    public void put(int key, String value) {
        int index = hash(key);
        if (items[index] == null) {
            items[index] = new LinkedList<>();
        }

        var bucket = items[index];

        for (var entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.addLast(new Node(key, value));
    }

    public String get(int key) {
        var node = getNode(key);
        return node.value;
    }

    public void remove(int key) {
        var bucket = getBucket(key);
        var node = getNode(key);

        bucket.remove(node);
    }

    private LinkedList<Node> getBucket(int key) {
        var bucket = items[hash(key)];
        if (bucket == null) {
            throw new IllegalStateException("Bucket is null");
        }

        return bucket;
    }

    private Node getNode(int key) {
        var bucket = getBucket(key);

        for (var node : bucket) {
            if (node.key == key) {
                return node;
            }
        }

        throw new IllegalStateException("Node not found for key: " + key);
    }

    private int hash(int key) {
        return key % items.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (LinkedList<Node> bucket : items) {
            if (bucket != null) {
                for (Node node : bucket) {
                    sb.append(node.key).append("=").append(node.value).append(", ");
                }
            }
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove trailing comma and space
        }

        sb.append("}");

        return sb.toString();
    }

   
}
