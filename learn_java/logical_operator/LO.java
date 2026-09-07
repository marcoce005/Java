import java.util.Random;

public class LO {

    public static void main(String[] args) {
        Random ran = new Random();

        int temp = ran.nextInt(-10, 37),
                humidity = ran.nextInt(100);

        System.out.println("Temp outside:\t" + temp);
        System.out.println("Humidity outside:\t" + humidity + " %");

        if (temp > 30 || humidity > 50) {
            System.out.println("It's hot or humid");
        } else if ((temp >= 20 && temp <= 30) || humidity < 30) {
            System.out.println("It's warm or dry");
        } else {
            System.out.println("It's cold");
        }

        System.out.println("!true == false \t " + (!true == false));
    }
}
