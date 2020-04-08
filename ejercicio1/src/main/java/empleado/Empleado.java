package empleado;

import lombok.Data;

@Data
public class Empleado {

    private String nombre;
    private String categoria;
    private String dedicacion;
    private int codigo;

    public Empleado (String nombre, String categoria, String dedicacion, int codigo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.dedicacion = dedicacion;
        this.codigo = codigo;
    }
}