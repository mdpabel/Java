# Hash Table

1. **Hash Functions:**

   - Hash functions map data of arbitrary size to fixed-size values.
   - They are crucial for efficient storage and retrieval in hash tables.
   - Good hash functions aim to distribute keys evenly across the table to minimize collisions.

2. **Collisions:**

   - Collisions occur when two different keys hash to the same index in the table.
   - Handling collisions is essential for maintaining the integrity and efficiency of the hash table.

3. **Chaining:**

   - Chaining resolves collisions by storing multiple entries with the same hash index in linked lists.
   - It allows for efficient storage and retrieval of key-value pairs.

4. **Open Addressing:**

   - Open addressing resolves collisions by finding alternative slots within the table.
   - It involves various techniques such as linear probing, quadratic probing, and double hashing.

5. **Linear Probing:**

   - Linear probing resolves collisions by sequentially searching for the next available slot in the table.
   - It uses a linear function to calculate the next probe location: \( (hash1 + i) \% table_size \).

6. **Quadratic Probing:**

   - Quadratic probing resolves collisions by using a quadratic function to calculate the next probe location: \( (hash1 + i^2) \% table_size \).

7. **Double Hashing:**

   - Double hashing resolves collisions by using two hash functions.
   - It combines the primary hash function hash1 with a secondary hash function hash2.
   - The next probe location is calculated using: \( (hash1 + i \times hash2) \% table_size \).
   - The secondary hash function helps to minimize clustering and improve the distribution of keys.

8. **Secondary Hash Function:**

   - The secondary hash function hash2 is typically computed as prime - (key % prime).
   - The choice of a prime number for prime helps to reduce the chance of clustering and ensures a more uniform distribution of keys.

9. **Prime Numbers:**
   - Prime numbers are often used in hashing algorithms due to their unique properties.
   - They help to reduce the likelihood of collisions and improve the efficiency of hash functions.

```java
package HashMap;

import java.util.LinkedList;

public class HashMap {
    // Internal class to represent a key-value pair
    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array to hold the buckets, each bucket is a linked list of nodes
    @SuppressWarnings("unchecked")
    private LinkedList<Node>[] items = new LinkedList[5]; // Initial capacity set to 5

    // Method to insert a key-value pair into the hash map
    public void put(int key, String value) {
        int index = hash(key);
        if (items[index] == null) {
            items[index] = new LinkedList<>(); // Create a new linked list if the bucket is null
        }

        var bucket = items[index];

        // Check if the key already exists in the bucket, if so, update the value
        for (var entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // If key does not exist in the bucket, add a new node to the end of the list
        bucket.addLast(new Node(key, value));
    }

    // Method to retrieve the value associated with a given key
    public String get(int key) {
        var node = getNode(key);
        return node.value;
    }

    // Method to remove a key-value pair from the hash map
    public void remove(int key) {
        var bucket = getBucket(key);
        var node = getNode(key);

        bucket.remove(node);
    }

    // Helper method to get the bucket corresponding to a given key
    private LinkedList<Node> getBucket(int key) {
        var bucket = items[hash(key)];
        if (bucket == null) {
            throw new IllegalStateException("Bucket is null");
        }

        return bucket;
    }

    // Helper method to get the node corresponding to a given key
    private Node getNode(int key) {
        var bucket = getBucket(key);

        for (var node : bucket) {
            if (node.key == key) {
                return node;
            }
        }

        throw new IllegalStateException("Node not found for key: " + key);
    }

    // Hash function to calculate the index for a given key
    private int hash(int key) {
        return key % items.length;
    }

    // Method to represent the hash map as a string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        // Iterate over each bucket and each node in the bucket, appending key-value pairs
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

```
