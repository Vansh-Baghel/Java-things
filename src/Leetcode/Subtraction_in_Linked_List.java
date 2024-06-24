package Leetcode;

public class Subtraction_in_Linked_List {
    static class Node
    {
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }

    }

    public static Node arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 6, 3};
        int[] arr1 = {0,0,0};
        Node head1 = arrayToList(arr);
        Node head2 = arrayToList(arr1);
        printList(subLinkedList2(head1, head2));
    }

    static Node subLinkedList(Node head1, Node head2) {
        // code here
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        while (head1!=null){
            s1.append(head1.data);
            head1=head1.next;
        }
        while (head2!=null){
            s2.append(head2.data);
            head2=head2.next;
        }

        int n1 = Integer.parseInt(s1.toString()), n2 = Integer.parseInt(s2.toString());
        int mini = Math.min(n1, n2), maxi = Math.max(n1,n2);

        String str = (maxi - mini) + "";

        Node res = new Node(0), tmp = res;

        for (char ch: str.toCharArray()){
            res.next = new Node(Integer.parseInt(ch+""));
            res=res.next;
        }

        return tmp.next;
    }

    static Node subLinkedList2(Node head1, Node head2) {
        // Removing the trailing zeros pehle hee
        head1 = removeZeros(head1);
        head2 = removeZeros(head2);

        int n1 = getSize(head1), n2 = getSize(head2);
        if(n1==0 && n2==0) return new Node(0);

        // We are storing the larger value wala node in head1, and smaller one in head2.
        if (n1 == n2) {
            Node t1 = head1, t2 = head2;

            while (t1 != null && t2 != null){
                if (t1.data > t2.data) break;
                else if (t2.data > t1.data) {
                    Node temp = head1; head1=head2; head2=temp;
                    break;
                }

                t1=t1.next;
                t2=t2.next;

                // Means last waale par reach hogaye, therefore all elements same hai matlab
                if (t1 == null) return new Node(0);
            }
        } else if(n2 > n1) {
            Node temp = head1; head1=head2; head2=temp;
        }

        // Calculation
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node res = new Node(0);
        Node tmp = res;

        while (head1 != null){
            int cur1 = head1.data, cur2 = 0;
            if (head2 != null) cur2 = head2.data;

            if (cur1 < cur2){
                // Means head1 wala is smaller, so carry karo
                cur1 += 10;
                if (head1.next != null) head1.next.data -= 1;
            }

            res.next = new Node(cur1 - cur2);
            res = res.next;
            head1=head1.next;
            if (head2!= null) head2 = head2.next;
        }

        tmp = reverse(tmp.next);
        tmp = removeZeros(tmp);

        return tmp;
    }

    // reverse function
    static Node reverse(Node root){
        if (root == null) return null;

        Node prev = null, cur = root, nxt = root.next;
        while (cur != null){
            cur.next = prev;
            prev = cur;
            cur = nxt;
            if (nxt != null) nxt = nxt.next;
        }

        return prev;
    }

    // Removing trailing zeros
    static Node removeZeros(Node root){
        while (root != null && root.data == 0) {
            root = root.next;
        }

        return root;
    }

    // Getting size of nodes
    static int getSize(Node root){
        int size = 0;

        Node tmp = root;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        return size;
    }
}
