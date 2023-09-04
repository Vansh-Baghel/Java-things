package Stacks_Queues;

public class Queue_Using_Arrays {
    public static void main(String[] args) {
        queue q = new queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.display();
        q.poll();
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.size);

    }

    public static class queue{
        int[] arr = new int[5];
        int front = -1;
        int rear = -1;
        int size = 0;

        void push(int x){
            if (rear == arr.length) {
                System.out.println("Queue is full!");
                return;
            }
            if (front == -1) {
                front = rear = 0;
            }
            arr[rear++] = x;
            size++;
        }
        void display(){
            for (int i = front; i < rear; i++) {
                System.out.println(arr[i]);
            }
        }
        void poll(){
            if (front == -1) {
                System.out.println("Queue is already empty");
                return;
            }
            System.out.println();
            System.out.println(arr[front]);
            System.out.println();
            front++;
            size--;
        }
        boolean isEmpty(){
            return size == 0;
        }
    }
}
