package com.openschool.backend.requestsandresponse;

import com.openschool.backend.models.Course;
import com.openschool.backend.models.User;

import java.util.Date;

public class ContentResponse {
    private Long id;
    private String title;
    private String description;
    private Long courseId;
    private Date date;
    private String username;
    private String name;
    private String url;
    private String urlName;

    public ContentResponse(Long id, String title, String description, Long courseId, Date date, String username, String name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.courseId = courseId;
        this.date = date;
        this.username=username;
        this.name=name;
    }

    public ContentResponse() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
