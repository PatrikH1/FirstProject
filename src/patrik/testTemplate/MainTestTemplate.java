package patrik.testTemplate;

public class MainTestTemplate {

    public static void main(String... args) {
        SomeValues values1 = new SomeValues("Hej", 123L, 123.12F);

        String stringFromValues1 = SomeValues.getVarde("stringValue", values1);
        Long longFromValues1 = SomeValues.getVarde("longValue", values1);
        Float floatFromValues1 = SomeValues.getVarde("floatValue", values1);

        System.out.println("Value of String: " + stringFromValues1);
        System.out.println("Value of Long: " + longFromValues1);
        System.out.println("Value of Float: " + longFromValues1);
    }

}

