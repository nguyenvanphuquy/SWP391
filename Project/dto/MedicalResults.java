package Project.dto;

import java.sql.Timestamp;

public class MedicalResults {
     private String result_id ; 
	 private String exam_id ;
     private String test_name ;
     private String result_value ;
     private Timestamp result_date ;
     private String staff_id ;
     
     public MedicalResults() {
     }

     public MedicalResults(String result_id, String exam_id, String test_name, String result_value, Timestamp result_date,
            String staff_id) {
        this.result_id = result_id;
        this.exam_id = exam_id;
        this.test_name = test_name;
        this.result_value = result_value;
        this.result_date = result_date;
        this.staff_id = staff_id;
     }

     public String getResult_id() {
         return result_id;
     }

     public void setResult_id(String result_id) {
         this.result_id = result_id;
     }

     public String getExam_id() {
         return exam_id;
     }

     public void setExam_id(String exam_id) {
         this.exam_id = exam_id;
     }

     public String getTest_name() {
         return test_name;
     }

     public void setTest_name(String test_name) {
         this.test_name = test_name;
     }

     public String getResult_value() {
         return result_value;
     }

     public void setResult_value(String result_value) {
         this.result_value = result_value;
     }

     public Timestamp getResult_date() {
         return result_date;
     }

     public void setResult_date(Timestamp result_date) {
         this.result_date = result_date;
     }

     public String getStaff_id() {
         return staff_id;
     }

     public void setStaff_id(String staff_id) {
         this.staff_id = staff_id;
     }

     
     
}
