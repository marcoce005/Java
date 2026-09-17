public class Car extends Vehicle {
    @Override
    void go() {     // has to be implemented in each child
        System.out.println("go");
    }
}