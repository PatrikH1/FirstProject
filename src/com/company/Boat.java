package com.company;

public class Boat extends Vehicle{

    final private String type = "boat";

    public String getType() {
        return type;
    }

    public Boat() {
        super();
    }

    public String toString() {
        return "Type of vehicle = " + type + "; " + super.toString();
    }

    public static void main(String[] args) {
        Boat boat = new Boat();

        System.out.println("Type of vehicle = " + boat.getType());
        System.out.println(boat);

    }

}

