package io.suvadeep.controllers;

import io.suvadeep.models.Student;
import io.suvadeep.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/student", method = RequestMethod.GET)
@ComponentScan(basePackageClasses = StudentService.class)
public record StudentController(StudentService studentService) {

    @Autowired
    public StudentController {
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
