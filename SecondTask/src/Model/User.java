package Model;

public abstract class User {
    private String role;

    public User(){
    }

    public void printRole(){
        System.out.println("The user is " + this.role + ".");
    }

    public String getRole(){
        return role;
    }
}
