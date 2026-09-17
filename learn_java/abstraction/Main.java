public class Main {
    public static void main(String[] args) {
        // abstract can be applied to both class and methods

        // abstract classes cannot be instantiated but they can have a subclass
        // abstract methods are declared without an implementation

        Car car = new Car();

        car.go();
    }
}