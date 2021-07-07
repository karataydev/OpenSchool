package com.openschool.backend.requestsandresponse;

import com.openschool.backend.models.User;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CourseRequest {
    private String code;
    private String name;
    private String description;
    private String tutorUsername;

    public CourseRequest(String code, String name, String description, String tutorUsername) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.tutorUsername = tutorUsername;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTutorUsername() {
        return tutorUsername;
    }

    public void setTutorUsername(String tutorUsername) {
        this.tutorUsername = tutorUsername;
    }
}
