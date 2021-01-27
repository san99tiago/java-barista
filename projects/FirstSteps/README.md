# BASIC CONCEPTS IN JAVA
This directory is my learning path in Java for the basic concepts.

---
## DATA TYPES

### Whole Numbers

* Byte: Numbers that take 1 byte of storage-space. In range (+/-128)

* Short: Numbers that take 2 bytes of storage-space. In range (+/- 32,768).


* Int: Numbers that take 4 bytes of storage-space. In range (+/- 2,147,483,648).

* Long: Numbers that take 8 bytes of storage-space. In range (+/- -9,223,372,036,854,775,808).

### Fractional Numbers

* Float: Numbers that take 4 bytes of storage-space. Sufficient for storing 6 to 7 decimal digits.

* Double: Numbers that take 8 bytes of storage-space. Sufficient for storing 15 decimal digits.

### Boolean Numbers

* Boolean: Numbers that take 1 bit of storage-space. True of False values.

### Characters

* Char: Store a single character or letter from the ASCII values.

---

## VARIABLES

We must specify the name and the data-type for all variables.

### Declare Variable Example 1:
>String my_var; <br>
>my_var = "Santiago";

### Initialize Variable Example 2:
>String my_var = "Santiago"

---

## CONSTANTS

They play an important role for always-fixed "variables". <br>
The way to to them is by adding "final" at the start of the statement.

### Create Constant Example:
>final double in_to_cm = 2.54;

---

## CLASSES

In Java, we can have multiple types of classes, both "predefined" by libraries and our "own"classes. <br>
Predefined classes are really useful for "main-stream" problems and solutions (like String, Math, Array, Thread, etc). <br>
We can learn, search and look for classes in the Java-API.<br>
Java is an Object-Oriented-Programming language, so working with classes is "mandatory".<br><br>

It is important to follow conventions like:<br>
--> Classes should always start with an upper-case letter.<br>
--> The name of the Java file, should match the class name.<br><br>

The OOP paradigm works with two important concepts:<br>
--> Attributes: properties/fields/elements/variables that objects "have".<br>
--> Methods: things that objects "do".<br>
Both attributes and methods, are accessed by the (.) dot notation (after the class name).<br>

### Constructor
It's the special method that is used to initialize an object in OOP.<br>
It is usually called at the moment of creating a class.<br>
It is mandatory for it to have the same name as the class.<br>
Constructors should not return anything! <br>
* We can "overload" constructors by having multiple of them (same name and different amount of arguments).

### Getters
Are methods with a purpose of "getting" (returning) specific private attributes/things from classes.<br>
They must return something.<br>

### Setters
Are methods to "set" (change) specific private attributes from classes.<br>
They shouldn't return anything (void as output type).<br>

### Static
Static methods or attributes have special properties, like:<br>
* They don't work/operate on objects (they belong to class itself).
* They don't get to know attributes of class, unless they are static as well.
* For using them, user "ClassName.MethodName" (ex: Math.pow(a, b)).

---

## IMPORTS

The main class (java.lang) is imported by default. However, when we want to use other classes, we 
must specify that we "import" it with its specific name and the desired package/packages. <br>
Remember to checkout when the methods are static or not (that will have an impact in the way we
create and use the functionalities, by creating or not an object before).<br>

### Import Everything from Package:
>import java.util.*;

### Import Only Specific Class from Package:
>import java.util.Scanner;

---

## MATRICES

Matrices are one of the most important element in every programming language. <br>
In Java, we can specify matrices in multiple ways, and the context will determine the best alternative.

### Numeric Matrix Example 1:
>int [] my_matrix = new int[5]; <br>
>my_matrix[0] = 1; <br>
>my_matrix[1] = 1; <br>
>my_matrix[2] = 2; <br>
>my_matrix[3] = 3; <br>
>my_matrix[4] = 5; <br>

### Numeric Matrix Example 2:
>int [] my_matrix = {1, 1, 2, 3, 5}; <br>

