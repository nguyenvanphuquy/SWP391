package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.TreatmentProgress;

public class TreatmentProgressDao {
   
    private Connection conn;

    public TreatmentProgressDao(Connection conn) {
        this.conn = conn;
    }

    public TreatmentProgress getProgressById(String progressId) throws SQLException {
        String sql = "SELECT * FROM Treatment_Progress WHERE progress_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, progressId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TreatmentProgress(
                    rs.getString("progress_id"),
                    rs.getString("schedule_id"),
                    rs.getTimestamp("progress_date"),
                    rs.getString("activity"),
                    rs.getString("doctor_note"),
                    rs.getString("status")
                );
            }
        }
        return null;
    }

    public boolean insertProgress(TreatmentProgress progress) throws SQLException {
        String sql = "INSERT INTO Treatment_Progress(progress_id, schedule_id, progress_date, activity, doctor_note, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, progress.getProgress_id());
            stmt.setString(2, progress.getSchedule_id());
            stmt.setTimestamp(3, progress.getProgress_date());
            stmt.setString(4, progress.getActivity());
            stmt.setString(5, progress.getDoctor_note());
            stmt.setString(6, progress.getStatus());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateProgress(TreatmentProgress progress) throws SQLException {
        String sql = "UPDATE Treatment_Progress SET schedule_id=?, progress_date=?, activity=?, doctor_note=?, status=? WHERE progress_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, progress.getSchedule_id());
            stmt.setTimestamp(2, progress.getProgress_date());
            stmt.setString(3, progress.getActivity());
            stmt.setString(4, progress.getDoctor_note());
            stmt.setString(5, progress.getStatus());
            stmt.setString(6, progress.getProgress_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteProgress(String progressId) throws SQLException {
        String sql = "DELETE FROM Treatment_Progress WHERE progress_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, progressId);
            return stmt.executeUpdate() > 0;
        }
    }
}


