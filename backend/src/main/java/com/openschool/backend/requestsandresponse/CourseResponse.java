package com.openschool.backend.requestsandresponse;



public class CourseResponse {
    private Long id;

    private String code;

    private String name;

    private String description;

    private Long tutorId;
    private String tutorName;
    private String tutorUsername;

    public CourseResponse(Long id, String code, String name, String description, Long tutorId, String tutorName, String tutorUsername) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorUsername = tutorUsername;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }
}
