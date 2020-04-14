package controllers;

import java.util.List;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

import dao.MovieDAO;
import models.Movie;
import util.Message;

public class MovieController {

    public static Route getMoviesFromDirector = (Request request, Response response) ->{
        response.type("Application/json");
        MovieDAO dao = new MovieDAO();
        List<Movie> res;
        String nombre = request.queryParams("nombre");
        if (nombre == null)
            return Message.BAD_PARAMETERS;
        res = dao.getMoviesFromDirector(nombre);
        if (res.size() == 0)
            return Message.NULL;
            
        return new Gson().toJson(res);
    };

    public static Route getMoviesFromActor = (Request request, Response response) -> {
        response.type("Application/jason");
        MovieDAO dao = new MovieDAO();
        List<Movie> res;
        String nombre = request.queryParams("nombre");
        if (nombre == null)
            return Message.BAD_PARAMETERS;
        res = dao.getMoviesFromActor(nombre);
        if (res.size() == 0)
            return Message.NULL;
        return new Gson().toJson(res);
    };

}