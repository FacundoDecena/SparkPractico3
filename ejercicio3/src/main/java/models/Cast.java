package models;

import lombok.Data;

@Data
public class Cast {
    private String titulo;
    private String nombre;
    private String personaje;

    public Cast(String title, String name, String character){
        this.titulo = title;
        this.nombre = name;
        this.personaje = character;
    }
}