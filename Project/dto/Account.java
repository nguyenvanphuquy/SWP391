package Project.dto;

import java.sql.Timestamp;

public class Account {
   private String  account_id ;
   private String  user_id  ;
   private String username ; 
   private String password_hash ; 
   private Timestamp   created_at ;
     private boolean is_active ;
     
     public Account() {
     }

     public Account(String account_id, String user_id, String username, String password_hash, Timestamp  created_at,
            boolean is_active) {
        this.account_id = account_id;
        this.user_id = user_id;
        this.username = username;
        this.password_hash = password_hash;
        this.created_at = created_at;
        this.is_active = is_active;
     }

     public String getAccount_id() {
         return account_id;
     }

     public void setAccount_id(String account_id) {
         this.account_id = account_id;
     }

     public String getUser_id() {
         return user_id;
     }

     public void setUser_id(String user_id) {
         this.user_id = user_id;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getPassword_hash() {
         return password_hash;
     }

     public void setPassword_hash(String password_hash) {
         this.password_hash = password_hash;
     }

     public Timestamp  getCreated_at() {
         return created_at;
     }

     public void setCreated_at(Timestamp  created_at) {
         this.created_at = created_at;
     }

     public boolean getIs_active() {
         return is_active;
     }

     public void setIs_active(boolean is_active) {
         this.is_active = is_active;
     }

     

}
