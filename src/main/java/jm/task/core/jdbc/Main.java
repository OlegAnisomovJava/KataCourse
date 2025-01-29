package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import jm.task.core.jdbc.dao.UserDao;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
//        Util.getConnection();
        UserDao userDao = new UserDaoHibernateImpl();
//
        userDao.createUsersTable();
//
        userDao.saveUser("Andrey", "Kuznetsov", (byte) 23);
        userDao.saveUser("Arkadii", "Pupkin", (byte) 45);
        userDao.saveUser("Nikita", "Smolnikov", (byte) 32);
        userDao.saveUser("Nikita", "Sebehov", (byte) 45);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
//        SessionFactory sessionFactory = Util.getSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            // Создаем транзакцию
//            Transaction transaction = session.beginTransaction();
//
//
//            transaction.commit();
//
//            System.out.println("Пользователь успешно сохранен в базу данных!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
