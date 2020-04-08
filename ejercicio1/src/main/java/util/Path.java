/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import lombok.Getter;


public class Path {

    // Los metodos @Getter son necesarios para acceder desde las variables de Templates de Velocity
    // NO USAR ACCESOS DIRECTOS, SINO SIEMPRE A TRAVÉS DE ESTA CLASE
    public static class Web {
        @Getter public static final String GET_DEPARTAMENTOS = "/api/departamentos";
        @Getter public static final String GET_EMPLEADOS = "/api/empleados";
    }
    
    public static class Template {
        public final static String LAYOUT = "templates/layout.vtl";
     
    }

}
