package io.suvadeep.firstProject.student.configuration;

import io.suvadeep.firstProject.student.models.Student;
import io.suvadeep.firstProject.student.respository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student suvadeepGhoshal = new Student("Suvadeep Ghoshal", LocalDate.of(1997, DECEMBER, 11), 23, "suvadeepghoshal@gmail.com");
            Student twinkleChakraborty = new Student("Twinkle Chakraborty", LocalDate.of(1998, AUGUST, 4), 23, "twinklechakraborty@gmail.com");
            Student vivekanandaGhosal = new Student("Vivekananda Ghosal", LocalDate.of(1966, JANUARY, 12), 56, "vivekanandaghosal@gmail.com");
            Iterable<Student> students = List.of(suvadeepGhoshal, twinkleChakraborty, vivekanandaGhosal);
            studentRepository.saveAll(students);
        };
    }
}
