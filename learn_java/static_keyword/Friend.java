public class Friend {
    String name;
    static int numbersOfFriends;

    Friend(String name) {
        this.name = name;
        numbersOfFriends++;
    }

    static void displayFriends() {
        System.out.println("You have " + numbersOfFriends + " friends. ");
    }
}