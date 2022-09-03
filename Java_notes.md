## How Java executes


## Interpreter and compiler 
* Great detail in the ss, but in short interpreter (java or JRE) **executes** the code and compiler (javac) **checks** each and every line for errors.

## Methods VS functions 
* Methods are the functions inside classes .
* Functions are functions .

## public
* Means that function can be used even from outside that file and also inside it. 
* The name of file must be **Main** .

## public static void main
* **main** is a reserved word and if its not present then function will not run and the code starts running from here.
* **static** is used because otherwise we need to create object . We can execute the code without creating object of any class due to this keyword.
* **void** is a return type.

## print VS println
* print is used to print on the same line and println on the nextline.

## package
* Package will be the path of that file which we can access.

## Scanner
* Scanner is used to input any value.
* To print the input we need to use different keywords .
* **in** keyword is used to input amyvalue from keyboard.

## Primitive datatypes
* The values which cannot be broken into other datatypes.
* Like the word 'Vnsh' can be broken into characters but if it was 'V' then its just character, 

## datatypes 
* For int , we have **long** and **int**. Default value is int and therefore to specify long we need to use **L** after number while using long.
* long stored large values of int.
* For float , we have **float** and **double**. Double is default value and it means that we can store larger decimal numbers in it and for using float we need to use **f** in the end.

## Literal and identifier
* Literal are the values and identifier are the variable , function , class ke names. 

## Initialization and reassign 
* Initialization is said when we use the datatype and assign the variable for the first time .
* Reassigning is to modify an existing variable value anywhere , if we reassign any variable inside a block even then the value will be changed globally.

## Static VS Non-static
* All objects only contains non-static members but also just the address of the static member. Members means any datatype .
* Static members are called using class and non-static are called by objects .

## Shadowing 
* Shadowing in Java is the practice of using variables in overlapping scopes with the same name where the variable in low-level scope overrides the variable of high-level scope. 
* Inside that lower scope , the value will be the one initialized inside it but outside that block the value initialized globally will be accessible.

## Function overloading
* When 2 functions have same names and return types but different arguments .
* If args are same only then it will give error, otherwise u can use both the functions by giving required parameter values wrt arguments mentioned.

## Pass by value
* In java , there is only pass by value and not pass by reference . 
*  When we pass object reference then it will take copy of the object and point to the same value . EG:- Changing 1st int value in an array.

## Advanced for loop (type refName : variable)
* This for loop is like forEach .

## Arrays.toString
* This will print all the arrays and we dont need to use iteration .
* This works as an iterator itself to print the values.

## Multidimensional arrays
* In this , we use brackets wrt its dimensions.
* The datatype of this array is *array* itself. Keep this in mind because we specify it while use advanced for loop (forEach).
* To use for loop for each array element, we run 2 for loops. 1 for rows and another to go through each element of the column. 
* The size of 2nd for loop will be smaller than **arr[row].length** ie the size of that row k elements.

## ArrayList list
* We use this when we dont know the length of array.
* We use **new** keyword while declaring it.
* We use **wrapper** class to specify the datatype .
* We initialize this array which is done using **for** loop and we use **add** keyword to append the values in it .

## list 
* list of ArrayList has many predefined methods like add , set , get , contains ,etc .
* To print the list elements , we need to use **get** . It won't work by specifying the index number.

## Advaned Switch statemment
* We can convert the switch statement into cleaner syntax by pressing **Alt + Enter** which is called advanced switch statement .

## return -1
* Means value doesn't exist.

## toCharArray()
* Used to convert String into array of characters.

## Linear search
* It will search each element one by one to find any element.

## Binary Search 
* The array must be sorted ascending or descending for using this.
* The worst case here can be log(N)/log(2) where N is the length of array.
* We find the middle element in a **sorted** array and will ignore the elements before and after it depending on the element we want to find.
* The index number doesnt change after ignoring the rest elements, ie , we dont reduce the original array.
* mid formula must be **start + (end - start)/2** because **start + end** might exceed the range of int sometimes . Bith will give same answer.

## Ceiling and Floor using binary
* If we want ceiling index of target number (target is not present) ie the next number greater than target element , will return **start** instead of -1 of regular.
* If floor , then return **end** ie the number greatest among the smallest element than target.
* Because if target element is not present then in the last condition only one element remains which will be start , mid and end altogether. Then target will be greater than that number , so end will be that number, start will become mid + 1 , therefore the next element than end element. Here while loop break because end is smaller than start.
* If target is smaller than mid when only 1 element is left then the end element (mid - 1) will become -1 and start element will be that element itself. Even here the ceiling will be start element and floor be the end element ie -1 .
* **Condition** :- Print 1st element from arrayList if the tsrget is bigger than the last element. Here will return **array[start % array.length]** or **if (array[start] == array.length) return 0;**. As in the end only 1 element remains and **start** element will be (mid + 1) ie 1 index more than end. Now as start is 0, 

## Start and end index of element in array
* Use binary search , and use another binary at the place where we find the target ie in the last else stmt.
* If there is another target before ans, search it and will get first index. Else go for last index

# Sorting

## Bubble Sort
* In this we sort the array in ascending or descending order by using 2 for loops.
* The inner for loop will be lesser than **arr.length - i** because in each iteration we see largest number in the end so to sort smaller number, we dont need to check it with the large numbers again and again.
* If arr[j] > arr[i] , means thr array is sorted as no swapping is being done so we can stop the iterations.
* Best case: - O(N) and worst case: - O(N^2).

## Space complexity
* When we creatr a new array , it takes more space.
* In bubble sort, it is **inplace sorting algorithm** means the sorting will take place there itself and no more space is required like copying or creating a new array is not required.

## Stated and unstated sorting algorithms
* In stated sorting algorithms, the original order is maintained. While in unstable, it is not maintained.
* If two numbers are same , so while sorting , the first number occurrence must be at first, and later occurrence must be second then its stable. Otherwise if first occurrence goes to second, it becomes unstable.
* **Break** the loop after the inner for loop if the swap didnt take place.

## Selection sort
* It is not stable sortint algorithm.
* The best and worse case complexity are the same ie O(N^2).
* Used to sort small arrays.
* Make 2 functions to find the maximum number and to swap the numbers .

## Cyclic sort
* When the numbers are given in certain range ie from 1 to N , use cyclic sort.
* This is the best sorting as the steps are very less.
* The index of element is *element - 1* .
* So while swapping we can directly pass the elements to their index box and check whether that index already cintains the element or not because if it does then that means that sorting has already been completed.

# Strings

## Pool
* Pool is inside the heap where it avoids the recreation of a value,
* Strings with same values point at same object. Hence if we change any one variable , it will change the value and all the variables pointing to that value will change. Therefore strings are **mutable** ie we cannot change string once defined.
* We can also explicitly add a string which will store the data outside the heap pool but inside the heap . By all the reference variable will point to the different values even if the values are same. 

## Place Holders 
* We can print the datatypes by using the place holders in java , it is the same thing like format specifier of C .
* For float , to print numbers till 2 decimals we use .2f% , and to print n values after decimal we use .nf% .

## Double and Single apostrophe difference 
* We use single apostrophe to print the characters and if we add 2 chars , it will simply print the addition of both the char's ascii value.
* We use double apostrophe to print the string and if we add 2 string, it will concatinate them.
* We can explicitly use **char** keyword to add an int with the char to get the char value . The char value will be like addition of the ascii number of first char with the int value.
* Otherwise if we add char and int , it will convert the int into toString automatically and add it with the char.

## StringBuilder class
* String builder is same as string just the difference is stringbuilder is **mutable** and strings are immutable.
* Whenever we run a loop in string , it keeps creating new objects in the pool inside heap which reduces the performance and increases the space.

## Methods in string
* There are many predefined methods in string . 
* Like when we use **length** for string , we need to add paranthesis because its a function .
* **toCharArray()** prints the entire string in the form of chars as an array.
* **split** is used to cut the string into an array which will separate the string from the value we pass inside split paranthesis. 

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

## Space complexity
* It is the **extra** space taken by algorithm and the input space.
* **Auxiliary space** is the space which is extra space taken by an algorithm.
* Eg: - In binary search, there was no auxiliary space as we were creating 3 variables s, mid , e and those 3 were only used for any range.
