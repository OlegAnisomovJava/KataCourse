package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Andrey", "Kuznetsov", (byte) 23);
        userDao.saveUser("Arkadii", "Pupkin", (byte) 45);
        userDao.saveUser("Nikita", "Smolnikov", (byte) 32);
        userDao.saveUser("Nikita", "Sebehov", (byte) 45);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
