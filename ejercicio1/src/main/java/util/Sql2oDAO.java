package util;

import org.sql2o.Sql2o;
import main.Main;

public class Sql2oDAO {
    protected static Sql2o sql2o;

    public static Sql2o getSql2o() {
        if (sql2o == null) {
            String path = Main.class.getResource("/DB/empresa.db").getPath();
            String DataSource = "jdbc:sqlite:"+path;
            sql2o = new Sql2o(DataSource,null,null);
        }
        return sql2o;
    }
}