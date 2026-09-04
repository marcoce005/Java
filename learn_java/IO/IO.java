
import java.util.Scanner;


public class IO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name:\t");
        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        System.out.print("Age:\t");
        int age = scanner.nextInt();
        scanner.nextLine();         // clean the scanner
        System.out.println("you are " + age + " years old");

        System.out.print("favourite food:\t");
        String food = scanner.nextLine();           // overlapping of scanner
        System.out.println("food:\t" + food);
    }
}
