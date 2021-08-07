package io.suvadeep.services;

import io.suvadeep.models.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Suvadeep Ghoshal", LocalDate.of(1997, Month.DECEMBER, 11), 23, "suvadeepghoshal@gmail.com"),
                new Student(2L, "Twinkle Chakraborty", LocalDate.of(1998, Month.AUGUST, 4), 23, "twinklechakraborty@gmail.com")
        );
    }
}
