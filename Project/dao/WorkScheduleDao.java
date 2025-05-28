package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.WorkSchedule;

public class WorkScheduleDao {
    
    private Connection conn;

    public WorkScheduleDao(Connection conn) {
        this.conn = conn;
    }

    public WorkSchedule getWorkScheduleById(String workId) throws SQLException {
        String sql = "SELECT * FROM WorkSchedule WHERE work_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, workId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new WorkSchedule(
                    rs.getString("work_id"),
                    rs.getString("doctor_id"),
                    rs.getTimestamp("work_date"),
                    rs.getString("shift")
                );
            }
        }
        return null;
    }

    public boolean insertWorkSchedule(WorkSchedule schedule) throws SQLException {
        String sql = "INSERT INTO WorkSchedule(work_id, doctor_id, work_date, shift) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schedule.getWork_id());
            stmt.setString(2, schedule.getDoctor_id());
            stmt.setTimestamp(3, schedule.getWork_date());
            stmt.setString(4, schedule.getShift());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateWorkSchedule(WorkSchedule schedule) throws SQLException {
        String sql = "UPDATE WorkSchedule SET doctor_id=?, work_date=?, shift=? WHERE work_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schedule.getDoctor_id());
            stmt.setTimestamp(2, schedule.getWork_date());
            stmt.setString(3, schedule.getShift());
            stmt.setString(4, schedule.getWork_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteWorkSchedule(String workId) throws SQLException {
        String sql = "DELETE FROM WorkSchedule WHERE work_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, workId);
            return stmt.executeUpdate() > 0;
        }
    }
}


