package lfu.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class LfuCache {

    private Map<Integer, Integer> key2Freq;
    private Map<Integer, NodeList> freq2List;
    private int capacity;
    private int minFreq;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        key2Freq = new HashMap<>();
        freq2List = new HashMap<>();
        freq2List.put(minFreq, new NodeList());
    }

    public int get(int key) {
        if (!key2Freq.containsKey(key)) {
            return -1;
        }
        int freq = key2Freq.get(key);
        Node deleteNode = freq2List.get(freq).deleteAndGet(key);
        freq += 1;
        if (!freq2List.containsKey(freq)) {
            freq2List.put(freq, new NodeList());
        }
        freq2List.get(freq).addLast(deleteNode);
        key2Freq.put(key, freq);
        if (freq2List.get(minFreq).isEmpty()) {
            minFreq = freq;
        }
        return deleteNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (get(key) != -1) {
            int freq = key2Freq.get(key);
            freq2List.get(freq).getLast().value = value;
            return;
        }
        if (capacity <= key2Freq.size()) {
            Node node = freq2List.get(minFreq).removeFirst();
            key2Freq.remove(node.key);
        }
        key2Freq.put(key, 0);
        freq2List.get(0).addLast(new Node(key, value));
        if (minFreq > 0 || freq2List.get(minFreq).isEmpty()) {
            minFreq = 0;
        }
    }


    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int k, int value) {
            this.key = k;
            this.value = value;
        }
    }

    class NodeList {
        Node head;
        Node tail;
        Map<Integer, Node> map;

        public NodeList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
        }

        public Node deleteAndGet(int key) {
            if (!map.containsKey(key)) {
                return null;
            }
            Node deleteNode = map.get(key);
            deleteNode.pre.next = deleteNode.next;
            deleteNode.next.pre = deleteNode.pre;
            map.remove(deleteNode.key);
            return deleteNode;
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public Node getLast() {
            if (isEmpty()) {
                return null;
            }
            return tail.pre;
        }

        public void addLast(Node node) {
            if (node == null) {
                return;
            }
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
            map.put(node.key, node);
        }

        public Node removeFirst() {
            if (map.size() > 0) {
                map.remove(head.next.key);
                Node deleteNode = head.next;
                head.next = deleteNode.next;
                head.next.pre = head;
                return deleteNode;
            }
            return null;
        }
    }
}