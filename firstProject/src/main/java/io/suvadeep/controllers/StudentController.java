package io.suvadeep.controllers;

import io.suvadeep.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Suvadeep Ghoshal", LocalDate.of(1997, Month.DECEMBER, 11), 23, "suvadeepghoshal@gmail.com"),
                new Student(2L, "Twinkle Chakraborty", LocalDate.of(1998, Month.AUGUST, 4), 23, "twinklechakraborty@gmail.com")
        );
    }
}
