package com.flo.lambdas.pushingBehavior;

import com.flo.lambdas.sorting.RegularUser;

import java.util.Iterator;
import java.util.List;

/**
 * @author Florin Macicasan
 */
public class BehaviorPusher {

    public static final String REMOVAL_CRITERION = "S";

    public static void main(String[] args) {

        System.out.println("The old ways");
        List<RegularUser> regularUsers = RegularUser.getRegularUsers();
        RegularUser.printCollection(regularUsers);
        Iterator<RegularUser> iterator = regularUsers.iterator();
        while(iterator.hasNext()){
            RegularUser next = iterator.next();
            if(next.getLastName().startsWith(REMOVAL_CRITERION)){
                iterator.remove();
            }
        }
        System.out.println("Lets see if someone got lucky...");
        RegularUser.printCollection(regularUsers);

        System.out.println("The lambda way...");
        regularUsers = RegularUser.getRegularUsers();
        RegularUser.printCollection(regularUsers);
        //implemented with an anonymous inner class
//        regularUsers.removeIf(new Predicate<RegularUser>() {
//            @Override
//            public boolean test(RegularUser regularUser) {
//                return regularUser.getLastName().startsWith(REMOVAL_CRITERION);
//            }
//        });

        //pushing the removal criterion to the collection
        boolean removed = regularUsers.removeIf(regularUser -> regularUser.getLastName().startsWith(REMOVAL_CRITERION));
        if(removed){
            System.out.println("Someone got removed. Who is the lucky one?");
            RegularUser.printCollection(regularUsers);
        } else {
            System.out.println("Noone matches removal criterion: startsWith -"+REMOVAL_CRITERION);
        }
    }
}
