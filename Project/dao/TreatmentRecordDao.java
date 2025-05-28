package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.TreatmentRecord;

public class TreatmentRecordDao {

    private Connection conn;

    public TreatmentRecordDao(Connection conn) {
        this.conn = conn;
    }

    public TreatmentRecord getRecordById(String recordId) throws SQLException {
        String sql = "SELECT * FROM Treatment_Record WHERE record_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, recordId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TreatmentRecord(
                    rs.getString("record_id"),
                    rs.getString("customer_id"),
                    rs.getString("result_id")
                );
            }
        }
        return null;
    }

    public boolean insertRecord(TreatmentRecord record) throws SQLException {
        String sql = "INSERT INTO Treatment_Record(record_id, customer_id, result_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, record.getRecord_id());
            stmt.setString(2, record.getCustomer_id());
            stmt.setString(3, record.getResult_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateRecord(TreatmentRecord record) throws SQLException {
        String sql = "UPDATE Treatment_Record SET customer_id = ?, result_id = ? WHERE record_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, record.getCustomer_id());
            stmt.setString(2, record.getResult_id());
            stmt.setString(3, record.getRecord_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteRecord(String recordId) throws SQLException {
        String sql = "DELETE FROM Treatment_Record WHERE record_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, recordId);
            return stmt.executeUpdate() > 0;
        }
    }
}
