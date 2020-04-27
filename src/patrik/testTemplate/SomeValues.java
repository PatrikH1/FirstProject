package patrik.testTemplate;

import java.lang.reflect.Field;

public class SomeValues {
    private String stringValue;
    private Long longValue;
    private Float floatValue;

    public static <T> T getVarde(String faltnamn, SomeValues someValues) {
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

    public SomeValues(String stringValue, Long longValue, Float floatValue) {
        this.stringValue = stringValue;
        this.longValue = longValue;
        this.floatValue = floatValue;
    }
}
