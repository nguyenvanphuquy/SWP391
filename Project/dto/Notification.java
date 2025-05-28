package Project.dto;

import java.sql.Timestamp;

public class Notification {
    private String  notification_id ;
	 private String progress_id ;
     private String content ;
     private Timestamp sent_at ;
     private  boolean is_read ;
     public Notification() {
     }
     public Notification(String notification_id, String progress_id, String content, Timestamp sent_at, boolean is_read) {
        this.notification_id = notification_id;
        this.progress_id = progress_id;
        this.content = content;
        this.sent_at = sent_at;
        this.is_read = is_read;
     }
     public String getNotification_id() {
         return notification_id;
     }
     public void setNotification_id(String notification_id) {
         this.notification_id = notification_id;
     }
     public String getProgress_id() {
         return progress_id;
     }
     public void setProgress_id(String progress_id) {
         this.progress_id = progress_id;
     }
     public String getContent() {
         return content;
     }
     public void setContent(String content) {
         this.content = content;
     }
     public Timestamp getSent_at() {
         return sent_at;
     }
     public void setSent_at(Timestamp sent_at) {
         this.sent_at = sent_at;
     }
     public boolean isIs_read() {
         return is_read;
     }
     public void setIs_read(boolean is_read) {
         this.is_read = is_read;
     }
     
}
