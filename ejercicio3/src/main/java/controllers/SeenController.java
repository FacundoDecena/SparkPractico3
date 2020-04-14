package controllers;

import dao.SeenDAO;
import spark.Request;
import spark.Response;
import spark.Route;

public class SeenController {

    public static Route add = (Request request, Response response) -> {
       // response.type("Application/json");
        SeenDAO dao = new SeenDAO();
        int id = Integer.parseInt(request.queryParams("id"));
        String title = request.queryParams("titulo");
        dao.add(id, title);
        return "{\"Mensaje\":\"Imagine que esta es la pelicula :)\"}";

    };

}