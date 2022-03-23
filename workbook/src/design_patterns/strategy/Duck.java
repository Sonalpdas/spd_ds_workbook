/*
------------------------------------------------------------------------------------------------------------------------
Design Pattern: Strategy
Def: defines a family of algorithms, encapsulates each one, and makes them interchangeable.
Strategy lets the algorithm vary independently of clients that use it.
------------------------------------------------------------------------------------------------------------------------
Design Principles in this chapter:

1. Identify the aspects of your app that vary and separate them from what stays the same:
    - In this example: Fly and Quack behaviors vary for concrete classes (Mallar, model ducks etc.)
    - A separate algorithm was created to manage the behavior (using interface and subsequent classes that implement it)
    , which isolates the code from main Duck class

2. Program to an interface, not an implementation:
    - Duck class doesn't implement the fly and quack behavior interfaces
    - A set of behavior specific classes are created that implements those interfaces.
    - This is different from defining behavior in superclass Duck, or by providing a specialized implementation in the
    subclass itself. In both cases we were relying on implementation. We were locked into using that implementation and
    there was no room for changing the behavior other than writing more code.

3. Favor composition over inheritance:
    - Creating systems using composition gives a lot more flexibility, not only does it let encapsulate a family of
    algos into their own set of classes (e.g: fly behavior classes from fly behavior interface), but it also lets
    change behavior at runtime as long as the object composing with implements the correct behavior interface.
------------------------------------------------------------------------------------------------------------------------
 */


package design_patterns.strategy;

public abstract class Duck{

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck(){};

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    // Adding dynamic behaviour in Duck class
    // We call these set methods to allow concrete classes
    // To change the fly and quack behavior dynamically
    public void setFlyBehaviour(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehaviour(QuackBehavior qb) {
        quackBehavior = qb;
    }


    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }

}
