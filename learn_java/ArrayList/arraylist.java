
import java.util.ArrayList;

public class arraylist {

    public static void main(String[] args) {
        // are resizable array, they only store reference data types.

        ArrayList<String> food = new ArrayList<String>();       // ATTENTION between '<>' must have been a wrapper non a primitive data type

        food.add("pizza");
        food.add("pasta");
        food.add("hot dog");

        for (int i = 0; i < food.size(); i++) {
            System.out.println(food.get(i));
        }

        food.set(0, "sushi");
        food.remove(1);

        System.out.println();
        for (int i = 0; i < food.size(); i++) {
            System.out.println(food.get(i));
        }

        food.clear();
        System.out.println();

        // 2D ArrayList             dynamic list of list
        ArrayList<String> bakeryList = new ArrayList<String>();
        bakeryList.add("pasta");
        bakeryList.add("garlic");
        bakeryList.add("donuts");

        ArrayList<String> produceList = new ArrayList<String>();
        produceList.add("zucchini");
        produceList.add("tomatoes");
        produceList.add("peppers");

        ArrayList<String> drinksList = new ArrayList<String>();
        drinksList.add("soda");
        drinksList.add("cola");

        ArrayList<ArrayList<String>> groceryList = new ArrayList<ArrayList<String>>();
        groceryList.add(bakeryList);
        groceryList.add(produceList);
        groceryList.add(drinksList);

        System.out.println(groceryList);
        System.out.println(groceryList.get(0));
        System.out.println(groceryList.get(0).get(0));
    }
}
