package departamento;

import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Request;
import spark.Response;
import spark.Route;
import util.Message;

public class DepartamentoController {
    final static Logger registraLog = LoggerFactory.getLogger(DepartamentoController.class);

    public static Route getDepartamentos = (Request request, Response response) -> {

        response.type("Application/json");
        DepartamentoDAO dao = new DepartamentoDAO();
        List<Departamento> res;

        String director = request.queryParams("director");
        boolean deptoConEmpleado = Boolean.parseBoolean(request.queryParams("deptoConEmpleado"));

        if (director == null && deptoConEmpleado == false) {
            res = dao.getDepartamentos();
            if (res.size() == 0)
                return Message.NULL;
            return new Gson().toJson(res);
        } else if (director != null){
            res = dao.getDepartamentoDirector(director);
            if (res.size() == 0)
                return Message.NULL;
            return new Gson().toJson(res);
        } else {
            res = dao.getDepartamentoConEmpleados();
            if (res.size() == 0)
                return Message.NULL;
            return new Gson().toJson(res);
        }
        
    };
}