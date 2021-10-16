package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = Util.getConnection();

        UserDaoJDBCImpl dao = new UserDaoJDBCImpl();
        dao.createUsersTable();

        dao.saveUser("Вася", "Петров", (byte) 18);
        dao.saveUser("Иван", "Сидоров", (byte) 25);
        dao.saveUser("Антон", "Серёгин", (byte) 43);
        dao.saveUser("Сергей", "Семёнов", (byte) 15);

        List<User> users = dao.getAllUsers();

        for (User user : users) {
            System.out.println(user.toString());
        }

        dao.cleanUsersTable();
        dao.dropUsersTable();

        Util.closeConnection(conn);
    }
}
