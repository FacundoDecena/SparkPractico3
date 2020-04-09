package departamento;

import lombok.Data;

@Data
public class Departamento {
    private int codigo;
    private String nombre;
    private String director;

    public Departamento(int codigo, String nombre, String director){
        this.codigo = codigo;
        this.nombre = nombre;
        this.director = director;
    }

}