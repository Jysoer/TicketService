package Model;


import Interfaces.Printable;

public class Admin extends User implements Printable {
    private final static String ADMIN_ROLE = "admin";

    public Admin(){
    }

    @Override
    public void printRole() {
        System.out.println("The user is " + ADMIN_ROLE + ".");
    }

    public String getRole(){
        return ADMIN_ROLE;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "role='" + ADMIN_ROLE + '\'' +
                '}';
    }

    public void checkTicket(Ticket ticket){
        System.out.println("Ticket ID " + ticket.getId() + " is checked.");
    }

    @Override
    public void print() {
        System.out.println(this.toString());;
    }

}
