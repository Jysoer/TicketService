package Model;

import Interfaces.Printable;

public class Client extends User implements Printable {
    private final static String CLIENT_ROLE = "client";

    public Client() {
        super();
    }

    public Client(Long id) {
        super();
    }

    @Override
    public void printRole() {
        System.out.println("The user is " + this.CLIENT_ROLE + ".");
    }

    public void getTicket(Ticket ticket){
        System.out.println("Ticket ID " + ticket.getId());
    }

    public String getRole(){
        return CLIENT_ROLE;
    }

    @Override
    public void print() {
        System.out.println(this.toString());;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "role='" + CLIENT_ROLE + '\'' +
                '}';
    }
}
