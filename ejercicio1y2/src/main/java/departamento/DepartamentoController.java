package departamento;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import empleado.Empleado;
import empleado.EmpleadoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import util.Message;
import util.Path;

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

    public static Route getDepartamentoDeEmpleado = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        DepartamentoDAO dao = new DepartamentoDAO();
        String nombre;
        List<Departamento> departamento;
        model.put("template", Path.Template.DEPARTAMENTO_EMPLEADO);

        nombre = request.queryParams("nombre");
        departamento = dao.getDepartamentoDeEmpleado(nombre);
        if (departamento.size() > 0){
            model.put("nombre", nombre);
            model.put("departamento", departamento);
        } else {
            model.put("nombre", "");
            model.put("message", "Bad parameters");
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };

    public static Route getCantidadEmpleados = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        DepartamentoDAO dDao = new DepartamentoDAO();
        EmpleadoDAO eDao = new EmpleadoDAO();

        List<Departamento> departamentos;
        List<Empleado> empleados;
        HashMap<String, Integer> codigoCantidad = new HashMap<>();
        model.put("template", Path.Template.CANTITAD_EMPLEADOS);

        departamentos = dDao.getDepartamentos();

        for (Departamento depto : departamentos){
            empleados = eDao.getEmpleadosDepartamento(depto.getCodigo());
            codigoCantidad.put(depto.getNombre(), empleados.size());
        }

        model.put("codigoCantidad", codigoCantidad);
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };
    public static Route addDepartamentoView = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", Path.Template.DEPARTAMENTO);
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };
    public static Route addDepartamento = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        DepartamentoDAO dao = new DepartamentoDAO();
        String nombre = request.queryParams("nombre");
        String director = request.queryParams("director");
        dao.add(nombre, director);
        model.put("message", "Departamento añadido");
        model.put("template", Path.Template.DEPARTAMENTO);
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };
}