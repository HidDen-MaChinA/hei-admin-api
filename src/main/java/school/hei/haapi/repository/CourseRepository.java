package school.hei.haapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.Course;

@Repository
public Interface CourseRepository extends JpaRepository <Course,String>{

}
