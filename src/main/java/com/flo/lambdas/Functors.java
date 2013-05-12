package com.flo.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author Florin Macicasan
 */
public class Functors {

    public static final int MAX_NUM = 20;

    // needs to be static or an instance variable to break the assignment-before-use rule
    static UnaryOperator<Long> factorial = i -> i == 1 ? i : i * factorial.apply(i - 1);

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i< MAX_NUM;i++){
            numbers.add(i);
        }

        System.out.println("Even numbers:");
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        System.out.println("Printing all elements of a collection");
        numbers.stream().forEach(System.out::println);

        System.out.println("Printing all elements of a collection - the parallel way");
        numbers.parallelStream().forEach(System.out::println);

        Integer reducedSum = numbers.stream().filter(x -> x.hashCode() < 10).reduce(0, (x, y) -> x + y);
        System.out.println("reduced sum:"+reducedSum);
        numbers.stream().filter(x -> x.hashCode() < 10).reduce(0, Integer::sum);

        boolean doAllMatch = numbers.stream().allMatch(x -> x < MAX_NUM);
        System.out.println("do all match?" + doAllMatch);


        System.out.println("Factorial 15:" + factorial.apply(15L));

//        numbers.spliterator().trySplit().forEachRemaining(System.out::println);
//        numbers.spliterator().tryAdvance(x -> {});
//        System.out.println("2nd try split"+numbers.spliterator().estimateSize());
//        numbers.spliterator().trySplit().forEachRemaining(System.out::println);

    }

}
