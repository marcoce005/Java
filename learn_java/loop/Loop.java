
import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (name.isBlank()) {
            System.out.print("Enter name:\t");
            name = scanner.nextLine();
        }

        do {
            System.out.print("Enter name:\t");
            name = scanner.nextLine();
        } while (name.isBlank());

        for (int i = 0; i < 10; i++) {
            System.out.println(name + i);
        }

        for (int i = 10; i >= 0; System.out.println(i), i--);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
