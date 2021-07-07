package com.openschool.backend.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 10)
    private String code;
    @NotBlank
    @Size(max = 30)
    private String name;

    @Size(max = 1024)
    private String description;

    @ManyToOne
    private User tutor;


    @OneToMany
    private List<Content> contents;

    @ManyToMany
    private List<User> students;

    public Course() {
    }

    public Course(String code, String name, User tutor) {
        this.code = code;
        this.name = name;
        this.tutor = tutor;
    }

    public Course(String code, String name, String description, User tutor) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.tutor = tutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public User getTutor() {
        return tutor;
    }

    public void setTutor(User tutor) {
        this.tutor = tutor;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }
    public void addStudent(User student){
        students.add(student);
    }
}
