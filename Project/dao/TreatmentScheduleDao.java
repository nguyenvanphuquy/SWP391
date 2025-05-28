package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.TreatmentSchedule;

public class TreatmentScheduleDao {
    private Connection conn;

    public TreatmentScheduleDao(Connection conn) {
        this.conn = conn;
    }

    public TreatmentSchedule getScheduleById(String scheduleId) throws SQLException {
        String sql = "SELECT * FROM Treatment_Schedules WHERE schedule_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, scheduleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TreatmentSchedule(
                    rs.getString("schedule_id"),
                    rs.getString("result_id"),
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getString("status"),
                    rs.getString("notes")
                );
            }
        }
        return null;
    }

    public boolean insertSchedule(TreatmentSchedule schedule) throws SQLException {
        String sql = "INSERT INTO Treatment_Schedules(schedule_id, result_id, start_date, end_date, status, notes) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schedule.getSchedule_id());
            stmt.setString(2, schedule.getResult_id());
            stmt.setDate(3, schedule.getStart_date());
            stmt.setDate(4, schedule.getEnd_date());
            stmt.setString(5, schedule.getStatus());
            stmt.setString(6, schedule.getNotes());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateSchedule(TreatmentSchedule schedule) throws SQLException {
        String sql = "UPDATE Treatment_Schedules SET result_id=?, start_date=?, end_date=?, status=?, notes=? WHERE schedule_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schedule.getResult_id());
            stmt.setDate(2, schedule.getStart_date());
            stmt.setDate(3, schedule.getEnd_date());
            stmt.setString(4, schedule.getStatus());
            stmt.setString(5, schedule.getNotes());
            stmt.setString(6, schedule.getSchedule_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteSchedule(String scheduleId) throws SQLException {
        String sql = "DELETE FROM Treatment_Schedules WHERE schedule_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, scheduleId);
            return stmt.executeUpdate() > 0;
        }
    }
}
