# BASIC CONCEPTS IN JAVA
This directory is a simple summary/recap of my learning path in Java for the basic 
concepts.

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

### Encapsulation
The goal of encapsulation is to "hide" important/sensitive data.<br>
* This is achieved by declaring attributes/methods private with the keyword "private".
* The correct way of knowing/accessing these encapsulated elements, is by creating the 
necessary "Getters" and "Setters" methods that can interact with them.

### Static
Static methods or attributes have special properties, like:<br>
* They don't work/operate on objects (they belong to class itself).
* They don't get to know attributes of class, unless they are static as well.
* For using them, user "ClassName.MethodName" (ex: Math.pow(a, b)).

### Inheritance
It is really useful to be able to "inherit" attributes or methods from one class to another.<br>
One important thing to keep in mind, is to change "public" methods, to "protected" 
when we also want inheritance, but without a public access from everything.<br>
We use "private", when the package and the subclasses shouldn't access the 
attribute/method.<br>
Remark: in java, there is not multiple inheritance for a single object, because it 
makes things complex in many ways.<br>
The keyword for achieving inheritance in java is "extends".<br>
This will create an inheritance and generate a "superclass" and a "subclass".<br>
* subclass: the class that inherits from another one (child).
* superclass: the class being inherited from (parent).

### Polymorphism
It is a concept of getting the advantage of "multiple forms".<br>
We usually implement it when there are multiple classes related to each other by 
inheritance.<br>
We take advantage of this, by having common methods, that perform different tasks, 
depending on the context.<br>
For example, if we need similar behaviors that may vary slightly depending on the
subclass, we can implement polymorphism to their methods, by implementing those changes.<br>
* We use it for code reusability for attributes and methods of superclasses.
* We can also "downcast", so that we use an unique "subclass method", directly on an "superclass", by casting it to a "subclass". (Only applies when the object belongs to
the specific "subclass", but was defined as the "superclass".

### Abstraction
This concept is essential in Object-Oriented-Programming.<br>
It is the process of hiding and structuring classes, making superclasses restricted.<br>
When a class is abstract, both abstract methods and class definition must have the keyword "abstract".<br>
Abstract classes can't create objects, they are designed for future subclasses 
implementation (like a hierarchy design).<br>
Abstract methods don't have a body.
They are planned and proposed in the abstract class, but their body must be provided in the subclasses (mandatory).<br>
* Abstract classes could have both abstract and non-abstract methods.
* Usually, abstract classes are to pre-design subclasses and achieve security by hiding certain elements.

### Interfaces
It is another way of achieving abstraction in Java, but with a different approach.<br>
They are completely abstract classes, with a goal of establishing behaviors and 
guidelines for the inherited subclasses.<br>
* They can't be used to create objects and they don´t have a body.
* For implementing, we must override all of the interface methods.
* They help us achieve a simulated "multiple-hierarchy" (that doesn´t exist in Java).
* This is obtained by adding the keyword "implements", before the intefaces.
* If multiple interfaces are implemented, split them with commas (,).


---

## IMPORTS

The main class (java.lang) is imported by default. However, when we want to use other 
classes, we 
must specify that we "import" it with its specific name and the desired 
package/packages. <br>
Remember to checkout when the methods are static or not (that will have an impact in the way we
create and use the functionalities, by creating or not an object before).<br>

### Import Everything from Package:
>import java.util.*;

### Import Only Specific Class from Package:
>import java.util.Scanner;

---

## MATRICES

Matrices are one of the most important element in every programming language. <br>
In Java, we can specify matrices in multiple ways, and the context will determine the 
best alternative.

### Numeric Matrix Example 1:
>int [] my_matrix = new int[5]; <br>
>my_matrix[0] = 1; <br>
>my_matrix[1] = 1; <br>
>my_matrix[2] = 2; <br>
>my_matrix[3] = 3; <br>
>my_matrix[4] = 5; <br>

### Numeric Matrix Example 2:
>int [] my_matrix = {1, 1, 2, 3, 5}; <br>

---

## Exceptions
There are many type of "errors" in programs, some of them easy to handle/know, and others are way more complex to understand.<br>
These "errors" could be created by the programmer, by the user's input, or by other
uncontrollable things (that don't depend on us).<br>
When a known error occurs, Java will "throw an exception" (generate an error message).<br>
There are two main types of errors: Error and Exception. Error is not controllable.<br>
Exceptions, on the other hand, can be of two different kinds: RuntimeException or IOException.<br>
Generally, we will focus on handling the IOExceptions, because they could be an external
problem that doesn't depend on us (while the RuntimeException is usually a logic-problem).<br>
One way of handling these exceptions, is by the try-catch statement, where we define a
block to be tested for possible errors (try)... and we define a block that will be executed
if the error in the "try" occurs (this is the catch part).<br>
* There is a possibility of adding "finally", to add a part that is executed, regardless of
the result in the try-catch.
* We can create custom errors (exceptions), by adding the logic and using the keyword
"throw" in our code, so that we can design our programs more "secure/tested".
