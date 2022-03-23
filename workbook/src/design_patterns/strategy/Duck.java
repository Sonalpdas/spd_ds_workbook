package design_patterns.strategy;

public abstract class Duck{

    FlyBehavior flyBehaviour;
    QuackBehavior quackBehaviour;
    public Duck(){};

    public abstract void display();

    public void performFly(){
        flyBehaviour.fly();
    }

    public void performQuack(){
        quackBehaviour.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }

}
