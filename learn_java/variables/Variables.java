
public class Variables {

    public static void main(String[] args) {
        int x;      // declaretion
        x = 123;    // assignment

        int y = 3;      // initialization

        System.out.println("number:\t" + x);

        long l = 123456789098765432L;               // need the 'L' at the end
        System.out.println("big number:\t" + l);

        float pi = 3.14f;       // need the 'f' at the end
        System.out.println("pi:\t" + pi);

        boolean status = false;
        System.out.println("status:\t" + status);

        char symbol = '@';
        System.out.println("special symbol:\t" + symbol);

        String name = "ciro";
        System.out.println("name:\t" + name);
    }
}
