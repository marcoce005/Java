
public class Main {

    public static void main(String[] args) {
        Human human = new Human("ciro", 69, 67.5),
                human2 = new Human("pippo", 73, 104);

        System.out.printf("%s\t%d\t%f\n", human.name, human.age, human.weight);
        System.out.printf("%s\t%d\t%f\n", human2.name, human2.age, human2.weight);

        human.drink();

        human2.eat();
    }
}
