package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Вася", "Петров", (byte) 18);
        userService.saveUser("Иван", "Сидоров", (byte) 25);
        userService.saveUser("Антон", "Серёгин", (byte) 43);
        userService.saveUser("Сергей", "Семёнов", (byte) 15);

        System.out.println(userService.getAllUsers().toString());

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
