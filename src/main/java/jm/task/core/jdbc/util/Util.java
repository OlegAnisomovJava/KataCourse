package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String JDBC_USERNAME = "admin";
    private static final String JDBC_PASSWORD = "admin";


    public static Connection getConnection() {
        Connection connection = null;
        try {
//            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME,JDBC_PASSWORD);
//            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected to error");
        }
        return connection;
    }
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Конфигурация Hibernate без использования XML
            Configuration configuration = new Configuration();

            // Устанавливаем настройки для Hibernate
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // или другой диалект
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver"); // класс драйвера для базы данных
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydbtest?useSSL=false"); // URL подключения к БД
            configuration.setProperty("hibernate.connection.username", "admin"); // имя пользователя
            configuration.setProperty("hibernate.connection.password", "admin"); // пароль (если есть)

            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.current_session_context_class", "thread");// Стратегия обновления схемы

            // Указываем сущности, которые Hibernate должен обрабатывать
            configuration.addAnnotatedClass(User.class); // Укажите ваши модели


            // Строим SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Логируем исключение
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
