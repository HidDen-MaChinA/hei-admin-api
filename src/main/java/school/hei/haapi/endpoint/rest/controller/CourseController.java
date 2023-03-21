package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.model.User;
import school.hei.haapi.service.CourseService;
import school.hei.haapi.service.UserService;
import java.util.List;
import static java.util.stream.Collectors.toUnmodifiableList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService service;
    private final UserService userService;
    private final CourseMapper mapper;

    @GetMapping("/courses/{id}")
    public Course getGroupById(@PathVariable String id) {
        return mapper.toRest(service.getById(id));
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return service.getAll()
                .stream()
                .map(mapper::toRest)
                .collect(toUnmodifiableList());
    }

    @PutMapping("/courses")
    public List<Course> createOrUpdateCourses(@RequestBody List<Course> toWrite) {
        return service
                .saveAll(toWrite
                    .stream()
                    .map(mapper::toDomain)
                    .collect(toUnmodifiableList()))
                .stream()
                .map(mapper::toRest)
                .collect(toUnmodifiableList());
    }

    @GetMapping("/students/{student_id}/courses")
    public List<Course> getStudentsCourses(
            @PathVariable String student_id,
            @RequestParam(value = "status", required = false, defaultValue = "LINKED") String status) {
        User student = userService.getById(student_id);
        return student.getCourseStatus()
                .stream()
                .map(mapper::toRest)
                .collect(toUnmodifiableList());
    @PostMapping("/courses")
    public List<Course> updateCourse(@PathVariable int id, @RequestBody List<Course> coursesourse){
        return service.updateCourse(id, coursesourse).stream()
                .map(mapper::ToDomain)
                .collect(Collectors.toUnmodifiableList());
    }
}
