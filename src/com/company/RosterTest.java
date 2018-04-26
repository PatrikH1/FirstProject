package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.lang.Iterable;

public class RosterTest {

    interface CheckPerson {
        boolean test(Person p);
    }

    interface HowMany {
        String numOf(String info, List<Person> roster);
    }

    public static void printNumOfPersons(String info, List<Person> roster, HowMany howMany) {
        System.out.println(howMany.numOf(info, roster));
    }

    // Approach 1: Create Methods that Search for Persons that Match One
    // Characteristic

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // Approach 2: Create More Generalized Search Methods

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3: Specify Search Criteria Code in a Local Class
    // Approach 4: Specify Search Criteria Code in an Anonymous Class
    // Approach 5: Specify Search Criteria Code with a Lambda Expression

    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // My own test to use an interface.
    public static void printHowManyPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // My own test to use a more complicated interface.
//    public static void printNumberOfPersons(
//            String info, List<Person> roster, CheckPerson tester) {
//    	            System.out.println(numOf(info, roster, tester.testMany(roster)));
//        }



    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions

    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 7: Use Lambda Expressions Throughout Your Application

    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }



    // Calculate the number of persons.

    public static void processPersonsAndPrintNumOfPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block,
            String info) {
        int i = 0;
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
                i++;
            }
        }
        System.out.println(info + i);
    }

    // Approach 7, second example

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    // Approach 8: Use Generics More Extensively

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String... args) {

        //Vehicle car = new Car();
        Vehicle boat = new Boat();
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

        // vehicleList.add(car);
        vehicleList.add(boat);

        System.out.println("Start writing all vehicles:");
        System.out.println("----------------------------");

        vehicleList
                .stream()
                .forEach(v -> System.out.println(v));

        System.out.println("First vehicle: " + vehicleList
                .stream()
                .findFirst());

        System.out.println();

        // Here we create a list of persons.
        List<Person> roster = Person.createRoster();

        roster.
                stream().
                forEach(p -> {
                    System.out.print("Person nr " + p.getNumber());
                    System.out.println(" :     " + p);
                });

        System.out.println("Start writing all persons:");
        System.out.println("----------------------------");

        for (Person p : roster) {
            p.printPerson();
        }

        // Total number of persons.
        class HowManyPersons implements HowMany {
            public String numOf(String info, List<Person> roster) {
                return info + roster.size();
            }
        }



        printNumOfPersons("\nNumber of persons: ", roster, new HowManyPersons());

        printNumOfPersons("\nNumber of persons with Lambda: ", roster, (String in, List<Person> p) -> in + p.size());

        // Prints a new line.
        // System.out.println();

        // Approach 1: Create Methods that Search for Persons that Match One
        // Characteristic

        System.out.println();

        System.out.println("Persons older than 20:");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        // Approach 2: Create More Generalized Search Methods

        System.out.println("Persons between the ages of 14 and 30:");
        printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        // Approach 3: Specify Search Criteria Code in a Local Class

        System.out.println("Persons who are eligible for Selective Service:");

        class CheckPersonEligibleForSelectiveService implements CheckPerson {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        }

        printPersons(
                roster, new CheckPersonEligibleForSelectiveService());


        System.out.println();

        // Approach 4: Specify Search Criteria Code in an Anonymous Class

        System.out.println("Persons who are eligible for Selective Service " +
                "(anonymous class):");

        printPersons(
                roster,
                new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25;
                    }
                }
        );

        System.out.println();

        System.out.println("PH1: A new anonymous class just for male");

        printPersons(
                roster,
                new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getGender() == Person.Sex.MALE;
                    }
                }
        );

        System.out.println();
        System.out.println("PH2: A new Lambda Expression just for girls");

        printPersons(
                roster,
                (Person p) -> p.getGender() == Person.Sex.FEMALE
        );


        System.out.println();

        // Approach 5: Specify Search Criteria Code with a Lambda Expression

        System.out.println("Persons who are eligible for Selective Service " +
                "(lambda expression):");

        printPersons(
                roster,
                (Person p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );

        System.out.println();

        // Approach 6: Use Standard Functional Interfaces with Lambda
        // Expressions

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate parameter):");

        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );

        System.out.println();
        System.out.println("PH3: Predicate and just girls.");


        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.FEMALE
        );

        System.out.println();

        // Approach 7: Use Lamba Expressions Throughout Your Application

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate and Consumer parameters):");

        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );

        System.out.println();

        processPersonsAndPrintNumOfPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson(),
                "Number of men between 18 and 25 years old: "
        );

        System.out.println();

        processPersonsAndPrintNumOfPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE,
                p -> p.printPerson(),
                "Number of only men: "
        );

        System.out.println();

        processPersonsAndPrintNumOfPersons(
                roster,
                p -> p.getGender() == Person.Sex.FEMALE,
                p -> p.printPerson(),
                "Number of only women: "
        );


        System.out.println();

        // Approach 7, second example

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate, Function, and Consumer parameters):");

        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        System.out.println();

        System.out.println("Test to print birthdays ");

        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> (p.getName() + " has birthday: " + p.getBirthday().toString()),
                birthday -> System.out.println(birthday)
        );

        System.out.println();
        System.out.println("Test to print birthdays for all males:");

        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE,
                p -> (p.getName() + " has birthday: " + p.getBirthday().toString()),
                birthday -> System.out.println(birthday)
        );

        System.out.println();
        System.out.println("Test to print birthdays for all females:");

        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.FEMALE,
                p -> (p.getName() + " has birthday: " + p.getBirthday().toString()),
                birthday -> System.out.println(birthday)
        );



        // Approach 8: Use Generics More Extensively

//            public static <X, Y> void processElements(
//                    Iterable<X> source,
//                    Predicate<X> tester,
//                    Function<X, Y> mapper,
//                    Consumer<Y> block) {
//                        for (X p : source) {
//                            if (tester.test(p)) {
//                                Y data = mapper.apply(p);
//                                block.accept(data);
//                            }
//                        }
//              upp


        System.out.println("Persons who are eligible for Selective Service " +
                "(generic version):");

        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        System.out.println();

        // Approach 9: Use Bulk Data Operations That Accept Lambda Expressions
        // as Parameters

        System.out.println("Persons who are eligible for Selective Service " +
                "(with bulk data operations):");

        roster
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

        // Print out all
        System.out.println();
        System.out.println("All persons are printout!");
        roster
                .stream()
                .forEach(p -> p.printPerson());

        // Print out all only girls
        System.out.println();
        System.out.println("Only girls!");
        roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.FEMALE)
                .forEach(p -> p.printPerson());

        // Only men
        System.out.println();
        System.out.println("Only men!");
        roster
                .stream()
                .filter(persona -> persona.getGender() == Person.Sex.MALE)
                .forEach(menPerson -> menPerson.printPerson());

        // All men
        System.out.println();
        System.out.println("All true!");
        roster
                .stream()
                .filter(p -> true)
                .forEach(p -> p.printPerson());

        System.out.println();
        System.out.println("All false, no one!");
        roster
                .stream()
                .filter(p -> false)
                .forEach(p -> p.printPerson());

        System.out.println();
        System.out.println("My own experiment with streams:");
        List<String> nameArray = new ArrayList<String>();

        nameArray.add("Patrik");
        nameArray.add("Jonas");
        nameArray.add("Hui");
        nameArray.add("Peter");
        nameArray.add("Johan");
        nameArray.add("Hans");

        nameArray
                .stream()
                .forEach(p -> System.out.println(p));

        System.out.println();
        System.out.println("My second experiment with streams, names beginning with P:");

        nameArray
                .stream()
                .filter(name -> name.substring(0, 1).equals("P"))
                .forEach(name -> System.out.println(name));

        System.out.println();
        System.out.println("My second experiment with streams, names beginning with J:");

        nameArray
                .stream()
                .filter(name -> name.substring(0, 1).equals("J"))
                .forEach(name -> System.out.println(name));

        System.out.println();
        System.out.println("My second experiment with streams, names beginning with H:");

        nameArray
                .stream()
                .filter(name -> name.substring(0, 1).equals("H"))
                .forEach(name -> System.out.println(name));

        System.out.println();
        System.out.println("Names beginning with P are printed:");

        nameArray
                .stream()
                .filter(name -> name.substring(0, 1).equals("P"))
                .forEach(name -> System.out.println(name));

        System.out.println();
        System.out.println("All persons are printed: ");
        roster
                .stream()
                .forEach(p -> System.out.println(p));

    }





}