package io.suvadeep.firstProject.student.services;

import io.suvadeep.firstProject.student.models.Student;
import io.suvadeep.firstProject.student.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void registerStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("Student with id: " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudentDetails(Long studentId, String studentName, String studentEmail) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalStateException("Student with id: " + studentId + " does not exist."));
        if (studentName != null && studentName.length() > 0 && !Objects.equals(student.getName(), studentName)) {
            student.setName(studentName);
        }
        if (studentEmail != null && studentEmail.length() > 0 && !Objects.equals(student.getEmail(), studentEmail)) {
            if (studentRepository.findStudentByEmail(studentEmail).isPresent()) {
                throw new IllegalStateException("Email: " + studentEmail + " is already taken.");
            }
            student.setEmail(studentEmail);
        }
    }
}
