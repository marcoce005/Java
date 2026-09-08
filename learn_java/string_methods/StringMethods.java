public class StringMethods {
    public static void main(String[] args) {
        String name = "Ciro";

        System.out.println("original:\t" + name);

        System.out.println("ciro == " + name + ":\t" + name.equals("ciro"));

        System.out.println("lenght:\t" + name.length());

        System.out.println("first character:\t" + name.charAt(0));

        System.out.println("index of 'r':\t" + name.indexOf('r'));

        System.out.println("empty:\t" + name.isEmpty());

        System.out.println(name.toUpperCase());

        System.out.println(name.toLowerCase());

        String censured = name.replace('r', 'X');
        System.out.println(censured);
    }
}