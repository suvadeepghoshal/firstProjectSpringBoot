package io.suvadeep.controllers;

import io.suvadeep.models.Student;
import io.suvadeep.services.StudentService;
import io.suvadeep.services.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/student", method = RequestMethod.GET)
public class StudentController {

    StudentService studentService = new StudentServiceImpl();

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
