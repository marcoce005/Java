
import java.util.Random;

public class Array {

    public static void main(String[] args) {
        String[] names = {"ciro", "pippo", "pluto", "paperino"};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        int[] numbers = new int[4];         // array of 4 numbers

        Random ran = new Random();
        for (int i = 0; i < numbers.length; numbers[i] = ran.nextInt(), i++);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);

        }

        int[][] matrix = new int[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; matrix[i][j] = (i * matrix.length) + j, j++);
        }

        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
