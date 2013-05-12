package com.flo.lambdas;

import java.util.concurrent.Executors;

/**
 * @author Florin Macicasan
 */
public class FirstLambdas {

    public static void main(String[] args) {
        Thread t = new Thread(() -> { System.out.println("Hello world "+ Thread.currentThread().getName()); });
        t.start();

        Runnable r = () -> { System.out.println("I'm your father! "+ Thread.currentThread().getName()); };
        Executors.newSingleThreadExecutor().submit(r);
    }
}
