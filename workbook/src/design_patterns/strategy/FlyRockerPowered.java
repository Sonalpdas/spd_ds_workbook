package design_patterns.strategy;

public class FlyRockerPowered implements FlyBehavior {

    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
