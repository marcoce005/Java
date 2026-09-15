
import java.util.ArrayList;

public class Foreach {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};

        for (int e : numbers) {         // foreach elements in the array numbers
            System.err.println(e);
        }
        // Object instead of the type to make flexible

        ArrayList<String> animals = new ArrayList<String>();
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");
        animals.add("turtle");

        for (String e : animals) {
            System.err.println(e);
        }
    }
}