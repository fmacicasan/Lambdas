package com.flo.lambdas.sorting;

import java.util.*;
import java.util.function.Function;

/**
 * @author Florin Macicasan
 */
public class RegularUser {

    private static final int DEFAULT_SALARY = 1234_567;

    private String firstName;
    private String lastName;
    private int salary;

    public RegularUser(String firstName, String lastName){
        this(firstName, lastName, DEFAULT_SALARY);
    }

    public RegularUser(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "RegularUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {

        List<RegularUser> regularUsers = getRegularUsers();

        System.out.println("annonymous inner");
        Collections.sort(regularUsers, new Comparator<RegularUser>() {
            @Override
            public int compare(RegularUser o1, RegularUser o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        printCollection(regularUsers);

        System.out.println("lambda experssion (converted to single abstract method - SAM - functional interface)");
        Collections.sort(regularUsers, (RegularUser x, RegularUser y) -> x.getLastName().compareTo(y.getLastName()));
        printCollection(regularUsers);

        System.out.println("type inference");
        Collections.sort(regularUsers, (x, y) -> x.getLastName().compareTo(y.getLastName()));
        printCollection(regularUsers);

        //monolithic comparator: both extracts key and compares the keys
        Comparator<RegularUser> regularUserComparator = (ru1, ru2) -> ru1.getLastName().compareTo(ru2.getLastName());

        regularUserComparator.reverseOrder();
        System.out.println("composing behavior - splitting key extraction and comparison");
        Function<RegularUser, String> regularUserLastNameGetter = p -> p.getLastName();
        Comparator<RegularUser> byLastName = Comparators.comparing(regularUserLastNameGetter);
        Collections.sort(regularUsers, byLastName.reverseOrder());

//        Comparator<RegularUser> byLastName1 = Comparators.comparing(RegularUser::getLastName);
//        Collections.sort(regularUsers, Comparators.comparing(RegularUser::getFirstName));

        printCollection(regularUsers);

        System.out.println("reusability + method reference");
        Function<RegularUser, String> personFirstNameGetter = RegularUser::getFirstName;
        Comparator<RegularUser> byFirstName = Comparators.comparing(personFirstNameGetter);
        Collections.sort(regularUsers, byFirstName.reverseOrder());
        printCollection(regularUsers);


        System.out.println("combining comparators");
        Comparator<RegularUser> byFirstNameAndLastName = byFirstName.thenComparing(byLastName);
        regularUsers.sort(byFirstNameAndLastName);
        printCollection(regularUsers);
    }

    public static List<RegularUser> getRegularUsers() {
        List<RegularUser> regularUsers = new ArrayList<>();
        regularUsers.add(new RegularUser("Germanosu", "Marius"));
        regularUsers.add(new RegularUser("Frigorivescu", "Stelian"));
        regularUsers.add(new RegularUser("Germanosu", "Haribi"));
        return regularUsers;
    }


    public static <E> void printCollection(Collection<E> collection){

         collection.stream().forEach(System.out::println);

    }

}
