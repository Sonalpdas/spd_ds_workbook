package design_patterns.observer;

public interface Observer {
    // These are the state values that the observer get frin tge Subject when a weather measurement changes
    public void update(float temp, float humidity, float pressure);
}
