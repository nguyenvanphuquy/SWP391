package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.Booking;

public class BookingDao {
  
    private Connection conn;

    public BookingDao(Connection conn) {
        this.conn = conn;
    }

    public Booking getBookingById(String bookingId) throws SQLException {
        String sql = "SELECT * FROM Booking WHERE booking_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Booking(
                    rs.getString("booking_id"),
                    rs.getString("customer_id"),
                    rs.getString("service_id"),
                    rs.getString("work_id"),
                    rs.getTimestamp("booking_date"),
                    rs.getString("status"),
                    rs.getString("note")
                );
            }
        }
        return null;
    }

    public boolean insertBooking(Booking booking) throws SQLException {
        String sql = "INSERT INTO Booking(booking_id, customer_id, service_id, work_id, booking_date, status, note) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, booking.getBooking_id());
            stmt.setString(2, booking.getCustomer_id());
            stmt.setString(3, booking.getService_id());
            stmt.setString(4, booking.getWork_id());
            stmt.setTimestamp(5, booking.getBooking_date());
            stmt.setString(6, booking.getStatus());
            stmt.setString(7, booking.getNote());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateBooking(Booking booking) throws SQLException {
        String sql = "UPDATE Booking SET customer_id=?, service_id=?, work_id=?, booking_date=?, status=?, note=? WHERE booking_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, booking.getCustomer_id());
            stmt.setString(2, booking.getService_id());
            stmt.setString(3, booking.getWork_id());
            stmt.setTimestamp(4, booking.getBooking_date());
            stmt.setString(5, booking.getStatus());
            stmt.setString(6, booking.getNote());
            stmt.setString(7, booking.getBooking_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteBooking(String bookingId) throws SQLException {
        String sql = "DELETE FROM Booking WHERE booking_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookingId);
            return stmt.executeUpdate() > 0;
        }
    }
}


