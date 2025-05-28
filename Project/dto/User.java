 package Project.dto;

import java.sql.Date;

 public class User {

    private String userId;
     private String full_name;
    private String gender ;
   private Date date_of_birth ;
     private String phone ;
    private String email ;
    private String address ;
     private int role_id ;
     
     public User() {
     }

     public User(String userId, String full_name, String gender, Date date_of_birth, String phone, String email,
            String address, int role_id) {
        this.userId = userId;
        this.full_name = full_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role_id = role_id;
     }

     public String getUserId() {
         return userId;
     }

     public void setUserId(String userId) {
         this.userId = userId;
     }

     public String getFull_name() {
         return full_name;
     }

     public void setFull_name(String full_name) {
         this.full_name = full_name;
     }

     public String getGender() {
         return gender;
     }

     public void setGender(String gender) {
         this.gender = gender;
     }

     public Date getDate_of_birth() {
         return date_of_birth;
     }

     public void setDate_of_birth(Date date_of_birth) {
         this.date_of_birth = date_of_birth;
     }

     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getAddress() {
         return address;
     }

     public void setAddress(String address) {
         this.address = address;
     }

     public int getRole_id() {
         return role_id;
     }

     public void setRole_id(int role_id) {
         this.role_id = role_id;
     }

     
     
}