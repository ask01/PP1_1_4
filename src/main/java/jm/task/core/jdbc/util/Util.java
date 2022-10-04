package jm.task.core.jdbc.util;



import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Util {
    // реализуйте настройку соеденения с БД
//    public static Connection getconnection() {
//        Connection connection = null;
//
//
//        try {
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
//        } catch (SQLException e) {
//            System.err.println("Ошибка подключения");
//        }
//        return connection;
//    }

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();
                configuration.setProperty("connection.driver_class", DRIVER)
                        .setProperty("hibernate.connection.url", URL)
                        .setProperty("hibernate.connection.username", USERNAME)
                        .setProperty("hibernate.connection.password", PASSWORD)
                        .setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect")
                        .setProperty("hibernate.show_sql","true")
                        .addAnnotatedClass(jm.task.core.jdbc.model.User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Problem creating session factory");
                e.printStackTrace();
            }
            if(sessionFactory != null){
                System.out.println("Session factory - OK");
            }
        }

        return sessionFactory;
    }
}







