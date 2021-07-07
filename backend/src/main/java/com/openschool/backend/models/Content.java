package com.openschool.backend.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;
    @Size(max = 1024)
    private String description;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Course course;

    private String fileUrl;
    private String fileName;

    @CreatedDate
    private Date date;

    @ManyToOne
    private User user;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Content() {
    }

    public Content(String title, String description, Course course, User user) {
        this.title = title;
        this.description = description;
        this.course = course;
        this.date = new Date();
        this.user = user;
    }


    public Content(String title, String description, Course course, String fileUrl, String fileName, User user) {
        this.title = title;
        this.description = description;
        this.course = course;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.date = new Date();
        this.user = user;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
