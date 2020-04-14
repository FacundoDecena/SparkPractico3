package dao;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;

public class SeenDAO {

    public List<String> view(int id){
        String sql = "SELECT NOMBRE FROM DIRECTOR WHERE NOMBRE IN ("+
            "SELECT NOMBRE FROM PELICULA WHERE TITULO IN ("+
            "SELECT TITULO FROM VISTAS WHERE ID = :ID))";
        try(Connection con = Sql2oDAO.getSql2o().open()){
            return con.createQuery(sql)
                .addParameter("ID", id)
                .executeAndFetch(String.class);
        }

    }

    public void add(int id, String title){
        String sql = "INSERT INTO VISTAS VALUES (:ID, :TITULO)";
        try(Connection con = Sql2oDAO.getSql2o().open()){
            con.createQuery(sql)
                .addParameter("ID", id)
                .addParameter("TITULO", title)
                .executeUpdate();
        }
        return;
    }

}