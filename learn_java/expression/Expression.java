
public class Expression {

    public static void main(String[] args) {
        int qty = 10;

        System.out.println(qty + " + 3 = " + (qty + 3));
        System.out.println(qty + " - 3 = " + (qty - 3));
        System.out.println(qty + " * 3 = " + (qty * 3));
        System.out.println(qty + " / 3 = " + (qty / 3));
        System.out.println(qty + " % 3 = " + (qty % 3));

        qty++;
        System.out.println(qty);
        qty--;
        System.out.println(qty);

        qty *= 2;           // short version
        System.out.println(qty);

        System.out.println((float) qty);     // casting

    }
}
