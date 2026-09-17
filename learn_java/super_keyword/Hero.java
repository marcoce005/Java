
public class Hero extends Person {

    String power;

    public Hero(String name, int age, String power) {
        super(name, age);
        this.power = power;
    }

    public String toString() {
        return super.name + "\t" + super.age + "\t" + this.power;
    }
}
