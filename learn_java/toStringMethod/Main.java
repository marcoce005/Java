
public class Main {

    public static void main(String[] args) {
        Car car = new Car();

        System.out.println(car);        // the address of car object [Car@44a664f2]
        // the same as (without overloading)
        // System.out.println(car.toString());

        System.out.println(car.toString());
    }
}
