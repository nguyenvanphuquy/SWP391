package Project.dto;

import java.sql.Timestamp;

public class TreatmentSchedule {
     private String schedule_id ;
     private String result_id ;
     private Timestamp start_date ;
     private Timestamp end_date ;
     private String status ;
     private  String notes ;
     
     public TreatmentSchedule() {
     }

     public TreatmentSchedule(String schedule_id, String result_id, Timestamp start_date, Timestamp end_date, String status,
            String notes) {
        this.schedule_id = schedule_id;
        this.result_id = result_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.notes = notes;
     }

     public String getSchedule_id() {
         return schedule_id;
     }

     public void setSchedule_id(String schedule_id) {
         this.schedule_id = schedule_id;
     }

     public String getResult_id() {
         return result_id;
     }

     public void setResult_id(String result_id) {
         this.result_id = result_id;
     }

     public Timestamp getStart_date() {
         return start_date;
     }

     public void setStart_date(Timestamp start_date) {
         this.start_date = start_date;
     }

     public Timestamp getEnd_date() {
         return end_date;
     }

     public void setEnd_date(Timestamp end_date) {
         this.end_date = end_date;
     }

     public String getStatus() {
         return status;
     }

     public void setStatus(String status) {
         this.status = status;
     }

     public String getNotes() {
         return notes;
     }

     public void setNotes(String notes) {
         this.notes = notes;
     }

     
}
