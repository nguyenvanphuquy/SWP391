package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Examination;

public class ExaminationDao {
   
    private Connection conn;

    public ExaminationDao(Connection conn) {
        this.conn = conn;
    }

    public Examination getExaminationById(String examId) throws SQLException {
        String sql = "SELECT * FROM Examination WHERE exam_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, examId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Examination(
                    rs.getString("exam_id"),
                    rs.getString("booking_id"),
                    rs.getTimestamp("exam_date"),
                    rs.getString("diagnosis"),
                    rs.getString("recommendation")
                );
            }
        }
        return null;
    }

    public boolean insertExamination(Examination exam) throws SQLException {
        String sql = "INSERT INTO Examination(exam_id, booking_id, exam_date, diagnosis, recommendation) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exam.getExam_id());
            stmt.setString(2, exam.getBooking_id());
            stmt.setTimestamp(3, exam.getExam_date());
            stmt.setString(4, exam.getDiagnosis());
            stmt.setString(5, exam.getRecommendation());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateExamination(Examination exam) throws SQLException {
        String sql = "UPDATE Examination SET booking_id=?, exam_date=?, diagnosis=?, recommendation=? WHERE exam_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exam.getBooking_id());
            stmt.setTimestamp(2, exam.getExam_date());
            stmt.setString(3, exam.getDiagnosis());
            stmt.setString(4, exam.getRecommendation());
            stmt.setString(5, exam.getExam_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteExamination(String examId) throws SQLException {
        String sql = "DELETE FROM Examination WHERE exam_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, examId);
            return stmt.executeUpdate() > 0;
        }
    }
}


