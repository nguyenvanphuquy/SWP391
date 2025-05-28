package Project.dto;

import java.sql.Timestamp;

public class WorkSchedule {
   private String  work_id ;
   private String  doctor_id ;
   private Timestamp  work_date ;
   private String  shift;

   public WorkSchedule() {
   }

   public WorkSchedule(String work_id, String doctor_id, Timestamp work_date, String shift) {
    this.work_id = work_id;
    this.doctor_id = doctor_id;
    this.work_date = work_date;
    this.shift = shift;
   }

   public String getWork_id() {
    return work_id;
   }

   public void setWork_id(String work_id) {
    this.work_id = work_id;
   }

   public String getDoctor_id() {
    return doctor_id;
   }

   public void setDoctor_id(String doctor_id) {
    this.doctor_id = doctor_id;
   }

   public Timestamp getWork_date() {
    return work_date;
   }

   public void setWork_date(Timestamp work_date) {
    this.work_date = work_date;
   }

   public String getShift() {
    return shift;
   }

   public void setShift(String shift) {
    this.shift = shift;
   }

   
   
}
