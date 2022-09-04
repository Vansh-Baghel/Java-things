public class FiboUsingFormula {
    public static void main(String[] args) {
        int ans = fibo(3);
        System.out.println(ans);
    }

    static int fibo(int n){
        // Put the brackets carefully.
        return (int) ((Math.pow(((1+Math.sqrt(5))/2),n)-Math.pow(((1-Math.sqrt(5))/2),n))/Math.sqrt(5));

    }

}
# Recursion
        * The functions are stired in the stack once it starts executing and will get out once its task is done.
        * Once the work is done , it will flow back to **line where it the function was called**.
        * So the function remains in stack till its work it done, the first function which comes is removed in the end. The very first function of any code is **main** function.
        * There must be a **base** function to stop the execution of the recursive function .
        * If base function is not presrnt , then **stack overflow** will take place ie the new functions will keep on getting added in the stack till 5he memory exceeds.

        ## Why to use recursion
        * It helps us break bigger problens into smaller problems.
        * We can convert it into iterstion and vice versa.
        * Space complexity is not constant, as functions are getting created everytime.

        ## Recursive tree
        * When the flow goes back to the function where it was called after completion then its cslled recursive tree.

        ## Tail recursion
        * When we have last function call then its called tail recursion.
        * When we do additional steps like adding or return , then its not tail recursion.

        ## Recursive relation
        * When we make the formula for recursion then its called recursive relation.

        ## Steps to solve recursion
        1. Break problem into smaller steps if possible.
        2. Write recursive relation if needed.
        3. Draw the recursive tree.
        4. About the tree: -
        a. See the flow of left tree cells and right tree cells like which is executing first.
        b. See the flow of function that how are they getting stacked.
        c. Draw the tree and pointer again and again using **pen and paper**.
        d. Use debugger to see the flow.
        5. See where the functions are getting returned once its finished and what type of values are getting out.

        ## Types of recursive statements
        1. Linear recursive statement :- When we are adding or subtracting any value from recursion. For eg:- **fibonacci** number, there we are subtracting n by 2. In linear recursion, the time taken is too much and same functions are repested manier times , which is not what we want.
        2. Divide and conquere recursive stmt: - When we divide the n by 2 . Eg: - **Binary** search using recursion.

        ## Binary search using recursion
        * Binary search is done in 2 steps: -
        1. It will compare, ie, the time complexity which we have is same for any range . It doesnt depend on the size of array.
        2. It will divide the range into 2 parts ie N will be N/2.
        * Recurrence relation of binary search is therefore **O(1) + F(N/2)**.

        ## Arguments of recursive function
        * Whatever we need in future functions we must mention it in the **arguments** of function.
        * Whatever is changable , make it as variables.

        ## Binary using recursive

        * Pass start and end in the arguments, and let mid be variable because mid can change for other ranges.
        * Use return stmts whenever we want to return any recursive function.
        * We can update the arguments while calling according to the conditions .

        # Time complexity
        * Time complexity does not **equal** to time taken becuase it depends on machine to machine.
        * Time complexity is the function that tells how much time will grow wrt how much the input grows.
        * Always think about the bigger number cases, ignore the small sized range becuase if code is optimised it will handle it by itself, but problem arises when the data increases by large amount.
        * Time taken order: - **O(2^N) > Linear O(N) > O(log N) > O(1) constant** .

        ## Reason to ignore less dominating terms

        * The reason is that they are negligible,like if one value is 1 mil cube and another is 6sec,so we can definitely ignore 6sec.


        ## Big Oh notations (O)
        * Also known as **Upper bound**.
        * The O notation says that the complexity/graph will not exceed more than the given value. Eg: - If O(N^3) is given then geaph can be O(N^2) but not more than O(N^3).
        * Mathematical representation: -

        ## Big omega notation
        * Also known as **lower bound**.
        * Opposite of Upper bound, ie if omega(N^3) is given then graph cannot be lower than N^3 . It will be equal or bigger than it.


        ## Big theta notation
        * Combination of Oh and Omega. Here both upper and lower bound is N^2.

        ## Little O notation
        * Also giving upper bound, we can say that it is loss upper bound.
        * Difference is that it is strictly upper bound ie here f < g and in big O , f <= g.


        ## Little omega
        * Strictly lower bound.

        ## Space and time complexity constant thing
        * We always write O(1) because we dont care about constants in time and space complexity.
        ## Space complexity
        * It is the **extra** space taken by algorithm and the input space.
        * **Auxiliary space** is the space which is extra space taken by an algorithm.
        * Eg: - In binary search, there was no auxiliary space as we were creating 3 variables s, mid , e and those 3 were only used for any range.
        * If no new array is created, then it is O(1) ie O(constant).
        * For recursive programs, the space complexity is not constant because new functions are created in stack at every step.
