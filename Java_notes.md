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
* The worst case here can be log(N)/log(2) where N is the length of array.
* We find the middle element in a **sorted** array and will ignore the elements before and after it depending on the element we want to find.
* The index number doesnt change after ignoring the rest elements, ie , we dont reduce the original array.
* mid formula must be **start + (end - start)/2** because **start + end** might exceed the range of int sometimes . Bith will give same answer.

