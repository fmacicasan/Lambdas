package com.flo.lambdas;

/**
 * @author Florin Macicasan
 */
public interface FloFunctionalStyledDefaulted {

    default String writeTheConga(String congaStyle){
        return "writing the default conga " + congaStyle + " style";
    }

}
