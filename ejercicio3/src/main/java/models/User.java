package models;

import lombok.Data;

@Data
public class User {
    private String nombre;
    private int id;

    public User(String username){
        this.nombre = username;
    }
}