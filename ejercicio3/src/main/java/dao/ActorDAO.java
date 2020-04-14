package dao;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;

public class ActorDAO {

    public List<String>getMoviesFromActor(String directorName){
        String sql = "SELECT DISTINCT NACION FROM ACTOR WHERE NOMBRE IN("+
            "SELECT NOMBRE FROM REPARTO WHERE TITULO IN ("+
            "SELECT TITULO FROM PELICULA WHERE UPPER(NOMBRE) = UPPER(:NOMBRE))) ";
        List<String> res;
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            res = conn.createQuery(sql)
                    .addParameter("NOMBRE", directorName)
                    .executeAndFetch(String.class);
        }
        return res;
    }
}