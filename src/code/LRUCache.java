package code;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int count;
    private int capacity;
    private Map<Integer, Node> map;
    private Node first;
    private Node last;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        System.out.println(lru.get(2));
        lru.set(2, 6);
        System.out.println(lru.get(1));
        lru.set(1, 5);
        lru.set(1, 2);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            Node new_node = new Node(key, node.value);
            enqueue(new_node);
            map.put(key, new_node);
            return new_node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        } else {
            if (this.count >= this.capacity) {
                Node lru = dequeue();
                map.remove(lru.key);
            }
        }
        Node new_node = new Node(key, value);
        enqueue(new_node);
        map.put(key, new_node);
    }

    public void enqueue(Node node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        count++;
    }

    public Node dequeue() {
        if (last != null) {
            Node temp;
            if (first == last) {
                temp = first;
                first = null;
                last = null;
            } else {
                if (first.next == last) {
                    last.prev = null;
                }
                temp = first;
                first = first.next;
                first.prev = null;
            }
            count--;
            return temp;
        }
        return null;
    }

    public void remove(Node node) {
        if (node == first && node == last) {
            first = null;
            last = null;
        } else if (node == first) {
            first = first.next;
            first.prev = null;
        } else if (node == last) {
            last = last.prev;
            last.next = null;
        } else {
            Node left = node.prev;
            Node right = node.next;
            left.next = right;
            right.prev = left;
        }
        count--;
    }

    class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}