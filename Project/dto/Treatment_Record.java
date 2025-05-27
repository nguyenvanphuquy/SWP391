package Project.dto;

public class Treatment_Record {
     private String record_id ;
     private String customer_id ;
     private String result_id ;
     public Treatment_Record() {
     }
     public Treatment_Record(String record_id, String customer_id, String result_id) {
        this.record_id = record_id;
        this.customer_id = customer_id;
        this.result_id = result_id;
     }
     public String getRecord_id() {
         return record_id;
     }
     public void setRecord_id(String record_id) {
         this.record_id = record_id;
     }
     public String getCustomer_id() {
         return customer_id;
     }
     public void setCustomer_id(String customer_id) {
         this.customer_id = customer_id;
     }
     public String getResult_id() {
         return result_id;
     }
     public void setResult_id(String result_id) {
         this.result_id = result_id;
     }
     
}
