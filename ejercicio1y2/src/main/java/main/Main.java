package main;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import departamento.DepartamentoController;
import empleado.EmpleadoController;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import static spark.debug.DebugScreen.enableDebugScreen;
import util.Path;

public class Main {
   
   public static void main(String[] args) { 

        staticFileLocation("/public");
  
        Logger registraLog = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
        enableDebugScreen();
        
        get(Path.Web.API_GET_DEPARTAMENTOS, DepartamentoController.getDepartamentos); 
        get(Path.Web.GET_DEPARTAMENTO_EMPLEADO, DepartamentoController.getDepartamentoDeEmpleado); 
        get(Path.Web.GET_CANTITAD_EMPLEADOS, DepartamentoController.getCantidadEmpleados); 
        get(Path.Web.POST_DEPARTAMENTO, DepartamentoController.addDepartamentoView);

        get(Path.Web.API_GET_EMPLEADOS, EmpleadoController.getEmpleados); 
        get(Path.Web.GET_EMPLEADOS_CODIGO, EmpleadoController.getEmpleadosCodigo); 
        get(Path.Web.POST_EMPLEADO, EmpleadoController.addEmpleadoView);

        post(Path.Web.POST_DEPARTAMENTO, DepartamentoController.addDepartamento);

        post(Path.Web.POST_EMPLEADO, EmpleadoController.addEmpleado);

    }
}


 
