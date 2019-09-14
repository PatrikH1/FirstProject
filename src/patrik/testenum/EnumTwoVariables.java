package patrik.testenum;

public enum EnumTwoVariables {
    FATHER("Patrik", 55),
    MOTHER("Hui", 61),
    SON("Jonas", 19);

    private String name;
    private int age;

    EnumTwoVariables(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
