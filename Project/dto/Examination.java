package Project.dto;

import java.util.Date;

public class Examination {
     private String exam_id ; 
    private String  booking_id ;  
     private Date exam_date ;
     private String diagnosis ;
     private String recommendation ;
     
     public Examination() {
     }

     public Examination(String exam_id, String booking_id, Date exam_date, String diagnosis, String recommendation) {
        this.exam_id = exam_id;
        this.booking_id = booking_id;
        this.exam_date = exam_date;
        this.diagnosis = diagnosis;
        this.recommendation = recommendation;
     }

     public String getExam_id() {
         return exam_id;
     }

     public void setExam_id(String exam_id) {
         this.exam_id = exam_id;
     }

     public String getBooking_id() {
         return booking_id;
     }

     public void setBooking_id(String booking_id) {
         this.booking_id = booking_id;
     }

     public Date getExam_date() {
         return exam_date;
     }

     public void setExam_date(Date exam_date) {
         this.exam_date = exam_date;
     }

     public String getDiagnosis() {
         return diagnosis;
     }

     public void setDiagnosis(String diagnosis) {
         this.diagnosis = diagnosis;
     }

     public String getRecommendation() {
         return recommendation;
     }

     public void setRecommendation(String recommendation) {
         this.recommendation = recommendation;
     }

     
}
