package Project.dto;

import java.util.Date;

public class Blog_Posts {
     private String post_id ;
     private String manager_id ;
     private String title ;
     private String content ;
     private Date created_at ;
     public Blog_Posts() {
     }
     public Blog_Posts(String post_id, String manager_id, String title, String content, Date created_at) {
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
     public Date getCreated_at() {
         return created_at;
     }
     public void setCreated_at(Date created_at) {
         this.created_at = created_at;
     }
     
}
