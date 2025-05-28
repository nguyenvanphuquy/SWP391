package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.TreatmentServices;

public class TreatmentServicesDao {
   
    private Connection conn;

    public TreatmentServicesDao(Connection conn) {
        this.conn = conn;
    }

    
    public TreatmentServices getServiceById(String serviceId) throws SQLException {
        String sql = "SELECT * FROM Treatment_Services WHERE service_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, serviceId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TreatmentServices(
                    rs.getString("service_id"),
                    rs.getString("user_id"),
                    rs.getString("name_service"),       
                    rs.getString("description"),
                    rs.getString("type"),
                    rs.getDouble("fee"),                 
                    rs.getInt("duration_days")
                );
            }
        }
        return null;
    }

    public boolean insertService(TreatmentServices service) throws SQLException {
        String sql = "INSERT INTO Treatment_Services(service_id, user_id, name_service, description, type, fee, duration_days) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, service.getService_id());
            stmt.setString(2, service.getUser_id());
            stmt.setString(3, service.getName_service());
            stmt.setString(4, service.getDescription());
            stmt.setString(5, service.getType());
            stmt.setDouble(6, service.getFee());
            stmt.setInt(7, service.getDuration_days());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateService(TreatmentServices service) throws SQLException {
        String sql = "UPDATE Treatment_Services SET user_id=?, name_service=?, description=?, type=?, fee=?, duration_days=? WHERE service_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, service.getUser_id());
            stmt.setString(2, service.getName_service());
            stmt.setString(3, service.getDescription());
            stmt.setString(4, service.getType());
            stmt.setDouble(5, service.getFee());
            stmt.setInt(6, service.getDuration_days());
            stmt.setString(7, service.getService_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteService(String serviceId) throws SQLException {
        String sql = "DELETE FROM Treatment_Services WHERE service_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, serviceId);
            return stmt.executeUpdate() > 0;
        }
    }
}
