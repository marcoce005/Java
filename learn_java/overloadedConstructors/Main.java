
public class Main {

    public static void main(String[] args) {
        // like overloaded methods same name but different parameters

        Pizza pizza = new Pizza("thicc crusty", "mozzarella", "tomatoes", "pepperoni");

        System.out.printf("ingredients:\t%s\t%s\t%s\t%s\n", pizza.bread, pizza.cheese, pizza.sauce, pizza.topping);

        Pizza pizza2 = new Pizza("thicc crusty", "mozzarella", "tomatoes");

        System.out.printf("ingredients:\t%s\t%s\t%s\t%s\n", pizza2.bread, pizza2.cheese, pizza2.sauce, pizza2.topping);

        Pizza pizza3 = new Pizza();

        System.out.printf("ingredients:\t%s\t%s\t%s\t%s\n", pizza3.bread, pizza3.cheese, pizza3.sauce, pizza3.topping);
    }
}
