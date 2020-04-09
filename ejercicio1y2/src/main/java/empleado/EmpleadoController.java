package empleado;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import departamento.DepartamentoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import util.Message;
import util.Path;

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

    public static Route getEmpleadosCodigo = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        EmpleadoDAO dao = new EmpleadoDAO();
        int codigo;
        List<Empleado> empleados;
        model.put("template", Path.Template.EMPLEADOS_CODIGO);
        try{
            codigo = Integer.parseInt(request.queryParams("codigo"));
            empleados = dao.getEmpleadosDepartamento(codigo);
            model.put("codigo", codigo);
            model.put("empleados", empleados);
        } catch(NumberFormatException e){
            model.put("codigo", 0);
            model.put("message", "Bad parameters");
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };

    public static Route addEmpleadoView = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        DepartamentoDAO daoD = new DepartamentoDAO();
        model.put("template", Path.Template.EMPLEADO);
        model.put("departamentos", daoD.getDepartamentos());

        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };

    public static Route addEmpleado = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        EmpleadoDAO dao = new EmpleadoDAO();
        String nombre = request.queryParams("nombre");
        String categoria = request.queryParams("categoria");
        String dedicacion = request.queryParams("dedicacion");
        int codigo = Integer.parseInt(request.queryParams("codigo"));
        dao.add(nombre, categoria, dedicacion, codigo);

        DepartamentoDAO daoD = new DepartamentoDAO();
        model.put("departamentos", daoD.getDepartamentos());

        model.put("message", "Empleado añadido");
        model.put("template", Path.Template.EMPLEADO);
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };
}