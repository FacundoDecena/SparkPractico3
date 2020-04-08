package empleado;

import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;
import util.Message;

public class EmpleadoController {
    final static Logger registraLog = LoggerFactory.getLogger(EmpleadoController.class);

    public static Route getEmpleados = (Request request, Response response) -> {

        response.type("Application/json");
        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> res;

        String dedicacion = request.queryParams("dedicacion");
        String codigoString = request.queryParams("codigo");
        boolean director = Boolean.parseBoolean(request.queryParams("director"));

        if (dedicacion == null && codigoString == null && director == false) {
            return Message.BAD_PARAMETERS;

        } else if (dedicacion != null){
            res = dao.getEmpleadosDedicacion(dedicacion);
            if (res.size() == 0 )
                return Message.NULL;
            return new Gson().toJson(res);

        } else if(codigoString != null){
            try{
                int codigo = Integer.parseInt(codigoString);
                res = dao.getEmpleadosDepartamento(codigo);
                if (res.size() == 0 )
                    return Message.NULL;
                return new Gson().toJson(res);
                
            } catch (NumberFormatException e){
                return Message.BAD_PARAMETERS;
            }
        } else {
            res = dao.getEmpleadoDirector();
            if (res.size() == 0 )
                return Message.NULL;
            return new Gson().toJson(res);
        }
        
    };
}