package models;

import lombok.Data;

@Data
public class Director {
    private String nombre;
    private String nacion;
    private String fecnac;

    public Director(String name, String nation, String bday){
        this.nombre = name;
        this.nacion = nation;
        this.fecnac = bday;
    }
}