package Interfaces;

import Model.Ticket;

public interface Sharable {
    default void shared(String phoneNumber){
        System.out.println("Ticket ID" +  /*place for ID */  " shared on " + phoneNumber + "");
    }

    default void shared(String phoneNumber, String email){
        System.out.println("Ticket ID" + /*place for ID */  " shared on " + phoneNumber + " and email " + email + "");
    }
}
