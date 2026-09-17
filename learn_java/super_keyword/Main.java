
public class Main {

    public static void main(String[] args) {
        // super refers to the parent [obviusly need inheritance]

        Hero hero1 = new Hero("ciro", 67, "rubare i motorini");


        System.out.println(hero1.name + "\t" + hero1.age + "\t" + hero1.power);

        System.out.println(hero1);
    }
}