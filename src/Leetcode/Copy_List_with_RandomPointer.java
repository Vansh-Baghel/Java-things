package Leetcode;

import java.util.HashMap;

public class Copy_List_with_RandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node curr = head;

        while (curr != null){
            hm.put(curr, new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        Node headC = null;
        while (curr!=null){
            Node temp = hm.get(curr);
            temp.next = hm.get(curr.next);
            temp.random = hm.get(curr.random);
            curr=curr.next;

            if (headC == null) headC = temp;
        }

        return headC;
    }
}
