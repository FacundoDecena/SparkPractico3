package util;

import lombok.Getter;


public class Path {

    public static class Web {
        @Getter public static final String GET_DEPARTAMENTOS = "/api/departamentos";
        @Getter public static final String GET_EMPLEADOS = "/api/empleados";
    }
    
    public static class Template {
        public final static String LAYOUT = "templates/layout.vtl";
     
    }

}
