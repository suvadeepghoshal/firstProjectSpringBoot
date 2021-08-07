package io.suvadeep.services.impl;

import io.suvadeep.models.Student;
import io.suvadeep.services.StudentService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Suvadeep Ghoshal", LocalDate.of(1997, Month.DECEMBER, 11), 23, "suvadeepghoshal@gmail.com"),
                new Student(2L, "Twinkle Chakraborty", LocalDate.of(1998, Month.AUGUST, 4), 23, "twinklechakraborty@gmail.com")
        );
    }
}
