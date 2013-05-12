package com.flo.lambdas.streams;

import com.flo.lambdas.sorting.RegularUser;

import java.util.List;
import java.util.Objects;

/**
 * @author Florin Macicasan
 */
public class Streamer {

    public static final int SALARY_TRESHOLD = 123;

    public static void main(String[] args) {

        List<RegularUser> regularUsers = RegularUser.getRegularUsers();

        regularUsers.stream()
                .filter(ru -> ru.getSalary() > SALARY_TRESHOLD)
                .map(ru -> ru.getLastName() + " " + ru.getFirstName())
                .forEach(System.out::println);

        regularUsers.parallelStream()
                .filter(ru -> ru.getSalary() > SALARY_TRESHOLD)
                .map(ru -> ru.getLastName() + " " + ru.getFirstName())
                .count();

    }
}
