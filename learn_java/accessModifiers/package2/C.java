package package2;

public class C {
    String defaultMessage = "This is default";          // visible only for classes in package2 folder

    public String publicMessage = "This is pubblic";        // visible to any classes in the project folder

    protected String protectedMessage = "This is protected";        // visible to itself and to all its children

    private String privateMessage = "This is private";      // only visible to the class its contains itself
}