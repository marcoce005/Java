package calc;

public class Calculator {
    // CONSTANTS
    static final int SUM = 1;
    static final int SUB = 2;
    static final int MUL = 3;
    static final int DIV = 4;
    static final int EXIT = 0;

    // Global variables of the class
    static boolean error = false;
    static String errorMessage;

    public static void main(String[] args) {
        int choice;
        double num1;
        double num2;
        double result;

        IO.println("\nSimple Calculator");
        while (true) {
            // Display the menu
            IO.println(SUM+". Add");
            IO.println(SUB+". Subtract");
            IO.println(MUL+". Multiply");
            IO.println(DIV+". Divide");
            IO.println(EXIT+". Exit");
            
            String in = IO.readln("Enter your choice (1-5): ");
            choice = Integer.parseInt(in);

            // Check for exit condition
            if (choice == EXIT) {
                break;
            }

            // Get user input for numbers
            in = IO.readln("Please, enter first operand: ");
            num1 = Double.parseDouble(in);
            in = IO.readln("Please, enter second operand: ");
            num2 = Double.parseDouble(in);

            // Compute result
            result = compute(choice, num1, num2);

            // Display the result
            if( error ){
                IO.println("Error: " + errorMessage);
            }else{
                IO.println("Result: " + String.format("%.2f", result));
            }
        }

        IO.println("Thank you for using the calculator!");
    }

    /**
     * This method computes the result of the operation applied on the two numbers.
     * If an error occurs, it sets the variable error to true otherwise it sets it to false.
     * 
     * @param operation the operation to be performed
     * @param num1 first operand
     * @param num2 second operand
     * @return the result of the operation
     */
    public static double compute(int operation, double num1, double num2) {
        double result = 0.0;
        error = false;
        switch (operation) {
            case SUM:
                result = add(num1, num2);
                break;
            case SUB:
                result = sub(num1, num2);
                break;
            case MUL:
                result = multiply(num1, num2);
                break;
            case DIV:
                result = divide(num1, num2);
                break;
            default:
                setError("Invalid operation");
                return Double.NaN;
        }
        return result;
    }

    private static void setError(String msg){
        errorMessage = msg;
        error = true;
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double sub(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 != 0.0) {
            return num1 / num2;
        } else {
            setError("Division by zero!");
            return Double.NaN;
        }
    }
}
