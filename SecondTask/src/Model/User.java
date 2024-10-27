package Model;

import Interfaces.Identifiable;

public abstract class User implements Identifiable {
    private String role;
    private Long id;

    public User(){
        this.id = IdManeger.generateId();
    }

    @Override
    public void setId(Long id) {
        this.id = IdManeger.generateOrValidateId(id);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void printRole(){
        System.out.println("The user is " + this.role + ".");
    }

    public String getRole(){
        return role;
    }
}
