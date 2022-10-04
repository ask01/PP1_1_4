package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    private Transaction transaction;


    @Override
    public void createUsersTable() {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            String sql = "CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                    "age TINYINT NOT NULL)";
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        try (Session session = sessionFactory.openSession()) {
        transaction = session.beginTransaction();
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
        } catch (Exception e) {

            }

        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {

        try(Session session = sessionFactory.openSession()){

        transaction = session.beginTransaction();
        session.delete(session.get(User.class, id));
        transaction.commit();
        } catch (Exception e) {

            }

        }


    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            userList = session.createQuery("from User order by name").list();
            session.getTransaction().commit();

        } catch (Exception e) {

        }
        return userList;
    }


    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM users")
                    .executeUpdate();
            transaction.commit();
            System.out.println("Таблица очищена");
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        }
    }
}
