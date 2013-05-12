package com.flo.lambdas.internalVsExternal;

import com.flo.lambdas.sorting.RegularUser;

import java.util.List;

import static com.flo.stringsInSwitch.StringsInSwitch.*;

/**
 * @author Florin Macicasan
 */
public class HappyDays {

    public static void makeEmployeesHappierImperative(List<RegularUser> regularUsers){
        for(RegularUser regularUser : regularUsers){
            regularUser.setSalary(regularUser.getSalary() * IONEL_PROVIDED);
        }
    }

    public static void makeEmployeesHappierFunctional(List<RegularUser> regularUsers){
        regularUsers.stream().forEach(ru -> ru.setSalary(ru.getSalary() * IONEL_PROVIDED<<3));
    }


    public static void main(String[] args) {

        System.out.println("Imperative Happy Mode");
        List<RegularUser> regularUsers = RegularUser.getRegularUsers();
        RegularUser.printCollection(regularUsers);
        makeEmployeesHappierImperative(regularUsers);
        RegularUser.printCollection(regularUsers);

        System.out.println("Functional Happy Mode!");
        regularUsers = RegularUser.getRegularUsers();
        RegularUser.printCollection(regularUsers);
        makeEmployeesHappierFunctional(regularUsers);
        RegularUser.printCollection(regularUsers);
    }

}
