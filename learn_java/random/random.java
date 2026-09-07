import java.util.Random;

public class random {

    public static void main(String[] args) {
        Random ram = new Random();

        System.out.println(ram.nextInt());

        int dice = ram.nextInt(1, 6);

        System.err.println("dice result:\t" + dice);

        System.out.println("random double:\t" + ram.nextDouble());

        System.out.println("random boolean:\t" + ram.nextBoolean());
    }
}
