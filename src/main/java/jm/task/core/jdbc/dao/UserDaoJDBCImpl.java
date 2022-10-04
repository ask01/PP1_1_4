package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class UserDaoJDBCImpl implements UserDao {
//    Connection connection = Util.getconnection();
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS USERS" +
//                "(id int not null auto_increment," + "name VARCHAR(45)," + "lastname VARCHAR(45)," + "age int," + "PRIMARY KEY (id))";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS USERS";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//            System.out.println("Table drop");
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        //PreparedStatement preparedStatement = null;
//        String sql = "INSERT INTO USERS(NAME, LASTNAME, AGE) VALUES(?, ?, ?)";
//        try (PreparedStatement preparedStatement =  connection.prepareStatement(sql)) {
//           preparedStatement.setString(1, name);
//           preparedStatement.setString(2, lastName);
//           preparedStatement.setInt(3, age);
//           preparedStatement.executeUpdate();
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
//
//
//        } catch (SQLException e){
//             e.printStackTrace();
//        }
//        }
//
//
//
//
//
//    public void removeUserById(long id) {
//
//        String sql = "DELETE FROM USERS WHERE id=?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//            System.out.println("User delete");
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        String sql = "SELECT id, NAME, lastname, age FROM USERS WHERE id IS NOT NULL";
//        try (Statement statement = connection.createStatement()){
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastname"));
//                user.setAge(resultSet.getByte("age"));
//                userList.add(user);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() {
//        //Statement statement = null;
//        String sql = "TRUNCATE USERS";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//            System.out.println("Table clean");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
