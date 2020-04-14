package dao;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;
import models.Movie;

public class MovieDAO {

    public List<Movie> getMoviesFromDirector(String directorName){
        String sql = "SELECT * FROM PELICULA WHERE UPPER(NOMBRE) = UPPER(:NOMBRE)";
        List<Movie> res;
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            res = conn.createQuery(sql)
                    .addParameter("NOMBRE", directorName)
                    .executeAndFetch(Movie.class);
        }
        return res;
    }

    public List<Movie> getMoviesFromActor(String actorName){
        String sql = "SELECT * FROM PELICULA WHERE TITULO = (SELECT TITULO FROM REPARTO WHERE UPPER(NOMBRE) = UPPER(:NOMBRE))";
        List<Movie> res;
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            res = conn.createQuery(sql)
                    .addParameter("NOMBRE", actorName)
                    .executeAndFetch(Movie.class);
        }
        return res;
    }

    public List<Movie> getMovies(){
        String sql = "SELECT * FROM PELICULA";
        List<Movie> res;
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            res = conn.createQuery(sql)
                .executeAndFetch(Movie.class);
        }
        return res;
    }

    public List<Movie> getMoviesFromNation(String nation){
        String sql = "SELECT * FROM PELICULA WHERE NACION like :NACION";
        List<Movie> res;
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            res = conn.createQuery(sql)
                .addParameter("NACION", nation)
                .executeAndFetch(Movie.class);
        }
        return res;
    }

}