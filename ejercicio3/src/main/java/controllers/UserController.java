package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;
import dao.MovieDAO;
import dao.SeenDAO;
import dao.UserDAO;
import models.Movie;
import models.User;
import util.Path;

public class UserController {
    public static Route getLogin = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("message", "primer Visita");
        model.put("template", Path.Template.LOGIN);     
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };

    public static Route postLogin = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        List<User> users;
        List<String> directors;
        List<Movie> movies = new ArrayList<>();
        UserDAO dao = new UserDAO();
        MovieDAO movieDao = new MovieDAO();

        String stringId = request.queryParams("id");
        if (stringId != null){
                int id = Integer.parseInt(stringId);
                users = dao.login(id);
                model.put("users", users);
                model.put("movies", movieDao.getMovies());
                directors = new SeenDAO().view(id);
                for (String director : directors) {
                    movies.addAll(movieDao.getMoviesFromDirector(director));
                }
                model.put("recommendeds", movies);
        } else {
            model.put("message", "Error");
        }
        model.put("template", Path.Template.HOME);
        return new VelocityTemplateEngine().render(new ModelAndView(model, Path.Template.LAYOUT));
    };
}