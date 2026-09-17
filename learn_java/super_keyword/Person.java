
public class Person {

    String name;
    int age;

    public Person(String n, int a) {
        this.name = n;
        this.age = a;
    }

    public String toString() {
        return this.name + "\t" + this.age + "\n";
    }
}
