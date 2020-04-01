import lombok.Data;
import org.sql2o.Connection;

import java.util.List;

@Data
public class Hola {
    private String message;

    public static List<Hola> buscarMensages() {
        String sql = "Select * from hola;";
        List<Hola> res;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res =
                    con.createQuery(sql).executeAndFetch(Hola.class);
        }
        return res;
    }

    public void insertar() {
        String sql = "INSERT INTO hola VALUES(:message)";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(sql)
                    .addParameter("message" , getMessage())
                    .executeUpdate();
        }
    }
}
