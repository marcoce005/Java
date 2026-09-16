
import java.util.Random;

public class DiceRoller {
    // local version

    // DiceRoller() {
    //     Random ran = new Random();
    //     int number = 0;
    //     roll(ran, number);
    // }
    // void roll(Random r, int num) {
    //     num = r.nextInt(1, 6);
    //     System.out.println(num);
    // }

    // global version

    Random ran;
    int number;

    DiceRoller() {
        ran = new Random();
        roll();
    }

    void roll() {
        number = ran.nextInt(1, 6);
        System.out.println(number);
    }

}
