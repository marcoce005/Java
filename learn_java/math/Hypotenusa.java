import java.util.Scanner;

public class Hypotenusa {
    public static void main(String[] args) {
        double c1, c2, hypo;

        Scanner scanner = new Scanner(System.in);

        System.err.print("Insert first cateto:\t");
        c1 = scanner.nextDouble();
        System.err.print("Insert second cateto:\t");
        c2 = scanner.nextDouble();
        
        //  hypo = Math.hypot(c1, c2);
        hypo = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));

        System.out.println("Hypotenusa:\t" + hypo);
    }
}