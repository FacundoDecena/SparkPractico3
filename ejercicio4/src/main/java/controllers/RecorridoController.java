package controllers;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import dao.CiudadDAO;
import dao.EmpresaDAO;
import dao.RecorridoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import util.Message;
import util.Path;
import models.Recorrido;

public class RecorridoController {
    public static Route getCiudades = (Request request, Response response) ->{
        response.type("Application/json");
        CiudadDAO dao = new CiudadDAO();
        return new Gson().toJson(dao.getCities());
    };

    public static Route getEmpresas = (Request request, Response response) ->{
        response.type("Application/json");
        EmpresaDAO dao = new EmpresaDAO();
        String origen = request.queryParams("origen");
        String destino = request.queryParams("destino");
        return new Gson().toJson(dao.getEmpresas(origen, destino));
    };

    public static Route getEmpresayPrecio = (Request request, Response response) ->{
        response.type("Application/json");
        RecorridoDAO dao = new RecorridoDAO();
        String origen = request.queryParams("origen");
        String destino = request.queryParams("destino");
        return new Gson().toJson(dao.getEmpresayPrecio(origen, destino));
    };

    public static Route home = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        CiudadDAO ciudadDao = new CiudadDAO();
        RecorridoDAO recorridoDao = new RecorridoDAO();

        model.put("ciudades", ciudadDao.getCities());
        model.put("template", Path.Template.HOME);
        String origen = request.queryParams("origen");
        String destino = request.queryParams("destino");  

        if(origen != null && destino != null){
            model.put("origen",origen);
            model.put("destino",destino);
            model.put("recorridos",recorridoDao.getEmpresayPrecio(origen, destino));
        }

        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };

    public static Route confirmar = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        RecorridoDAO recorridoDao = new RecorridoDAO();
        model.put("template", Path.Template.CONFIRMAR);

        String origen = request.queryParams("origen");
        String destino = request.queryParams("destino");
        String empresa = request.queryParams("empresa");

        if(origen != null && destino != null && empresa != null){
            List<Double> p = recorridoDao.getPrecio(origen, destino, empresa);
            model.put("precio", recorridoDao.getPrecio(origen, destino, empresa));
            model.put("origen",origen);
            model.put("destino",destino);
            model.put("empresa",empresa);
        }

        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };
}