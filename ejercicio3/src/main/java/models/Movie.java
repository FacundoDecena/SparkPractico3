package models;

import lombok.Data;

@Data
public class Movie {
    private String titulo;
    private String ano;
    private String nacion;
    private String idioma;
    private boolean color;
    private String resumen;
    private String nombre;

    public Movie (String title, String year, String nation, String languaje, boolean colored,
     String resume, String name){
        this.titulo = title;
        this.ano = year;
        this.nacion = nation;
        this.idioma = languaje;
        this.color = colored;
        this.resumen = resume;
        this.nombre = name;
    }

}