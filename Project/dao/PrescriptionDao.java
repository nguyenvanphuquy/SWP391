package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Prescription;

public class PrescriptionDao {
    
    private Connection conn;

    public PrescriptionDao(Connection conn) {
        this.conn = conn;
    }

    public Prescription getPrescriptionById(String prescriptionId) throws SQLException {
        String sql = "SELECT * FROM Prescription WHERE prescription_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prescriptionId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Prescription(
                    rs.getString("prescription_id"),
                    rs.getString("result_id"),
                    rs.getString("medicine_name"),
                    rs.getString("dosage"),
                    rs.getString("usage_instruction")
                );
            }
        }
        return null;
    }

    public boolean insertPrescription(Prescription prescription) throws SQLException {
        String sql = "INSERT INTO Prescription(prescription_id, result_id, medicine_name, dosage, usage_instruction) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prescription.getPrescription_id());
            stmt.setString(2, prescription.getResult_id());
            stmt.setString(3, prescription.getMedicine_name());
            stmt.setString(4, prescription.getDosage());
            stmt.setString(5, prescription.getUsage_instruction());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updatePrescription(Prescription prescription) throws SQLException {
        String sql = "UPDATE Prescription SET result_id=?, medicine_name=?, dosage=?, usage_instruction=? WHERE prescription_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prescription.getResult_id());
            stmt.setString(2, prescription.getMedicine_name());
            stmt.setString(3, prescription.getDosage());
            stmt.setString(4, prescription.getUsage_instruction());
            stmt.setString(5, prescription.getPrescription_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletePrescription(String prescriptionId) throws SQLException {
        String sql = "DELETE FROM Prescription WHERE prescription_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prescriptionId);
            return stmt.executeUpdate() > 0;
        }
    }
}


