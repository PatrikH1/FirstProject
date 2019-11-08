package jonas.wrapper;

public class testWrapper {
    public static void main(String... args) {
        Integer wrapperInt = 2;
        System.out.println("Value of wrapperInt: " + wrapperInt.intValue());

        // Back to int
        int unwraperInt = wrapperInt;
        System.out.println("Value of unwrapInt: " + unwraperInt);
    }

}
