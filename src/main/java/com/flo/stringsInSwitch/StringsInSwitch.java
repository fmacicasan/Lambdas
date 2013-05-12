package com.flo.stringsInSwitch;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author Florin Macicasan
 */
public class StringsInSwitch {

    public static final int IONEL_PROVIDED = 8;

    public static void main(String[] args) {
        String month = Month.APRIL.getDisplayName(TextStyle.FULL, Locale.FRANCE);


        switch (month.toLowerCase()){
            case "avril":
                System.out.println("April");
                break;
            case "mai":
                System.out.println("May");
                break;
            case "juin":
                System.out.println("June");
                break;
            default:
                System.out.println("Djangoooo!");
        }

        int correspondingMonth;
        switch (month.hashCode()){
            case 93209792:
                correspondingMonth = 1;
                break;
            case 107861:
                correspondingMonth = 2;
                break;
            case 3273648:
                correspondingMonth = 3;
                break;
            default:
                correspondingMonth = 4;
        }

        switch (correspondingMonth) {
            case 1:
                System.out.println("April");
                break;
            case 2:
                System.out.println("May");
                break;
            case 3:
                System.out.println("June");
                break;
            default:
                System.out.println("Djangoooo!");
        }

        Arrays.asList(Month.values()).stream().map(m -> m.getDisplayName(TextStyle.FULL, Locale.FRANCE)).forEach(System.out::println);
    }
}
