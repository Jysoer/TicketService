package Interfaces;

import Model.IdGenerator;

public interface Identifiable {
    default Long getId() {
        return IdGenerator.generateId();
    }
}

