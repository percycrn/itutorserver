package com.usst.springbootitutor;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usst.springbootitutor.Course;

public interface CourseRepository extends JpaRepository<Course,String> {

}
