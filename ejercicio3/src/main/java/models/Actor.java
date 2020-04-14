package models;

import lombok.Data;

@Data
public class Actor {
    private String nombre;
    private String nacion;

    public Actor (String name, String nation){
        this.nombre = name;
        this.nacion = nation;
    }
}