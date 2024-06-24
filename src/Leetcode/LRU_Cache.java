package Leetcode;

import java.util.*;

//public class LRU_Cache {
//    int size = 0;
//    Queue<Integer> q;
//    HashMap<Integer, Integer> hm;
//
//    public LRU_Cache(int capacity) {
//        size = capacity;
//        q = new LinkedList<>();
//        hm = new HashMap<>();
//    }
//
//    public int get(int key) {
//        if (hm.containsKey(key)){
//
//            // O(N)
//            q.remove(key);
//
//            // O(1)
//            q.add(key);
//
//            return hm.get(key);
//        }
//
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (!hm.containsKey(key)) {
//            if (hm.size() == size) {
//                hm.remove(q.poll());
//            }
//        } else {
//            // O(N)
//            q.remove(key);
//        }
//
//        // O(1)
//        q.add(key);
//        hm.put(key, value);
//    }

public class LRU_Cache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int size;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> hm = new HashMap<>();

    public LRU_Cache(int capacity) {
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(Node node){
        Node prevv = node.prev;
        Node nextt = node.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public void addNode(Node node){
        Node headKaNxt = head.next;

        head.next = node;
        node.prev = head;

        headKaNxt.prev = node;
        node.next = headKaNxt;
    }

    public int get(int key) {
        if (hm.containsKey(key)){
            Node resNode = hm.get(key);
            int ans = resNode.val;

            removeNode(resNode);
            addNode(resNode);

            return ans;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)){
            Node cur = hm.get(key);
            hm.remove(key);
            removeNode(cur);
        }

        if (hm.size() == size){
            hm.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        addNode(new Node(key, value));
        hm.put(key, head.next);
    }
}
