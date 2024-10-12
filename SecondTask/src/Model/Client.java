package Model;

public class Client extends User{
    private String role = "client";

    public Client(){
    }

    @Override
    public void printRole() {
        System.out.println("The user is " + this.role + ".");
    }

    public void getTicket(Ticket ticket){
        System.out.println("Ticket ID " + Ticket.getIdList());
    }

    public String getRole(){
        return role;
    }
}
