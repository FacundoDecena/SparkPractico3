package util;

import lombok.Getter;


public class Path {

    public static class Web {
        @Getter public static final String API_GET_DEPARTAMENTOS = "/api/departamentos";
        @Getter public static final String API_GET_EMPLEADOS = "/api/empleados";
        @Getter public static final String GET_EMPLEADOS_CODIGO = "/empleados";
        @Getter public static final String GET_DEPARTAMENTO_EMPLEADO = "/depto";
        @Getter public static final String GET_CANTITAD_EMPLEADOS = "/cant-empleados";
        @Getter public static final String POST_DEPARTAMENTO = "/add-depto";
        @Getter public static final String POST_EMPLEADO = "/add-empleado";
    }
    
    public static class Template {
        public final static String LAYOUT = "templates/layout.vtl";
        public final static String EMPLEADOS_CODIGO = "templates/empleadosCodigo.vtl";
        public final static String DEPARTAMENTO_EMPLEADO = "templates/deptoEmpleado.vtl";
        public final static String CANTITAD_EMPLEADOS = "templates/cantidadEmpleados.vtl";
        public final static String DEPARTAMENTO = "templates/depto.vtl";
        public final static String EMPLEADO = "templates/empleado.vtl";
    }

}
