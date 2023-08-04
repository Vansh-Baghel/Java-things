package Stacks_Queues;

public class Stacks_Using_Arrays {
    public static class Stack{
        int[] arr = new int[5];
        int idx= 0;
        void push(int x){
            arr[idx]=x;
            idx++;
        }

        void display (Stack st){
            for (int i = idx - 1 ; i > 0; i--){
                System.out.println(arr[i]);
            }
        }

        void pop(){
            if (idx == 0){
                System.out.println("Stack is empty.");
                return;
            }
            System.out.println(arr[idx - 1]);
            arr[idx - 1] = 0;
            idx--;
        }

        void size(Stack st){
            System.out.println(idx + 1);
        }

        void peek(){
            System.out.println(arr[idx - 1]);
        }

        boolean isEmpty(){
            if (idx == 0){
                System.out.println("Stack is empty.");
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(9);
        st.push(1);
        st.push(4);
        st.display(st);
        st.pop();
        st.peek();
        System.out.println(st.isEmpty());
    }
}
