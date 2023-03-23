package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.model.Course;
import school.hei.haapi.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService service;
    private CourseMapper mapper;

    @GetMapping("/courses")
    public List<Course> updateCourse(
            @RequestParam String code,
            @RequestParam String name,
            @RequestParam int credits,
            @RequestParam String teacherFirstName,
            @RequestParam String teacherLastName
            ) {
        return service.GetAllAndFiltreReturnedList(code,name,credits,teacherFirstName,teacherLastName);
    }
}
