
public class Main {

    public static void main(String[] args) {
        // method overriding --> declaring a method in sub class which is already present in parent class
        //                  the child class can give its own implementation

        Animal a = new Animal();
        Dog d = new Dog();

        a.speak();
        d.speak();
    }
}
