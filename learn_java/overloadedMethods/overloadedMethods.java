
public class overloadedMethods {

    public static void main(String[] args) {
        // methods name + parameters are unique

        int a = 4, b = 3, c = 32;
        double x = 6.7, y = 6.9;

        System.out.println(a + " + " + b + " = " + add(a, b));

        System.out.println(a + " + " + b + " + " + c + " = " + add(a, b, c));

        System.out.println(x + " + " + y + " = " + add(x, y));
    }

    static int add(int a, int b) {
        return  a + b;
    }

    static int add(int a, int b, int c) {
        return  a + b + c;
    }

    static double add(double a, double b) {
        return  a + b;
    }
}
