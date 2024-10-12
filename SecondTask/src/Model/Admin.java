package Model;


public class Admin extends User{
    private String role = "admin";

    public Admin(){
    }

    @Override
    public void printRole() {
        System.out.println("The user is " + this.role + ".");
    }

    public void checkTicket(Ticket ticket){
        System.out.println("Ticket ID " + Ticket.getIdList() + " is checked.");
    }

    public String getRole(){
        return role;
    }
}
