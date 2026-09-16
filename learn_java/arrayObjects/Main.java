
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Food[] refrigeretor = new Food[3];

        Food f1 = new Food("pizza");
        Food f2 = new Food("pasta");
        Food f3 = new Food("eggs");

        Food[] refrigeretor = {f1, f2, f3};

        // refrigeretor[0] = f1;
        // refrigeretor[1] = f2;
        // refrigeretor[2] = f3;
        System.out.println(refrigeretor[0].name);
        System.out.println(refrigeretor[1].name);
        System.out.println(refrigeretor[2].name);

        ArrayList<Food> list = new ArrayList<Food>();
        list.add(f1);
        list.add(f2);
        list.add(f3);

        System.out.println((list.get(0)).name);
    }
}
