package dao;

import java.util.List;
import org.sql2o.Connection;

import util.Sql2oDAO;
import models.User;

public class UserDAO {

    public List<User> login(int id){
        String sql = "SELECT * FROM USUARIO WHERE ID = :ID";
        List<User> res;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            res = con.createQuery(sql)
                .addParameter("ID", id)
                .executeAndFetch(User.class);
        }
        return res;
    }
}