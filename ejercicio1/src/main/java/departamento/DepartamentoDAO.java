package departamento;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;

public class DepartamentoDAO {

    /**
     * get Departamentos 
     * @return all the <Deparatamentos> from the BD
     */
    public List<Departamento> getDepartamentos(){
        String sql = "Select * from DEPTO";
        List<Departamento> res;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            res = con.createQuery(sql).executeAndFetch(Departamento.class);
        }
        return res;
    }

    /**
     * getDepartamentoDirector
     * @param director del departamento
     * @return Departamentos que dirije el director
     */
    public List<Departamento> getDepartamentoDirector(String director){
        String sql = "Select * from DEPTO WHERE UPPER(DIRECTOR) LIKE UPPER(:DIRECTOR)";
        List<Departamento> res;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            res = con.createQuery(sql)
                        .addParameter("DIRECTOR", director)
                        .executeAndFetch(Departamento.class);
        }
        return res;
    }

    public List<Departamento> getDepartamentoConEmpleados(){
        String sql = "SELECT * FROM DEPTO WHERE CODIGO IN (SELECT CODIGO FROM EMPLEADO)";
        List<Departamento> res;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            res = con.createQuery(sql)
                        .executeAndFetch(Departamento.class);
        }
        return res;
    }
}