package org.example;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    private static final String GET_BY_ID_QUERY = "SELECT * FROM STAFF U WHERE U.id = ?;";
    private static final String INSERT_STAFF_QUERY = "INSERT INTO STAFF(LAST_NAME, FIRST_NAME, SURNAME, POST, SALARY, DEPARTMENT_ID) VALUES(?,?,?,?,?,?);";
    private static final String UPDATE_STAFF = "UPDATE STAFF SET last_name = ?, first_name = ?, surname = ?, post = ?, salary = ?, department_id = ? WHERE id = ?;";
    private static final String DELETE_STAFF = "DELETE FROM STAFF WHERE id = ?;";
    private static final String ADD_DEPARTMENT = "INSERT INTO DEPARTMENT(NAME) VALUES (?)";

    @Override
    public User getById(int id) {
        try (Connection connection = DbConnector.getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(GET_BY_ID_QUERY);
            selectStatement.setInt(1, id);
            ResultSet result = selectStatement.executeQuery();
            result.next();

            User user = new User();
            user.setLast_name(result.getString("last_name"));
            user.setFirst_name(result.getString("first_name"));
            user.setSurname(result.getString("surname"));
            user.setPost(result.getString("post"));
            user.setSalary(result.getInt("salary"));
            user.setDepartmentId(result.getInt("department_id"));

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(User user) {
        try (Connection connection = DbConnector.getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement(INSERT_STAFF_QUERY);
            insertStatement.setString(1, user.getLast_name());
            insertStatement.setString(2, user.getFirst_name());
            insertStatement.setString(3, user.getSurname());
            insertStatement.setString(4, user.getPost());
            insertStatement.setInt(5, user.getSalary());
            insertStatement.setInt(6, user.getDepartmentId());
            insertStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, String last_name, String first_name, String surname, String post, int salary, int department_id) {
        try (Connection connection = DbConnector.getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement(UPDATE_STAFF);
            insertStatement.setString(1, last_name);
            insertStatement.setString(2, first_name);
            insertStatement.setString(3, surname);
            insertStatement.setString(4, post);
            insertStatement.setInt(5, salary);
            insertStatement.setInt(6, department_id);
            insertStatement.setInt(7, id);
            insertStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DbConnector.getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement(DELETE_STAFF);
            insertStatement.setInt(1, id);
            insertStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add_department(String name) {
        try (Connection connection = DbConnector.getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement(ADD_DEPARTMENT);
            insertStatement.setString(1, name);
            insertStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}