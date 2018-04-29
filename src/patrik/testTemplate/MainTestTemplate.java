package patrik.testTemplate;

import java.lang.reflect.Field;

public class MainTestTemplate {

    private static <T> T getVarde(String faltnamn, SomeValues someValues) {
        try {
            Field falt = someValues.getClass().getDeclaredField(faltnamn);
            falt.setAccessible(true);
            return (T) falt.get(someValues);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String... args) {
        SomeValues values1 = new SomeValues("Hej", 123L, 123.12F);

        String stringFromValues1 = getVarde("stringValue", values1);
        Long longFromValues1 = getVarde("longValue", values1);
        Float floatFromValues1 = getVarde("floatValue", values1);

        System.out.println("Value of String: " + stringFromValues1);
        System.out.println("Value of Long: " + longFromValues1);
        System.out.println("Value of Float: " + longFromValues1);

    }



}

