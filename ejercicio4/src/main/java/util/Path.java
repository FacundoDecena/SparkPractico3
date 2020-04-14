package util;

import lombok.Getter;


public class Path {

    public static class Web {
        @Getter public static final String API = "/api/";
        @Getter public static final String API_CIUDADES = API + "ciudades";
        @Getter public static final String API_EMPRESAS = API + "empresas";
        @Getter public static final String API_PRECIO = API + "precio";
        @Getter public static final String HOME ="home";
        @Getter public static final String CONFIRMAR ="confirmar";
    }
    
    public static class Template {
        public final static String LAYOUT = "templates/layout.vtl";
        public final static String HOME = "templates/home.vtl";
        public final static String CONFIRMAR = "templates/confirmar.vtl";
    }

}
