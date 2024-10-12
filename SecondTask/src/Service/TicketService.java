package Service;

import Enums.StadiumSector;
import Model.Admin;
import Model.Client;
import Model.Ticket;

import java.time.LocalDateTime;

public class TicketService {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket(1L, "Bohemy", 123, LocalDateTime.now(), true, StadiumSector.A, 32);
        System.out.println("Creation of ticket №1 took " + ticket1.getDuration() + " ms. Price: " + ticket1.getTicketPrice() + ".");
        ticket1.shared("+48 888 88 88");
        Ticket ticket2 = new Ticket("Bohemy", 123, LocalDateTime.now());
        ticket1.shared("+48 888 88 88", "poppy@gmail.com");
        System.out.println("Creation of ticket №2 took " + ticket2.getDuration() + " ms. Price: " + ticket2.getTicketPrice() + ".");
        Ticket ticket3 = new Ticket();
        System.out.println("Creation of ticket №3 took " + ticket3.getDuration() + " ms. Price: " + ticket3.getTicketPrice() + ".");

        Client adam = new Client();
        Admin nick = new Admin();

        adam.printRole();
        adam.getTicket(ticket1);

        nick.printRole();
        nick.checkTicket(ticket1);
    }
}
