
import java.util.Random;

public class Switch {

    public static void main(String[] args) {
        int a = 3, b = 5;
        String operators = "+-*/";

        Random ran = new Random();

        // or standard switch with : and break;
        switch (operators.charAt(ran.nextInt(operators.length()))) {
            case '+' ->
                System.out.println(a + " + " + b + " = " + (a + b));

            case '-' ->
                System.out.println(a + " - " + b + " = " + (a - b));

            case '*' ->
                System.out.println(a + " * " + b + " = " + (a * b));

            case '/' ->
                System.out.println(a + " / " + b + " = " + ((double) a / b));

            default ->
                throw new AssertionError();
        }
    }
}
