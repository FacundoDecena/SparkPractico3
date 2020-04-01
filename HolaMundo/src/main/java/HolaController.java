import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class HolaController {
    static public Route insertar = (Request request, Response response) ->{
        Hola hola = new Hola();
        response.type("application/json");
        String message = request.queryParams("message");
        hola.setMessage(message);
        hola.insertar();
        return "{\"message\":\"Todo bien\"}";
    };
    static public Route leer = (Request request, Response response) ->{
        response.type("application/json");
        return new Gson().toJson(Hola.buscarMensages());
    };
}
