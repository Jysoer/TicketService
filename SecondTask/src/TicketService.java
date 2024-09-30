import java.util.Date;

public class TicketService {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("1", "Bohemy", 123, 111111, true, 'A', 32);
        System.out.println("Creation of ticket №1 took " + ticket1.duration + " ms. Price: " + ticket1.getTicketPrice() + ".");
        Ticket ticket2 = new Ticket("Bohemy", 123, 111111);
        System.out.println("Creation of ticket №2 took " + ticket2.duration + " ms. Price: " + ticket2.getTicketPrice() + ".");
        Ticket ticket3 = new Ticket();
        System.out.println("Creation of ticket №3 took " + ticket3.duration + " ms. Price: " + ticket3.getTicketPrice() + ".");
    }
}
