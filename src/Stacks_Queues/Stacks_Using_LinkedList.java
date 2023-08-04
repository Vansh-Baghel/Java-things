package Stacks_Queues;

import java.util.List;

public class Stacks_Using_LinkedList {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val=x;
            next=null;
        }
    }

    public static class Stack{
        ListNode head= null;

        void push(int x){
            ListNode t = new ListNode(x);
            t.next=head;
            head = t;
        }

        void pop(){
            if (head != null){
                System.out.println();
                System.out.println(head.val);
                System.out.println();
                head = head.next;
            }
        }

        void display(){
            ListNode t = head;
            while (t != null){
                System.out.println(t.val);
                t=t.next;
            }
        }

        void peek(){
            System.out.println(head.val);
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(9);
        st.push(1);
        st.push(4);

        st.display();

        st.pop();

        st.display();
    }
}
