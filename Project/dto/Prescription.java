package Project.dto;

public class Prescription {
     private String prescription_id ;
     private String result_id  ;
     private String medicine_name;
     private String dosage ;
     private String usage_instruction ;
     public Prescription() {
     }
     public Prescription(String prescription_id, String result_id, String medicine_name, String dosage,
            String usage_instruction) {
        this.prescription_id = prescription_id;
        this.result_id = result_id;
        this.medicine_name = medicine_name;
        this.dosage = dosage;
        this.usage_instruction = usage_instruction;
     }
     public String getPrescription_id() {
         return prescription_id;
     }
     public void setPrescription_id(String prescription_id) {
         this.prescription_id = prescription_id;
     }
     public String getResult_id() {
         return result_id;
     }
     public void setResult_id(String result_id) {
         this.result_id = result_id;
     }
     public String getMedicine_name() {
         return medicine_name;
     }
     public void setMedicine_name(String medicine_name) {
         this.medicine_name = medicine_name;
     }
     public String getDosage() {
         return dosage;
     }
     public void setDosage(String dosage) {
         this.dosage = dosage;
     }
     public String getUsage_instruction() {
         return usage_instruction;
     }
     public void setUsage_instruction(String usage_instruction) {
         this.usage_instruction = usage_instruction;
     }

     
}
