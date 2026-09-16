public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();

        System.out.println("brand:\t" + myCar.brand);
        System.out.println("model:\t" + myCar.model);
        System.out.println("price:\t" + myCar.price);
        System.out.println("color:\t" + myCar.color);
        System.out.println("year:\t" + myCar.year);

        myCar.drive();
        myCar.brake();

        Car secondCar = new Car();      // is the same of myCar because is build with a default costructor
    }
}