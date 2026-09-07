
import java.util.Random;

public class If {

    public static void main(String[] args) {
        Random random = new Random();
        int age = random.nextInt(100);

        System.out.println("your age:\t" + age);

        if (age > 90) {
            System.out.println("elderly");
        } else if (age < 10) {
            System.out.println("baby");
        } else if (age >= 90) {
            System.out.println("adult");
        }
    }
}
