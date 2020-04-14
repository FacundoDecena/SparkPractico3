package dao;

import java.util.List;
import org.sql2o.Connection;

import models.Recorrido;
import util.Sql2oDAO;
public class RecorridoDAO {
    public List<Recorrido>getEmpresayPrecio(String origen, String destino){
        String sql = "SELECT * FROM RECORRIDO WHERE CIUDAD_INICIAL = :ORIGEN AND CIUDAD_FINAL = :DESTINO";
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            return conn.createQuery(sql)
                    .addParameter("ORIGEN", origen)
                    .addParameter("DESTINO", destino)
                    .executeAndFetch(Recorrido.class);
        }
    }

    public List<Double> getPrecio(String origen, String destino, String empresa){
        String sql = "SELECT PRECIO FROM RECORRIDO WHERE CIUDAD_INICIAL = (:ORIGEN) AND CIUDAD_FINAL = (:DESTINO) AND EMPRESA = (:EMPRESA)";
        try(Connection conn = Sql2oDAO.getSql2o().open()){
            return conn.createQuery(sql)
                    .addParameter("ORIGEN", origen)
                    .addParameter("DESTINO", destino)
                    .addParameter("EMPRESA", empresa)
                    .executeAndFetch(Double.class);
        }
    }
    
}

