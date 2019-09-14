package patrik.testenum;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.stream.Collectors;

public class TestEnum {

    private static Map<String, String> mapFamily = new LinkedHashMap<>();

    private static void createMapFamily() {
        mapFamily.put("Father", "Patrik");
        mapFamily.put("Mother", "Hui");
        mapFamily.put("Son", "Jonas");
    }

;    public static void main(String... args) {
        System.out.println("Enum FATHER, name is " + EnumTwoVariables.FATHER.getName() + " and age " + EnumTwoVariables.FATHER.getAge());
        System.out.println("Enum MOTHER, name is " + EnumTwoVariables.MOTHER.getName() + " and age " + EnumTwoVariables.MOTHER.getAge());
        System.out.println("Enum SON, name is " + EnumTwoVariables.SON.getName() + " and age " + EnumTwoVariables.SON.getAge());
        System.out.println();

        createMapFamily();
        System.out.println("Print out all mapFamily:");
        for (Entry<String, String> entry : mapFamily.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("Print fathers name in map: "  + mapFamily.get("Father"));
        System.out.println("Print the entry: " + mapFamily.entrySet());

        System.out.println("Using stream below:");
        mapFamily.entrySet().stream().forEach(map -> System.out.println(map));

        EnumTwoVariables[] enumTwoVariablesArr = EnumTwoVariables.values();
        System.out.println("Enums as an array below:");
        for (EnumTwoVariables entry : enumTwoVariablesArr) {
            System.out.println(entry);
        }

        List<EnumTwoVariables> twoVariablesList = Arrays.asList(enumTwoVariablesArr);
        System.out.println("Enums as an list below:");
        for (EnumTwoVariables entry : twoVariablesList) {
            System.out.println(entry);
        }

        List<Integer> allAges = twoVariablesList
                .stream()
                .map(EnumTwoVariables::getAge)
                .collect(Collectors.toList());
        System.out.println("List of all ages:");
        for (Integer age : allAges) {
            System.out.println(age);
        }
    }
}
