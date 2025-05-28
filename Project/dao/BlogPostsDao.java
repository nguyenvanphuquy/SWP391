package Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project.dto.BlogPosts;

public class BlogPostsDao {

    private Connection conn;

    public BlogPostsDao(Connection conn) {
        this.conn = conn;
    }

    public BlogPosts getPostById(String postId) throws SQLException {
        String sql = "SELECT * FROM Blog_Posts WHERE post_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, postId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BlogPosts(
                    rs.getString("post_id"),
                    rs.getString("manager_id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("created_at")
                );
            }
        }
        return null;
    }

    public boolean insertPost(BlogPosts post) throws SQLException {
        String sql = "INSERT INTO Blog_Posts(post_id, manager_id, title, content, created_at) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, post.getPost_id());
            stmt.setString(2, post.getManager_id());
            stmt.setString(3, post.getTitle());
            stmt.setString(4, post.getContent());
            stmt.setTimestamp(5, post.getCreated_at());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updatePost(BlogPosts post) throws SQLException {
        String sql = "UPDATE Blog_Posts SET manager_id = ?, title = ?, content = ?, created_at = ? WHERE post_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, post.getManager_id());
            stmt.setString(2, post.getTitle());
            stmt.setString(3, post.getContent());
            stmt.setTimestamp(4, post.getCreated_at());
            stmt.setString(5, post.getPost_id());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletePost(String postId) throws SQLException {
        String sql = "DELETE FROM Blog_Posts WHERE post_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, postId);
            return stmt.executeUpdate() > 0;
        }
    }
}
