package Project.dto;

import java.sql.Timestamp;

public class BlogPosts {
     private String post_id ;
     private String manager_id ;
     private String title ;
     private String content ;
     private Timestamp created_at ;
     public BlogPosts() {
     }
     public BlogPosts(String post_id, String manager_id, String title, String content, Timestamp created_at) {
        this.post_id = post_id;
        this.manager_id = manager_id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
     }
     public String getPost_id() {
         return post_id;
     }
     public void setPost_id(String post_id) {
         this.post_id = post_id;
     }
     public String getManager_id() {
         return manager_id;
     }
     public void setManager_id(String manager_id) {
         this.manager_id = manager_id;
     }
     public String getTitle() {
         return title;
     }
     public void setTitle(String title) {
         this.title = title;
     }
     public String getContent() {
         return content;
     }
     public void setContent(String content) {
         this.content = content;
     }
     public Timestamp getCreated_at() {
         return created_at;
     }
     public void setCreated_at(Timestamp created_at) {
         this.created_at = created_at;
     }
     
}
