package main.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer idBlog;
    @Column(name = "blog_title")
    private String title;
    @Column(name = "blog_content")
    private String content;

    public Blog() {
    }

    public Blog(Integer idBlog, String title, String content) {
        this.idBlog = idBlog;
        this.title = title;
        this.content = content;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
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
}
