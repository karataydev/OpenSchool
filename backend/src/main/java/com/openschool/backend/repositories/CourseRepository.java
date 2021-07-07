package com.openschool.backend.repositories;

import com.openschool.backend.models.Course;
import com.openschool.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findCourseByStudentsEquals(User user);
    List<Course> findCourseByTutorEquals(User user);
    Course findCourseByCode(String code);

}
