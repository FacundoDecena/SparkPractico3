package main;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import departamento.DepartamentoController;
import empleado.EmpleadoController;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.debug.DebugScreen.enableDebugScreen;
import util.Path;

public class Main {
   
   public static void main(String[] args) { 
  
        Logger registraLog = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
        enableDebugScreen();
        
        get(Path.Web.GET_DEPARTAMENTOS, DepartamentoController.getDepartamentos); 
        get(Path.Web.GET_EMPLEADOS, EmpleadoController.getEmpleados); 

        post(Path.Web.getGET_DEPARTAMENTOS(), null );   

    }
}


 
