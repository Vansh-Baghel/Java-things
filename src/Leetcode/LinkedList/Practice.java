package Leetcode.LinkedList;

public class Practice {
    public static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }

    static int size = 0;

    public static void main(String[] args) {
        linkedList li = new linkedList();
        li.insertAt(0,1);
        li.insertAt(1,2);
        li.insertAt(2,3);
        li.insertAt(3,4);
        li.deleteAt(1);
        li.deleteAt(2);
        li.deleteAt(0);
        li.display();
    }

    public static class linkedList {
        Node head = null;

        void display(){
            Node temp = head;

            while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

        void insertAt(int index, int val){
            Node newVal = new Node(val);
            Node temp = head;

            if (index == 0){
                insertAtHead(val);
                size++;
                return;
            } else if (index == size){
                insertAtEnd(head,temp,newVal,index,val);
                size++;
                return;
            } else {
                // Count must be 1 lesser because we next
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                newVal.next = temp.next;
                temp.next = newVal;
            }
            size++;
        }

        void insertAtEnd(Node head, Node temp, Node newValue, int index, int val) {
            for (int i = 0; i < size - 1; i++) {
                temp = temp.next;
            }
            temp.next = newValue;
        }

        void insertAtHead(int val) {
            Node newVal = new Node(val);
            if (head != null) {
                newVal.next = head;
            }
            head=newVal;
        }

        public void deleteAt(int i) {
            Node temp = head;

            if (i == 0){
                head = head.next;
                return;
            }
            for (int j = 0; j < i - 1; j++) {
                temp=temp.next;
            }
            temp.next = temp.next.next;
        }
    }
}
