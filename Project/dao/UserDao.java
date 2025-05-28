package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.User;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public User getUserById(String userId) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getString("user_id"),
                    rs.getString("full_name"),
                    rs.getString("gender"),
                    rs.getDate("date_of_birth"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getInt("role_id")
                );
            }
        }
        return null;
    }

    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO [User](user_id, full_name, gender, date_of_birth, phone, email, address, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getFull_name());
            stmt.setString(3, user.getGender());
            stmt.setDate(4, user.getDate_of_birth());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getAddress());
            stmt.setInt(8, user.getRole_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE [User] SET full_name=?, gender=?, date_of_birth=?, phone=?, email=?, address=?, role_id=? WHERE user_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFull_name());
            stmt.setString(2, user.getGender());
            stmt.setDate(3, user.getDate_of_birth());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getAddress());
            stmt.setInt(7, user.getRole_id());
            stmt.setString(8, user.getUserId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteUser(String userId) throws SQLException {
        String sql = "DELETE FROM [User] WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            return stmt.executeUpdate() > 0;
        }
    }
}
