package models;

import lombok.Data;

@Data
public class Recorrido {
    private String ciudad_inicial;
    private String ciudad_final;
    private String empresa;
    private double precio;

    public Recorrido(String ciudadInicial, String ciudadFinal, String empresa, double precio){
        this.ciudad_inicial = ciudadInicial;
        this.ciudad_final = ciudadFinal;
        this.empresa = empresa;
        this.precio = precio;
    }
}