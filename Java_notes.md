____## How Java executes


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

## Recursion.Arrays.toString
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
* Use ArrayList whenever we want to **append** during **loops or recursion** based on any condition. 
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
* If arr[j] *<* arr[j - 1] , means swap. In this way , the j loop will end once that value reaches the end. Then for another i the loop will start workin.
* Best case: - O(N) and worst case: - O(N^2).

## Cycle Sort
* Use Cycle Sort whenever the range is specified like from 1 till N numbers.
* If range starts from 0 , then the value = index. IF the range starts from 1, then the value = index - 1.


## Space complexity
* When we creatr a new array , it takes more space.
* In bubble sort, it is **inplace sorting algorithm** means the sorting will take place there itself and no more space is required like copying or creating a new array is not required.

## Stated and unstated sorting algorithms
* In stated sorting algorithms, the original order is maintained. While in unstable, it is not maintained.
* If two numbers are same , so while sorting , the first number occurrence must be at first, and later occurrence must be second then its stable. Otherwise if first occurrence goes to second, it becomes unstable.
* **Break** the loop after the inner for loop if the swap didnt take place.

## Selection sort
* It is not stable sorting algorithm.
* Not a good method to use because there are 2 for loop running , and one swap function . Everytime it finds the max value and shift it in the end.
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


## Pattern printing
**Steps**
* 1. No of lines = no of rows .
* 2. Check how many cols are there .
* 3. What to print , try to find the formula related to row and col.


# Recursion
* The functions are stored in the stack once it starts executing and will get out once its task is done.
* Once the work is done , it will flow back to **line where the function was called**.
> Next point very important 
* If we change an array in one recursive call , then it will change for all the recursive calls because they all point at the same box in the memory and they are changed via **reference variable**. So whenever we put arguments in the function it will give that value to the past recursion and in this way the value reaches the main as a tree flow.
* So the function remains in stack till its work is done, the first function which comes is removed in the very end. The very first function of any code is **main** function.
* There must be a **base** function to stop the execution of the recursive function .
* If base function is not presrnt , then **stack overflow** will take place ie the new functions will keep on getting added in the stack till 5he memory exceeds.
* Use **return** keyword whenever we want to return any datatype in the function . Like if the function wants an int , then while calling the recursive function we must **return** the recursive function. Its common sense that if the upper function wants to return something then all the below function must also return that thing. 


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

# Binary 

## Find negative of number 
* First complement the number and add it by 1.

## Get the last number
* To get the last binary code number , we can use **n & (-n)**.
* This will get us the last number.

# Maths for DSA

## Prime number concept
* If a number is prime , then only check the multiples below its **sqrt**, because rest of the above numbers are just repeated to be checked. Like whats the meaning of checking **3** and **12** both for number **36** if we know that 36 comes in 3 already.
* So always put **sqrt** condition in the **while** loop and the **modulo** statement inside **if** condition which will be inside **while** loop .

## GCD/HCF
* 

## LCM
* 

## Insertion Sort
* Insertion Sort works well with **partially sorted datatype** therefore it takes part in **hybrid sorting** algorithms.
* It is stable sorting.
* **Steps reduced** compared to bubble sort because we skip the step if the next number is larger than the number.

## Quick Sort
* It is preferred over the merge sort , as it doesnt create a new array to store the values.
* Quick sort contains 4 variables ie start, end , low, high .
* Pivot is basically a random numbers which must have all the lower numbers on the left hand side and all the larger numbers on the right hand side . It is put into correct position when the while loop breaks and then the task of sorting takes place again .
* Here after the while loop breaks , ie when end < start , then we sort the low and end & start and high . By this , we sort both the sides of pivot.

# Quick Sort VS Merge Sort
## Contiguous and Non-Contiguous Memory allocation
[Memory_Allocation](Resources/Memory_Allocation.png)

* In contiguous memory allocation all the elements are kept adding one by one in sequence .
* In non contiguous memory allocation , elements are scattered in random locations .
* We can do random access in contiguous memory allocation means any element could be reached and uska data can be extracted directly . On the other hand , in non contiguous we have to get all the previous datas to get the data we need in the memory.

## Quick over merge for Arrays
* QuickSort requires alot of random access , therefore as Arrays have contiguous memory allocation , it is possible.
* Quick Sort requires alot of random access of elements therefore arrays being contiguous is advantaguous in finding the elements .
* Quick Sort is **In-place** sorting therefore it doesn't require any extra space for storing a sorted array while merge sort does. **Space complexity** is O(N) for merge sort and O(1) for quickSort.

## Merge over Quick Sort for Linked List
* We

# Recursive Strings
## Skip Char and Strings 
* **substring** method creates a new array from the original array without changing it , also we know that strings are **immutable**. The part we want in new array could be described using the index numbers . If only 1 index is mentioned then it means that all the char after it will be the new array.
* The string will be divided into 2 halves.
* **isEmpty** and **startsWith** are the 2 more inbuilt string methods which we are using here. 

## Subset
* All the elements from a string can form arrays with 1 or more elements of the string , and these elements must be in the given order . Like if string is "abc" then a substring cannot be \[c, a].
* There are many substrings for a string.
* The pattern of taking some elements and removing some elements is known as **subset pattern**. By this pattern , we can easily find the possible answers for a particular string.

## Permutations
* Either it could be added on the **left or on the right** .
* If there are n numbers , then **n!** permutations are possible .

## Combination Sum (Leetcode)
[Permutation Pattern](https://leetcode.com/problems/combination-sum/discuss/1777569/FULL-EXPLANATION-WITH-STATE-SPACE-TREE-oror-Recursion-and-Backtracking-oror-Well-Explained-oror-C%2B%2B)

# OOP
## Classes and objects 
* Java classes are **template** of objects.
* Java objects are **instances** of Java classes.
* Java classes creates **datatype** which is used to create objects.
* Java classes are just logical construct and objects are the one which is physical reality ie it occupies the space of memory.
* Inside objects there are variables, which are known as **instance variables**. So variables defined inside objects are known as **instance variables**. These objects are **instances* of classes**.

## Dot operator
* **Dot** operator is used to link instance objects with instances variables.
* ie used to connect variables with its object.

## new keyword explanation & class memory allocation
* To create an object for a class, we use *new* keyword
* All class objects in java must be allocated dynamically . For this we can use **new** keyword which allocates the new memory to that object
* Dynamic memory allocation means the memory is allocated while your program is **running**.

## Constructor
* These are special type of functions used to define the variables at one place for any class.
* It is used after the **new** keyword because we need to allocate it dynamically. 
* It is used to **define** the variables which will be present inside a class. 
* We dont need to repeat ourselves with **variableName.instanceVariable** .
* **variableName** means the **reference variable** means the one through which we call an object . Objects are not called directly, they are stored in heap . We assign a variable to an object and access everything from that object.
* We use **this** keyword to point the ref var of the class and the RHS value is the assigned value which we mention in the paranthesis while making the constructor or the object. 
* Constructor can follow **Polymorphism** to avoid errors which different number of arguments.
* We can use **nested constructor** too.
* Whenever we use any item of class with any object, then all the items of that class will poin5 to that object.


## This keyword
* We use **this** keyword which shows that which *referenceVar* to point.
* Otherwise we had to manually add all variables fir different referenceVariables.
* Constructor is defined inside the class itself.

## Object memory location
* Object's ref variable point to same object in the stack just like strings. If u change one ref variable then all will change.

## Default instance variable value
* Whenever we call any instance variable using dot operator , and if the instance variable is not initialized with any value then the value will be by default the value of that datatype .
* String will print **null** , int and float will give **0 and 0.0**. 

## Pass by value 
* Java doesn't have pass by reference thing.
* Everything which is passed is pass by value . For eg:- You cannot swap 2 variables a,b by calling a function swap which is made. They will pass the values of the variable and not the variable . So the values will be changed in the swap function but the original a, b variables will remain the same. 

## Pass by reference 
* Whenever we pass an object , it is pass by reference.

## Wrapper classes
* **Integer** , **String** are some predefined wrapper classes which we can use as a datatype and can access to different pre defined properties of it.

## final keyword 
* Once we use final keyword then we cannot change the value of the reference variable .
* This rule is only applicable for primitive datatypes.

## final keyword for objects
* Here we can change the instance variable but we cannot change the object ka reference variable.
* We can change the variable but we cannot **reassign** the object.

## finalize method
* It is called when java is doing garbage collection.
* It helps us to say that what must be done when the objects are destroyed. We cannot destroy the objects manually but can say what is to be done when its destroyed.
* We use this inside the class, and whenever the class is destroyed from the memory then this finalize method will be called.
* It is ran automatically , we cannot ask it to run.

## Packages 
* These are basically the folders itself. If there is one folder inside a folder then the outer folder name will be **combined** with the inner folder name using dot. Like outerName.innerName . And if there are more than one folders inside a folder then the names will remain as it is. There will be no combination.
* We cannot create same name file inside a folder . This is where packages comes in and we can create same named file in **different folders** .
* We can use any function in different files by importing that function . The function must have **public static dataType funcName** to be used by other function.
* We can use class in other files and we dont even need to import the file if both are in same package ie different files in same folder. 

## Static keyword
* Whenever for any class there is a common variable for all the objects , we define it using static keyword.
* Anything defined by static keyword will be **independent** of the objects . It will work even if class doesn't have any instances ie objects .
* Static returns 1 value for all objects , so if the objects are like changing for that static variable then the bottommost object ka value for that static variable will be printed for all objects.
* When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object. You can declare both methods and variables to be static.
* The most common example of a static member is main( ).
* **main( )** is declared as static because it must be called before any objects exist as the file starts running from main so main cannot be dependent method.
* Static method in Java is a method which belongs to the class and not to the object.

## Static VS Non-Static methods
* A static method can call only other static methods and cannot call a non-static method from it.
* A static method can be accessed directly by the class name and doesn’t need any object
* A static method cannot refer to **this** keyword.
* Static methods are class level methods, so it is always resolved during compile time.
* We cannot declare the topmost class as static because it is the only class on which rest of the code is dependent so atleast that class must be independent.
* A static method can access only static data. It cannot access non-static data (instance variables)
* A non-static member belongs to an instance. It's meaningless without somehow resolving which instance of a class you are talking about. In a static context, you don't have an instance, that's why you can't access a non-static member without explicitly mentioning an object reference.
* In fact, you can access a non-static member in a static context by specifying the object reference explicitly :

```java
  public class Human {

  String message = "Hello World";

  public static void display(Human human){
  System.out.println(human.message);
  }

  public static void main(String[] args) {
  Human kunal = new Human();
  kunal.message = "Kunal's message";
  Human.display(kunal);
  }
  }
```
> Only nested classes can be static.
> Static inner classes can have static variables

## static block
* If you need to do computation in order to initialize your static variables, you can declare a **static block** that gets executed exactly once, when the class is first loaded.

```java
// Demonstrate static variables, methods, and blocks.
class UseStatic {
static int a = 3;
static int b;
static void meth(int x) {
System.out.println("x = " + x);
System.out.println("a = " + a);
System.out.println("b = " + b);
}
static {
System.out.println("Static block initialized.");
b = a * 4;
}
public static void main(String args[]) {
meth(42);
}
}
```
 
## Singleton Class
* When we want a particular class to have only one object in it , then we use something called as Singleton Class.
* Logically if we don't allow the user to create a constructor class , then that class will for sure have only **one object** and also only one **instance var**.
* Use **private** keyword on both constructor and instance variable which means that we can only use them inside that file and not in other files.
* If more than one ref variable is pointing to that same class , then just return the constructor which was first created.
* Both object and instance must be **static** because it cannot be dependent on the object as we are not creating any object in other files . We are creating one object inside that file but we cannot create any object in any other files .
* We must put a base condition that if there are no objects , then create one because if any other file creates a ref variable pointing to that object then the object must exist.

## Inheritance 
* We can make many classes from a single class which is called inheritance.
* The parent classes cannot use instances of child classes but child classes can use instances of parents classes.
  1. Multiple inheritance
  * There is no multiple inheritance in java ie we cannot create child of child.
  2. Hierarchial Inheritance
  * We can create multiple class from the initial class. There is only one parent class and rest of them are sibling classes.
  3. Hybrid Inheritance
  * Not in java .
  * Means it will have more than one classes inherited from parent class which is linked to another class .
  
## Extends
* Extends keyword is used in classes. 
* If we extend one class with another , then the extended class can use everything of the other class and in addition we can add more instances to it.
* Every class by default extends the **Object** class inbuilt by Java developers.

## super keyword
* Use **super** keyword for accessing the variables of the parent class. 
* We can even access them using this keyword but the problem is that the compiler will check the object first and then the class . So if the object has a variable of that same name , then it'll just return that . Also thats not a good practice.

## Method Overloading 
* When we create methods with same name but different return type , arguments , types and order of the argument.

## Method overridding
* Means both parent and child has same method in both . 
* Here child class will be prioritized the parent class ka method.
* We use **@override** which is an annotation which will check if the method is overriding or not.
* This happens when the ref var is of super class datatype (ie parent class) and which method will be called will depend on the child . This is known as **Upcasting**.
* What reference variable will be able to access depends on the **datatype** of ref var and which one its able to run will depend on its datatype object.
* We cannot override static methods because we know that static methods are not dependent on any objects . However you call it , it'll be used via parent class only. 
* Overriding depends on objects and static methods doesn't depend on objects , hence static methods cannot be overridden.

## Polymorphism 
* Poly means many and morphism means ways to represent.
* We can create methods with same method name in different files and can call that method in many ways like by specifying the class of those files. 
* Types of Polymorphism: - 
1. Compile Time / Static Polymorphism
* Achieved via Method overloading
2. Runtime / Dynamic Polymorphism
* Achieved via Overriding
* **Dynamic Method Dispatch** is a mechanism in which overridden method is resolved during run time rather than compile time . This is how we do runtime polymorphism. 
* Through this mechanism , java determines that we have to run method of object (child object) and not method of super class (parent class) as both have same methods which is why they are overridden.

## Encapsulation
* Wrapping up the implementation of the data members and methods in a class . It protects the code between it from outside code.
* It is the implementation part of a particular code , like we store the data in some file to make some things work.
* It hides a single entity and protects it from outside world.
* It works on the internal stuffs like its codes and logics.
* It is a process of containing the information.

## Abstraction
* Hiding unnecessary details and showing valuable information only . 
* Some codes are important but not necessary to show. For eg: - Inbuilt methods and classes like ArrayList.
* It is the designing part . Like it will show only necessary files and hide all the logic and files through which that necessary file is working.
* It works on the external stuffs like the things to be displayed.
* It is a process of gaining the information .

