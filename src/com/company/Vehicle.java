package com.company;

public class Vehicle {

    private int id;
    private String color;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicle() {
        id = 1;
        color = "red";
    }

    public Vehicle (int id, String color) {
        this.id = id;
        this.color = color;
    }

    public String toString() {
        return "id = " + id + "; color = " + color;
    }


    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle vehicle2 = new Vehicle(2, "blue");

        System.out.println("id = " + vehicle.getId() + "; color = " + vehicle.getColor());
        System.out.println(vehicle2);
    }

}

