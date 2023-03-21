package school.hei.haapi.endpoint.rest.mapper;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Course;

@Component
@AllArgsConstructor
public class CourseMapper {
    public Course ToDomain(Course course){
        Course newCourse = new Course();
        newCourse.setId(course.getId());
        newCourse.setCode(course.getCode());
        newCourse.setName(course.getName());
        newCourse.setCredits(course.getCredits());
        newCourse.setMain_teacher(course.getMain_teacher());

        return newCourse;
    }
     public Course toRest(school.hei.haapi.model.Course domainCourse) {
        return new Course()
                .id(domainCourse.getId())
                .ref(domainCourse.getRef())
                .name(domainCourse.getName())
                .credits(domainCourse.getCredits())
                .totalHours(domainCourse.getTotalHours());
    }

    public school.hei.haapi.model.Course toDomain(Course restCourse) {
        return school.hei.haapi.model.Course.builder()
                .id(restCourse.getId())
                .ref(restCourse.getRef())
                .name(restCourse.getName())
                .credits(restCourse.getCredits())
                .totalHours(restCourse.getTotalHours())
                .build();
    }

}
