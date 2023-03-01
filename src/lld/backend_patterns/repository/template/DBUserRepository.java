package lld.backend_patterns.repository.template;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBUserRepository implements Repository<User> {
    Connection connection;
    public DBUserRepository(Connection connection) throws SQLException {
        this.connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","username","password");
    }
    @Override
    public void add(User entity) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, name) VALUES (?, ?)");
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, UUID.randomUUID().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(User entity) throws SQLException {
        try {
            PreparedStatement statement=connection.prepareStatement("DELETE FROM users WHERE id=?");
            statement.setString(1, entity.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User update(String id, User entity) {
        //<editor-fold desc="Description">
        try {
            PreparedStatement statement=connection.prepareStatement("UPDATE users SET name = ? WHERE id = ?");
            statement.setString(1, entity.getName());
            statement.setString(2, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //</editor-fold>
        return null;
    }

    @Override
    public User getById(String id) {
        User user=null;
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT name FROM users WHERE id = ?");
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                 user = new User(id, result.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT id, name FROM users");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                User user = new User(result.getString("id"), result.getString("name"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
