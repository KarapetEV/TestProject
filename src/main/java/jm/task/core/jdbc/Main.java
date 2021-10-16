package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = Util.getConnection();

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Вася", "Петров", (byte) 18);
        userService.saveUser("Иван", "Сидоров", (byte) 25);
        userService.saveUser("Антон", "Серёгин", (byte) 43);
        userService.saveUser("Сергей", "Семёнов", (byte) 15);

        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.closeConnection(conn);
    }
}
