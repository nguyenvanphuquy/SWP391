package Project.dto;

import java.util.Date;

public class Treatment_Progress {
     private String progress_id ;
     private String schedule_id ;
     private Date  progress_date ;
     private String activity ;
     private String doctor_note ;
     private String status ;
     public Treatment_Progress() {
     }
     public Treatment_Progress(String progress_id, String schedule_id, Date progress_date, String activity,
            String doctor_note, String status) {
        this.progress_id = progress_id;
        this.schedule_id = schedule_id;
        this.progress_date = progress_date;
        this.activity = activity;
        this.doctor_note = doctor_note;
        this.status = status;
     }
     public String getProgress_id() {
         return progress_id;
     }
     public void setProgress_id(String progress_id) {
         this.progress_id = progress_id;
     }
     public String getSchedule_id() {
         return schedule_id;
     }
     public void setSchedule_id(String schedule_id) {
         this.schedule_id = schedule_id;
     }
     public Date getProgress_date() {
         return progress_date;
     }
     public void setProgress_date(Date progress_date) {
         this.progress_date = progress_date;
     }
     public String getActivity() {
         return activity;
     }
     public void setActivity(String activity) {
         this.activity = activity;
     }
     public String getDoctor_note() {
         return doctor_note;
     }
     public void setDoctor_note(String doctor_note) {
         this.doctor_note = doctor_note;
     }
     public String getStatus() {
         return status;
     }
     public void setStatus(String status) {
         this.status = status;
     }

     
}
