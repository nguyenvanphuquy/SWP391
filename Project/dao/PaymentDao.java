package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Payment;

public class PaymentDao {

    private Connection conn;

    public PaymentDao(Connection conn) {
        this.conn = conn;
    }

    public Payment getPaymentById(String paymentId) throws SQLException {
        String sql = "SELECT * FROM Payment WHERE payment_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Payment(
                    rs.getString("payment_id"),
                    rs.getString("invoice_id"),
                    rs.getDouble("paid_amount"),
                    rs.getTimestamp("paid_at"),
                    rs.getString("method")
                );
            }
        }
        return null;
    }

    public boolean insertPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO Payment(payment_id, invoice_id, paid_amount, paid_at, method) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, payment.getPayment_id());
            stmt.setString(2, payment.getInvoice_id());
            stmt.setDouble(3, payment.getPaid_amount());
            stmt.setTimestamp(4, payment.getPaid_at());
            stmt.setString(5, payment.getMethod());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE Payment SET invoice_id = ?, paid_amount = ?, paid_at = ?, method = ? WHERE payment_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, payment.getInvoice_id());
            stmt.setDouble(2, payment.getPaid_amount());
            stmt.setTimestamp(3, payment.getPaid_at());
            stmt.setString(4, payment.getMethod());
            stmt.setString(5, payment.getPayment_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletePayment(String paymentId) throws SQLException {
        String sql = "DELETE FROM Payment WHERE payment_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentId);
            return stmt.executeUpdate() > 0;
        }
    }
}
