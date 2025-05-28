package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Invoice;

public class InvoiceDao {
   
    private Connection conn;

    public InvoiceDao(Connection conn) {
        this.conn = conn;
    }

    public Invoice getInvoiceById(String invoiceId) throws SQLException {
        String sql = "SELECT * FROM Invoice WHERE invoice_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, invoiceId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Invoice(
                    rs.getString("invoice_id"),
                    rs.getString("booking_id"),
                    rs.getTimestamp("issued_date"),
                    rs.getDouble("total_amount"),
                    rs.getString("status")
                );
            }
        }
        return null;
    }

    public boolean insertInvoice(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO Invoice(invoice_id, booking_id, issued_date, total_amount, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, invoice.getInvoice_id());
            stmt.setString(2, invoice.getBooking_id());
            stmt.setTimestamp(3, invoice.getIssued_date());
            stmt.setDouble(4, invoice.getTotal_amount());
            stmt.setString(5, invoice.getStatus());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateInvoice(Invoice invoice) throws SQLException {
        String sql = "UPDATE Invoice SET booking_id=?, issued_date=?, total_amount=?, status=? WHERE invoice_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, invoice.getBooking_id());
            stmt.setTimestamp(2, invoice.getIssued_date());
            stmt.setDouble(3, invoice.getTotal_amount());
            stmt.setString(4, invoice.getStatus());
            stmt.setString(5, invoice.getInvoice_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteInvoice(String invoiceId) throws SQLException {
        String sql = "DELETE FROM Invoice WHERE invoice_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, invoiceId);
            return stmt.executeUpdate() > 0;
        }
    }
}


