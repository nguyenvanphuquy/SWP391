package Project.dto;

public class Treatment_Services {

     private String service_id ;
	 private String user_id ;
     private  String name_service ;
     private String description ;
     private String type ;
     private double fee ;
     private int duration_days ;

     public Treatment_Services() {
     }

     public Treatment_Services(String service_id, String user_id, String name_service, String description, String type,
            double fee, int duration_days) {
        this.service_id = service_id;
        this.user_id = user_id;
        this.name_service = name_service;
        this.description = description;
        this.type = type;
        this.fee = fee;
        this.duration_days = duration_days;
     }

     public String getService_id() {
         return service_id;
     }

     public void setService_id(String service_id) {
         this.service_id = service_id;
     }

     public String getUser_id() {
         return user_id;
     }

     public void setUser_id(String user_id) {
         this.user_id = user_id;
     }

     public String getName_service() {
         return name_service;
     }

     public void setName_service(String name_service) {
         this.name_service = name_service;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public double getFee() {
         return fee;
     }

     public void setFee(double fee) {
         this.fee = fee;
     }

     public int getDuration_days() {
         return duration_days;
     }

     public void setDuration_days(int duration_days) {
         this.duration_days = duration_days;
     }

     
     
}