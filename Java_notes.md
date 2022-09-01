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

## Space complexity
* When we creatr a new array , it takes more space.
* In bubble sort, it is **inplace sorting algorithm** means the sorting will take place there itself and no more space is required like copying or creating a new array is not required.

## Stated and unstated sorting algorithms
* In stated sorting algorithms, the original order is maintained. While in unstable, it is not maintained.
* If two numbers are same , so while sorting , the first number occurrence must be at first, and later occurrence must be second then its stable. Otherwise if first occurrence goes to second, it becomes unstable.


