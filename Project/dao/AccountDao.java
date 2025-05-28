package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Account;

public class AccountDao {
     private Connection conn;

    public AccountDao(Connection conn) {
        this.conn = conn;
    }

    public Account getAccountByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM Account WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Account(
                    rs.getString("account_id"),
                    rs.getString("user_id"),
                    rs.getString("username"),
                    rs.getString("password_hash"),
                    rs.getTimestamp("created_at"),
                    rs.getBoolean("is_active")
                );
            }
        }
        return null;
    }

    public boolean insertAccount(Account account) throws SQLException {
        String sql = "INSERT INTO Account(account_id, user_id, username, password_hash) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getAccount_id());
            stmt.setString(2, account.getUser_id());
            stmt.setString(3, account.getUsername());
            stmt.setString(4, account.getPassword_hash());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deactivateAccount(String accountId) throws SQLException {
        String sql = "UPDATE Account SET is_active = 0 WHERE account_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, accountId);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updatePassword(String accountId, String newHash) throws SQLException {
        String sql = "UPDATE Account SET password_hash = ? WHERE account_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newHash);
            stmt.setString(2, accountId);
            return stmt.executeUpdate() > 0;
        }
    }
}
