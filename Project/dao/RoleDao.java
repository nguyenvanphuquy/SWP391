package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Role;

public class RoleDao {

    private Connection conn;

    public RoleDao(Connection conn) {
        this.conn = conn;
    }

    public Role getRoleById(int roleId) throws SQLException {
        String sql = "SELECT * FROM Role WHERE role_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Role(rs.getInt("role_id"), rs.getString("role_name"));
            }
        }
        return null;
    }

    public boolean insertRole(Role role) throws SQLException {
        String sql = "INSERT INTO Role(role_name) VALUES(?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, role.getRole_name());
            return stmt.executeUpdate() > 0;
        }
    }
}
