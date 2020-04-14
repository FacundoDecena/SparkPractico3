package models;

import lombok.Data;

@Data
public class Seen {
    private String titulo;
    private int id;

    public Seen(int id, String title){
        this.id = id;
        this.titulo = title;
    }
}