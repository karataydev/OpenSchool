package com.openschool.backend.services;

import com.openschool.backend.models.*;
import com.openschool.backend.repositories.ContentRepository;
import com.openschool.backend.repositories.CourseRepository;
import com.openschool.backend.repositories.FileDBRepository;
import com.openschool.backend.repositories.UserRepository;
import com.openschool.backend.requestsandresponse.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CourseService {
    private final ContentRepository contentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final FileDBRepository fileDBRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, UserRepository userRepository, ContentRepository contentRepository, FileDBRepository fileDBRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.contentRepository = contentRepository;
        this.fileDBRepository =  fileDBRepository;
    }

    public List<CourseResponse> getCourses(String name){
        User user = userRepository.findByUsername(name).orElse(new User());
        List<Course> courses = courseRepository.findCourseByStudentsEquals(user);
        for(Role role: user.getRoles()){
            if(role.getName().equals(ERole.ROLE_TUTOR)){
                courses = courseRepository.findCourseByTutorEquals(user);
            }
        }


       List<CourseResponse> courseResponses = new ArrayList<>();

       for(Course course: courses){
           courseResponses.add(new CourseResponse(course.getId(),course.getCode(),course.getName(),course.getDescription(),course.getTutor().getId(),course.getTutor().getFirstName() + " " + course.getTutor().getLastName(), course.getTutor().getUsername()));
       }
       return courseResponses;
    }
    public void createCourse(CourseRequest courseRequest){
        Course course = new Course(courseRequest.getCode(), courseRequest.getName(), courseRequest.getDescription(), userRepository.findByUsername(courseRequest.getTutorUsername()).orElseThrow());
        courseRepository.save(course);
    }
    public List<ContentResponse> getContents(Long courseId){
        List<Content> contents = contentRepository.getContentByCourse_IdOrderByDate(courseId);
        List<ContentResponse> contentResponses = new ArrayList<>();
        for(Content content: contents){
            ContentResponse ct = new ContentResponse(content.getId(),content.getTitle(),content.getDescription(),content.getCourse().getId(),content.getDate(),content.getUser().getUsername(), content.getUser().getFirstName() + " " + content.getUser().getLastName());
            if(content.getFileUrl()!=null){
                ct.setUrl(content.getFileUrl());
                ct.setUrlName(content.getFileName());
            }

            contentResponses.add(ct);
        }
        contentResponses.sort(Comparator.comparing(ContentResponse::getDate).reversed());
        return contentResponses;
    }

    public void createContent(ContentRequest contentRequest, Long courseId, String username){
        System.out.println(contentRequest.toString());
        if(contentRequest.getFileUrl()==null){
            contentRepository.save(new Content(contentRequest.getTitle(), contentRequest.getDescription(), courseRepository.getById(courseId), userRepository.findByUsername(username).orElseThrow()));
        }
        else {
            contentRepository.save(new Content(contentRequest.getTitle(), contentRequest.getDescription(), courseRepository.getById(courseId), contentRequest.getFileUrl(), contentRequest.getFileName(), userRepository.findByUsername(username).orElseThrow()));


        }

    }
    public CourseResponse getCourseDetails(Long id){
        Course course = courseRepository.getById(id);
        return new CourseResponse(course.getId(), course.getCode(), course.getName(), course.getDescription(), course.getTutor().getId(), course.getTutor().getFirstName() + " " + course.getTutor().getLastName(), course.getTutor().getUsername());
    }

    public void registerCourse(String courseCode,String username){
        System.out.println("cccode"+ courseCode);
        User student = userRepository.findByUsername(username).orElseThrow();
        System.out.println(student.getUsername());

        Course course = courseRepository.findCourseByCode(courseCode);
        course.getStudents().add(student);
        courseRepository.save(course);
    }

    public void deleteContent(Long id, String username){
        User tutor = userRepository.findByUsername(username).orElseThrow();
        Content content = contentRepository.getById(id);
        if(content.getUser().equals(tutor)){
            String url = content.getFileUrl();
            FileDB file = fileDBRepository.getById(url);
            fileDBRepository.delete(file);
            contentRepository.deleteById(id);
        }
    }
    public void deleteCourse(Long id, String username){
        User tutor = userRepository.findByUsername(username).orElseThrow();
        Course course = courseRepository.getById(id);
        if(course.getTutor().equals(tutor)){
            courseRepository.deleteById(id);
        }
    }
    public void unrollCourse(Long id, String username){
        User student = userRepository.findByUsername(username).orElseThrow();
        Course course = courseRepository.getById(id);
        List<User> students = course.getStudents();
        if(students.contains(student)){
            students.remove(student);
            course.setStudents(students);
            courseRepository.save(course);
        }
    }


}
