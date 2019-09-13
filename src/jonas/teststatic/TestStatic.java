package jonas.teststatic;

public class TestStatic {

    public static void main(String... args) {
        TestStatic testStatic= new TestStatic();
        System.out.println("This is teststatic!");
        printStaticMethod();
        testStatic.notPrintStaticMethod();

        // Test of class ClassWithSomeStatic
        ClassWithSomeStatic.setIntStatic(5);
        ClassWithSomeStatic someStatic1 = new ClassWithSomeStatic(1, 2);
        ClassWithSomeStatic someStatic2 = new ClassWithSomeStatic(3, 4);

        System.out.println();

        // Printing values.
        System.out.println("Some static 1");
        System.out.println("-----------------");
        someStatic1.printAll();
        System.out.println();
        System.out.println("Some static 2");
        System.out.println("-----------------");
        someStatic2.printAll();
        System.out.println();

        System.out.println("**********************");
        System.out.println("New values are set");
        System.out.println("**********************");
        System.out.println();
        // Set new values.
        someStatic1.setInt1(11);
        someStatic2.setInt1(13);
        ClassWithSomeStatic.setIntStatic(15);

        // Printing values.
        System.out.println("Some static 1");
        System.out.println("-----------------");
        someStatic1.printAll();
        System.out.println();
        System.out.println("Some static 2");
        System.out.println("-----------------");
        someStatic2.printAll();
        System.out.println();
    }

    private static void printStaticMethod() {
        System.out.println("Inside printStaticMethod!");
    }

    private void notPrintStaticMethod() {
        System.out.println("Inside notPrintStaticMethod!");
    }
}
