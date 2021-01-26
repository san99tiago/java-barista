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

In Java, we can have multiple types of classes, both "predefined" and "own". <br>
Predefined classes are really useful for "main-stream" problems and solutions (like String, Math, Array, Thread, etc). <br>
We can learn, search and look for classes in the Java-API.

---

## IMPORTS

The main class (java.lang) is imported by default. However, when we want to use other classes, we 
must specify that we "import" it with its specific name and the desired package/packages. <br>
Remember to checkout when the methods are static or not (that will have an impact in the way we
create and use the functionalities, by creating or not an object before).

### Import Everything from Package:
>import java.util.*;

### Import Only Specific Class from Package:
>import java.util.Scanner;

