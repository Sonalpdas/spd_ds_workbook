package design_patterns.strategy;

public class MiniDuckSimulator {
    public static void main(String args[]) {

        // Type 1: Defining concrete class behaviors using its constructor
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        // Type 2: Defining concrete class behavior dynamically
        Duck model = new ModelDuck();
        model.performFly(); // Calls default fly behavior from concrete class constructor
        model.setFlyBehaviour(new FlyRockerPowered()); // Dynamically specifying concrete class behavior at runtime.
        model.performFly();
    }
}
