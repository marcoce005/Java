
public class methods {

    public static void main(String[] args) {
        hello("ciro", 67);

        System.out.println("6 + 7 --> " + add(6, 7));
    }

    static void hello(String x, int n) {       // need to be static beacuse the main is static
        System.out.println("Hello " + x + n);
    }

    static int add(int a, int b) {
        return a + b;
    }
}
