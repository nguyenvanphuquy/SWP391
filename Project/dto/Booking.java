package Project.dto;

import java.util.Date;

public class Booking {
     private String booking_id ;
   private String customer_id ;
     private String service_id ;
     private  String work_id ;
      private Date booking_date;
     private String status ;
     private String note ;
     
     public Booking() {
     }

     public Booking(String booking_id, String customer_id, String service_id, String work_id, Date booking_date,
            String status, String note) {
        this.booking_id = booking_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
        this.work_id = work_id;
        this.booking_date = booking_date;
        this.status = status;
        this.note = note;
     }

     public String getBooking_id() {
         return booking_id;
     }

     public void setBooking_id(String booking_id) {
         this.booking_id = booking_id;
     }

     public String getCustomer_id() {
         return customer_id;
     }

     public void setCustomer_id(String customer_id) {
         this.customer_id = customer_id;
     }

     public String getService_id() {
         return service_id;
     }

     public void setService_id(String service_id) {
         this.service_id = service_id;
     }

     public String getWork_id() {
         return work_id;
     }

     public void setWork_id(String work_id) {
         this.work_id = work_id;
     }

     public Date getBooking_date() {
         return booking_date;
     }

     public void setBooking_date(Date booking_date) {
         this.booking_date = booking_date;
     }

     public String getStatus() {
         return status;
     }

     public void setStatus(String status) {
         this.status = status;
     }

     public String getNote() {
         return note;
     }

     public void setNote(String note) {
         this.note = note;
     }

     
}
