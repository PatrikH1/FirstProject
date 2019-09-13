package jonas.teststatic;

public class ClassWithSomeStatic {

    private int int1;
    private int int2;
    private static int intStatic;

    public ClassWithSomeStatic(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public static int getIntStatic() {
        return intStatic;
    }

    public static void setIntStatic(int intStatic) {
        ClassWithSomeStatic.intStatic = intStatic;
    }

    public static void printIntStatic() {
        System.out.println("intStatic: " + ClassWithSomeStatic.intStatic);
    }

    public void printAll() {
        System.out.println("Int1: " + int1);
        System.out.println("intStatic: " + ClassWithSomeStatic.intStatic);
    }
}
