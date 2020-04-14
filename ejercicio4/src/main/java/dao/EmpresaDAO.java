package dao;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;

public class EmpresaDAO {
    public List<String>getEmpresas(String origen, String destino){
        String sql = "SELECT * FROM EMPRESA WHERE NOMBRE IN (SELECT EMPRESA FROM RECORRIDO WHERE CIUDAD_INICIAL = :ORIGEN AND CIUDAD_FINAL = :DESTINO)";
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            return conn.createQuery(sql)
                    .addParameter("ORIGEN", origen)
                    .addParameter("DESTINO", destino)
                    .executeAndFetch(String.class);
        }
    }
}