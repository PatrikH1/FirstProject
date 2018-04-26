package com.company;

import java.util.List;
import java.util.ArrayList;
import java.time.chrono.IsoChronology;
import java.time.LocalDate;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int number;

    Person(String nameArg,
           LocalDate birthdayArg,
           Sex genderArg,
           String emailArg,
           int numberArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
        number = numberArg;
    }

    public int getAge() {
        return birthday
                //.until(IsoChronology.INSTANCE.date(2121, 6, 20))
                .until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }

    public void printPerson() {
        System.out.println(name + ", " + this.getAge());
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getNumber() {
        return number;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<Person>();

        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com",
                        1));

        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com",
                        2));

        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com",
                        3));

        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com",
                        4));

        roster.add(
                new Person(
                        "Patrik",
                        IsoChronology.INSTANCE.date(1964, 2, 2),
                        Person.Sex.MALE, "patrik@example.com",
                        5));

        roster.add(
                new Person(
                        "Jonas",
                        IsoChronology.INSTANCE.date(2000, 5, 5),
                        Person.Sex.MALE, "patrik@example.com",
                        6));

        roster.add(
                new Person(
                        "Hui",
                        IsoChronology.INSTANCE.date(1958, 5, 6),
                        Person.Sex.FEMALE, "hui@example.com",
                        7));

        return roster;
    }

    public String toString() {
        return "Name: " + name + ";\tBorn: " + birthday + "; \tGender: " + gender + "; \tEmail: " + emailAddress;
    }

}