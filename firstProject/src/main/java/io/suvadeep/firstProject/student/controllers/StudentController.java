package io.suvadeep.firstProject.student.controllers;

import io.suvadeep.firstProject.student.models.Student;
import io.suvadeep.firstProject.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "student")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "student/add_new_student")
    public void registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
    }
}
