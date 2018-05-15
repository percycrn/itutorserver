package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Course;

public interface CourseRepository extends JpaRepository<Course,String> {

}
