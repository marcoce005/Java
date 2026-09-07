
public class math {

    public static void main(String[] args) {
        double x = 3.14,
                y = -10;

        double z = Math.max(x, y);

        System.out.println("max:\t" + z);

        System.out.println("|" + y + "| = " + Math.abs(y));

        System.out.println("sqrt(" + x + ") = " + Math.sqrt(x));

        System.out.println("floor of " + x + ":\t" + Math.floor(x));
        
        System.out.println("ceil of " + x + ":\t" + Math.ceil(z));
    }
}
