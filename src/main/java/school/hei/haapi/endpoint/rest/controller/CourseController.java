package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.service.CourseService;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService service;
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
}
