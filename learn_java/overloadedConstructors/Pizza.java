
public class Pizza {

    String bread, cheese, sauce, topping;

    Pizza(String bread, String cheese, String sauce, String topping) {
        this.bread = bread;
        this.cheese = cheese;
        this.sauce = sauce;
        this.topping = topping;
    }

    Pizza(String bread, String cheese, String sauce) {          // constructor without topping
        this.bread = bread;
        this.cheese = cheese;
        this.sauce = sauce;
    }

    Pizza() {           // blank pizza

    }
}
