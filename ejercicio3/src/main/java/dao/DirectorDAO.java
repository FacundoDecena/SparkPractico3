package dao;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;

public class DirectorDAO {

    public List<String> getDirectors(){
        String sql = "SELECT NOMBRE FROM DIRECTOR";
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            return conn.createQuery(sql)
                    .executeAndFetch(String.class);
        }
    }
}