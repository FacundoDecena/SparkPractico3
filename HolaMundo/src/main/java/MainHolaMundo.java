import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

public class MainHolaMundo {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api/insertar", HolaController.insertar);
        get("/api/leer", HolaController.leer);
    }
}