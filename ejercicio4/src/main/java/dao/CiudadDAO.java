package dao;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;

public class CiudadDAO {
    public List<String>getCities(){
        String sql = "SELECT * FROM CIUDAD";
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            return conn.createQuery(sql)
                    .executeAndFetch(String.class);
        }
    }
}