package com.openschool.backend.controllers;

import com.openschool.backend.models.Content;
import com.openschool.backend.models.Course;
import com.openschool.backend.models.User;
import com.openschool.backend.requestsandresponse.*;
import com.openschool.backend.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;


    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    @PreAuthorize("hasRole('STUDENT') or hasRole('TUTOR')")
    public List<CourseResponse> getUserCourses(){
        return courseService.getCourses(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TUTOR')")
    public List<ContentResponse> getCourseContents(@PathVariable("id") Long courseid){
        List<CourseResponse> lists = courseService.getCourses(SecurityContextHolder.getContext().getAuthentication().getName());
        for(CourseResponse cs: lists){
            if(cs.getId().equals(courseid)){
                return courseService.getContents(courseid);
            }

        }
        return List.of(new ContentResponse());


    }
    @GetMapping("/details/{id}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TUTOR')")
    public CourseResponse getCourseDetails(@PathVariable("id") Long courseId){
        return courseService.getCourseDetails(courseId);
    }
    @PostMapping
    @PreAuthorize("hasRole('TUTOR')")
    public MessageResponse createCourse(@RequestBody CourseRequest courseRequest){
        courseService.createCourse(courseRequest);
        return new MessageResponse("Course created!");

    }
    @PostMapping("/{id}")
    @PreAuthorize("hasRole('TUTOR')")
    public MessageResponse createContent(@RequestBody ContentRequest contentRequest, @PathVariable("id") Long courseId){

        courseService.createContent(contentRequest, courseId, SecurityContextHolder.getContext().getAuthentication().getName());
        return new MessageResponse("Content created!");
    }
    @PostMapping("/register")
    @PreAuthorize("hasRole('STUDENT')")
    public void registerStudent(@RequestBody Map<String, String> payload){
        courseService.registerCourse(payload.get("code"), SecurityContextHolder.getContext().getAuthentication().getName());

    }
    @DeleteMapping("/content/{id}")
    @PreAuthorize("hasRole('TUTOR')")
    public MessageResponse deleteContent(@PathVariable("id") Long id){
        courseService.deleteContent(id, SecurityContextHolder.getContext().getAuthentication().getName());
        return new MessageResponse("deleted");
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TUTOR')")
    public MessageResponse deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id, SecurityContextHolder.getContext().getAuthentication().getName());
        return new MessageResponse("deleted");
    }

    @DeleteMapping("/unroll/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public MessageResponse unroll(@PathVariable("id") Long id){
        courseService.unrollCourse(id, SecurityContextHolder.getContext().getAuthentication().getName());
        return new MessageResponse("unrolled");
    }
}
