package package1;

import package2.C;

public class A {
    protected String protectedMessage = "This is protected";

    public static void main(String[] args) {
        C c = new C();
        
        // System.out.println(c.defaultMessage);            // error

        System.out.println(c.publicMessage);
    }
}
