
public class Main {

    public static void main(String[] args) {
        // static is a modifier
        // a single copy of a variable / method is created and shared
        // the class owns the static member

        System.out.println(Friend.numbersOfFriends);

        Friend friend1 = new Friend("ciro");

        System.out.println(Friend.numbersOfFriends);

        Friend friend2 = new Friend("pippo");
        Friend friend3 = new Friend("pluto");
        System.out.println(Friend.numbersOfFriends);


        Friend.displayFriends();
        // numberOfFriends is the same foreach the istance of the class
    }
}
