package io.suvadeep.firstProject.student.controllers;

import io.suvadeep.firstProject.student.models.Student;
import io.suvadeep.firstProject.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "add")
    public void registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
    }

    @DeleteMapping(path = "delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "update/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String studentName, @RequestParam(required = false) String studentEmail) {
        studentService.updateStudentDetails(studentId, studentName, studentEmail);
    }
}
