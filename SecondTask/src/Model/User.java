package Model;

import Interfaces.Identifiable;

public abstract class User implements Identifiable {
    private String role;
    private Long id;

    public User(){
        this.id = IdGenerator.generateId();
    }

    public void printRole(){
        System.out.println("The user is " + this.role + ".");
    }

    public String getRole(){
        return role;
    }
}
