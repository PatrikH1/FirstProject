package patrik.testMap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainTestMap {

    private static Map<String, Long> numMapLong;
    private static Map<String,String> numMapString = new HashMap<>();

    public static void main(String[] args) {

        numMapString.put("num1","100");
        numMapString.put("num2","200");
        numMapString.put("num3","300");

        numMapLong = numMapString
                .entrySet()
                .stream()
                .collect(Collectors.toMap(num -> num.getKey(), num -> Long.valueOf(num.getValue())));

        long sum = numMapLong
                .entrySet()
                .stream()
                .mapToLong(l -> l.getValue())
                .sum();

        System.out.println("Total: " + sum);

    }


}
