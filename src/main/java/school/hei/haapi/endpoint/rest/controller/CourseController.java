package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.model.Courses;
import school.hei.haapi.service.CourseService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping(value = "/courses")
    public List<Courses> getCourses(
            @RequestParam int page ,
            @RequestParam int pageSize
    ) {
        return courseService.getCourses(page, pageSize);
    }
}

