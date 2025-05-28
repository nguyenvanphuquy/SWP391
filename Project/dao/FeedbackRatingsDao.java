package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.FeedbackRatings;

public class FeedbackRatingsDao {

    private Connection conn;

    public FeedbackRatingsDao(Connection conn) {
        this.conn = conn;
    }

    public FeedbackRatings getFeedbackById(String feedbackId) throws SQLException {
        String sql = "SELECT * FROM Feedback_Ratings WHERE feedback_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedbackId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new FeedbackRatings(
                    rs.getString("feedback_id"),
                    rs.getString("customer_id"),
                    rs.getString("staff_id"),
                    rs.getInt("rating"),
                    rs.getString("comment"),
                    rs.getTimestamp("created_at")
                );
            }
        }
        return null;
    }

    public boolean insertFeedback(FeedbackRatings feedback) throws SQLException {
        String sql = "INSERT INTO Feedback_Ratings(feedback_id, customer_id, staff_id, rating, comment, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getFeedback_id());
            stmt.setString(2, feedback.getCustomer_id());
            stmt.setString(3, feedback.getStaff_id());
            stmt.setInt(4, feedback.getRating());
            stmt.setString(5, feedback.getComment());
            stmt.setTimestamp(6, feedback.getCreated_at());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateFeedback(FeedbackRatings feedback) throws SQLException {
        String sql = "UPDATE Feedback_Ratings SET customer_id=?, staff_id=?, rating=?, comment=?, created_at=? WHERE feedback_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getCustomer_id());
            stmt.setString(2, feedback.getStaff_id());
            stmt.setInt(3, feedback.getRating());
            stmt.setString(4, feedback.getComment());
            stmt.setTimestamp(5, feedback.getCreated_at());
            stmt.setString(6, feedback.getFeedback_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteFeedback(String feedbackId) throws SQLException {
        String sql = "DELETE FROM Feedback_Ratings WHERE feedback_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedbackId);
            return stmt.executeUpdate() > 0;
        }
    }
}
