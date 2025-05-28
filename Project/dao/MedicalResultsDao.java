package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.MedicalResults;

public class MedicalResultsDao {
    public class MedicalResultsDAO {
    private Connection conn;

    public MedicalResultsDAO(Connection conn) {
        this.conn = conn;
    }

    public MedicalResults getResultById(String resultId) throws SQLException {
        String sql = "SELECT * FROM Medical_Results WHERE result_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, resultId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new MedicalResults(
                    rs.getString("result_id"),
                    rs.getString("exam_id"),
                    rs.getString("test_name"),
                    rs.getString("result_value"),
                    rs.getTimestamp("result_date"),
                    rs.getString("staff_id")
                );
            }
        }
        return null;
    }

    public boolean insertResult(MedicalResults result) throws SQLException {
        String sql = "INSERT INTO Medical_Results(result_id, exam_id, test_name, result_value, result_date, staff_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, result.getResult_id());
            stmt.setString(2, result.getExam_id());
            stmt.setString(3, result.getTest_name());
            stmt.setString(4, result.getResult_value());
            stmt.setTimestamp(5, result.getResult_date());
            stmt.setString(6, result.getStaff_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateResult(MedicalResults result) throws SQLException {
        String sql = "UPDATE Medical_Results SET exam_id=?, test_name=?, result_value=?, result_date=?, staff_id=? WHERE result_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, result.getExam_id());
            stmt.setString(2, result.getTest_name());
            stmt.setString(3, result.getResult_value());
            stmt.setTimestamp(4, result.getResult_date());
            stmt.setString(5, result.getStaff_id());
            stmt.setString(6, result.getResult_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteResult(String resultId) throws SQLException {
        String sql = "DELETE FROM Medical_Results WHERE result_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, resultId);
            return stmt.executeUpdate() > 0;
        }
    }
}

}
