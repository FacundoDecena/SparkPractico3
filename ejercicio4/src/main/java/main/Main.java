package main;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controllers.*;

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
        
        get(Path.Web.getAPI_CIUDADES(), RecorridoController.getCiudades);
        get(Path.Web.getAPI_EMPRESAS(), RecorridoController.getEmpresas);
        get(Path.Web.getAPI_PRECIO(), RecorridoController.getEmpresayPrecio);
        get(Path.Web.getHOME(), RecorridoController.home);

        get(Path.Web.getCONFIRMAR(), RecorridoController.confirmar);

    }
}
