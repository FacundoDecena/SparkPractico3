package empleado;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;

public class EmpleadoDAO {

    /**
     * getEmpleadosDedicacion 
     * @param dedicacion tipo de jornada
     * @return retorna una lista de empleados con <dedicacion>
     */
    public List<Empleado> getEmpleadosDedicacion(String dedicacion){
        String sql = "Select * from EMPLEADO WHERE UPPER(DEDICACION) LIKE UPPER(:DEDICACION)";
        List<Empleado> res;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            res = con.createQuery(sql)
                    .addParameter("DEDICACION", dedicacion)
                    .executeAndFetch(Empleado.class);
        }
        return res;
    }

    public List<Empleado> getEmpleadosDepartamento(int codigo){
        String sql = "SELECT * FROM EMPLEADO WHERE CODIGO = (:CODIGO)";
        List<Empleado> res;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            res = con.createQuery(sql)
                    .addParameter("CODIGO", codigo)
                    .executeAndFetch(Empleado.class);
        }
        return res;
    }
    
    public List<Empleado> getEmpleadoDirector(){
        String sql = "SELECT * FROM EMPLEADO WHERE NOMBRE LIKE (SELECT DIRECTOR FROM DEPTO)";
        List<Empleado> res;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            res = con.createQuery(sql)
                    .executeAndFetch(Empleado.class);
        }
        return res;
    }

    public void add(String nombre, String categoria, String dedicacion, int codigo){
        String sql = "INSERT INTO EMPLEADO (NOMBRE, CATEGORIA, DEDICACION, CODIGO) VALUES (:NOMBRE, :CATEGORIA, :DEDICACION, :CODIGO)";
        try(Connection con = Sql2oDAO.getSql2o().open()){
            con.createQuery(sql)
                .addParameter("NOMBRE", nombre)
                .addParameter("CATEGORIA", categoria)
                .addParameter("DEDICACION", dedicacion)
                .addParameter("CODIGO", codigo)
                .executeUpdate();
        }
        return;
    }
}