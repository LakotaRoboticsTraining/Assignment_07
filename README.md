# Lesson 7: Classes and Objects

Goal: Understand what a class is, create an object with new, and use fields and methods on that object.

Time: About 40-50 minutes

## You will learn

- A class is the blueprint; an object is one instance built from that blueprint
- How to declare fields (data stored in the object)
- How to write methods that belong to the object (not static)
```java
How to construct an object with new and the default constructor
```

- Dot notation: object.method() and object.field
Before this lesson: Lessons 1-6 (especially methods). You already typed public class Main as required setup - now you learn what a class is for.

## Why this matters for robots

Your FRC project is full of objects: a DriveTrain, a Shooter, a Dashboard. Each one keeps its own data (speed, position) and offers methods (drive, shoot). This lesson is the Java idea behind those robot pieces.

## The big idea

You have already interacted with classes like String (where "Java" is the object). Now, let's build a custom class from scratch to see how these blueprints come to life.

## UML Class Diagrams

In order to build our custom class from scratch we will leverage UML (Unified Modeling Language) class diagrams, which are a standard way to visualize the structure of classes and the relationships between them. They provide a quick way to draft classes without requiring in depth knowledge of the programming language. A class diagram box is divided into three parts:

- Top: Class Name
- Middle: Fields (attributes/variables)
- Bottom: Behaviors (methods)
Visibility markers define how other classes can interact with these members: use '+' for public members and '-' for private members.

## A tiny class: `RobotBot`

```java
public class RobotBot {
    String name;
    int teamNumber;
```

```java
    public void introduce() {
        System.out.println("I am " + name + ", team " + teamNumber);
    }
```

```java
    public void setName(String newName) {
        name = newName;
    }
}
```



- name and teamNumber are fields (variables that belong to the object)
- introduce and setName are methods on the object
- These methods are not static - they need an object to run
Keep this in RobotBot.java. The file name must match the class name (Lesson 1 rule).

## Creating an object with `new`

In Main.java:

```java
public class Main {
    public static void main(String[] args) {
        RobotBot bot = new RobotBot();
        bot.name = "Sparky";
        bot.teamNumber = 1038;
        bot.introduce();
    }
}
```



Resulting Output:

I am Sparky, team 1038

## `static` vs instance (just enough)

```java
You have been writing public static void main and public static int add.
```

- Robot subsystems almost always use instance methods: shooter.run(), driveTrain.stop().
## More than one object

Each object has its own field values:

```java
RobotBot alpha = new RobotBot();
alpha.name = "Alpha";
alpha.teamNumber = 1038;
```

```java
RobotBot beta = new RobotBot();
beta.name = "Beta";
beta.teamNumber = 254;
```

```java
alpha.introduce();
beta.introduce();
```



Changing beta.name does not change alpha.name.

## Common mistakes

```java
Forgetting new - RobotBot bot; does not create an object yet
```

- Calling an instance method without an object - introduce(); fails; use bot.introduce();
- File / class name mismatch - RobotBot must live in RobotBot.java
- Putting everything in Main - the point is a second class that models a thing
- Using static on introduce by habit - then you cannot use name as an instance field the same way

## Try it yourself

You will build a `Game` class and use it from `Main`.

### Challenge 1 - Fields, constructor, getters, toString

Create class `Game` with private fields `name` (String), `year` (int), `type` (String).

- Constructor: `Game(String name, int year, String type)`
- Getters: `getName()`, `getYear()`, `getType()`
- `toString()` must include the name, year, and type

### Challenge 2 - play method

Add `public void play()` that prints a message containing the word `play`.

### Challenge 3 - Two objects in main

In `Main`:

1. `Game pokemon = new Game("Pokemon", 1996, "RPG");`
2. `Game spaceball = new Game("Spaceball", 1986, "Pinball");`
3. Print pokemon's name, year, and type (getters)
4. Print `spaceball.toString()`
5. Call `play()` on both

## Check your understanding

1. <details>
     <summary>What is the difference between a class and an object?</summary>
     Class = blueprint; object = one instance built from it.
   </details>
2. <details>
     <summary>What does `new RobotBot()` do?</summary>
     Creates a new `RobotBot` object in memory (default constructor).
   </details>
3. <details>
     <summary>Why does `bot.introduce()` need `bot.` in front?</summary>
     `introduce` is an instance method - it runs on a specific object.
   </details>
4. <details>
     <summary>If you have two `RobotBot` objects, do they share the same `name` field?</summary>
     No. Each object has its own `name`.
   </details>

## Looking ahead

In Lesson 8, you will write constructors so fields are set correctly when you call new, instead of assigning them one by one afterward.

Lesson complete. When you can write a small class, create objects with new, and call instance methods, you are ready for Lesson 8.
