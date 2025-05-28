package Project.dto;

import java.sql.Timestamp;

public class FeedbackRatings {

     private String feedback_id ;
     private String customer_id ;
     private String staff_id;
     private int rating ;
     private String comment ;
     private Timestamp created_at ;
     public FeedbackRatings() {
     }
     public FeedbackRatings(String feedback_id, String customer_id, String staff_id, int rating, String comment,
     Timestamp created_at) {
        this.feedback_id = feedback_id;
        this.customer_id = customer_id;
        this.staff_id = staff_id;
        this.rating = rating;
        this.comment = comment;
        this.created_at = created_at;
     }
     public String getFeedback_id() {
         return feedback_id;
     }
     public void setFeedback_id(String feedback_id) {
         this.feedback_id = feedback_id;
     }
     public String getCustomer_id() {
         return customer_id;
     }
     public void setCustomer_id(String customer_id) {
         this.customer_id = customer_id;
     }
     public String getStaff_id() {
         return staff_id;
     }
     public void setStaff_id(String staff_id) {
         this.staff_id = staff_id;
     }
     public int getRating() {
         return rating;
     }
     public void setRating(int rating) {
         this.rating = rating;
     }
     public String getComment() {
         return comment;
     }
     public void setComment(String comment) {
         this.comment = comment;
     }
     public Timestamp getCreated_at() {
         return created_at;
     }
     public void setCreated_at(Timestamp created_at) {
         this.created_at = created_at;
     }
     
}