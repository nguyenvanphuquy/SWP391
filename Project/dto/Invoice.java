package Project.dto;

import java.sql.Timestamp;

public class Invoice {
   private String  invoice_id ;
	 private String booking_id   ;
     private Timestamp issued_date;
     private double total_amount ;
     private String status ;
     public Invoice() {
     }
     public Invoice(String invoice_id, String booking_id, Timestamp issued_date, double total_amount, String status) {
        this.invoice_id = invoice_id;
        this.booking_id = booking_id;
        this.issued_date = issued_date;
        this.total_amount = total_amount;
        this.status = status;
     }
     public String getInvoice_id() {
         return invoice_id;
     }
     public void setInvoice_id(String invoice_id) {
         this.invoice_id = invoice_id;
     }
     public String getBooking_id() {
         return booking_id;
     }
     public void setBooking_id(String booking_id) {
         this.booking_id = booking_id;
     }
     public Timestamp getIssued_date() {
         return issued_date;
     }
     public void setIssued_date(Timestamp issued_date) {
         this.issued_date = issued_date;
     }
     public double getTotal_amount() {
         return total_amount;
     }
     public void setTotal_amount(double total_amount) {
         this.total_amount = total_amount;
     }
     public String getStatus() {
         return status;
     }
     public void setStatus(String status) {
         this.status = status;
     }

     
}
