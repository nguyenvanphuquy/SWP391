package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Notification;

public class NotificationDao {

    private Connection conn;

    public NotificationDao(Connection conn) {
        this.conn = conn;
    }

    public Notification getNotificationById(String notificationId) throws SQLException {
        String sql = "SELECT * FROM Notification WHERE notification_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, notificationId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Notification(
                    rs.getString("notification_id"),
                    rs.getString("progress_id"),
                    rs.getString("content"),
                    rs.getTimestamp("sent_at"),
                    rs.getBoolean("is_read")
                );
            }
        }
        return null;
    }

    public boolean insertNotification(Notification noti) throws SQLException {
        String sql = "INSERT INTO Notification(notification_id, progress_id, content, sent_at, is_read) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, noti.getNotification_id());
            stmt.setString(2, noti.getProgress_id());
            stmt.setString(3, noti.getContent());
            stmt.setTimestamp(4, noti.getSent_at());
            stmt.setBoolean(5, noti.isIs_read());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateNotification(Notification noti) throws SQLException {
        String sql = "UPDATE Notification SET progress_id=?, content=?, sent_at=?, is_read=? WHERE notification_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, noti.getProgress_id());
            stmt.setString(2, noti.getContent());
            stmt.setTimestamp(3, noti.getSent_at());
            stmt.setBoolean(4, noti.isIs_read());
            stmt.setString(5, noti.getNotification_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteNotification(String notificationId) throws SQLException {
        String sql = "DELETE FROM Notification WHERE notification_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, notificationId);
            return stmt.executeUpdate() > 0;
        }
    }
}
