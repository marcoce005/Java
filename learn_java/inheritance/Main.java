public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bike = new Bicycle();
        
        car.go();
        bike.stop();

        System.out.println(car.speed);

        System.out.println("pedals bike:\t" + bike.pedals);

        System.out.println("car doors:\t" + car.doors);
    }
}