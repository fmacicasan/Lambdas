package com.flo.lambdas;

import java.util.function.BinaryOperator;

/**
 * @author Florin Macicasan
 */
public class FunctionalInterfaces {

    public static void main (String[] args){

        FloFunctional floFunctional = () -> "i'm doing the conga";
        System.out.println(floFunctional.writeTheConga());

        FloFunctionalStyled floFunctionalNew = x -> "i'm doing the conga " + x + " style";
        System.out.println(floFunctionalNew.writeTheConga("harlem shake"));

        FloFunctionalStyledDefaulted floFunctionalStyledDefaulted = new FloFunctionalStyledDefaulted() {};
        System.out.println(floFunctionalStyledDefaulted.writeTheConga("bumbucia"));

        BinaryOperator<Integer> adder = (x,y) -> x + y;
        System.out.println(adder.apply(10, 15));
    }



}
