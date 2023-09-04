package Stacks_Queues;

public class Queues_Using_LinkedList {
    class Node{
        int val;
        Node next;
        int size;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static class queue{
        Node head = null;
        Node tail = null;
    }
}
