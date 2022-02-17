package com.dsi.student_data.student;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentByName = studentRepository
                .findStudentByName(student.getName());
        Optional<Student> studentByClass = studentRepository
                .findStudentByClassStanding(student.getClassStanding());
        if (studentByName.isPresent() && studentByClass.isPresent()) {
            throw new IllegalStateException("This name is already there");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id "+ studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, Integer classStanding) {
        // If the Student ID does not exist
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id "+ studentId + " does not exist"));

        // Update name
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (classStanding != null && classStanding > 0 && !Objects.equals(student.getClassStanding(), classStanding)) {
            student.setClassStanding(classStanding);
        }
    }
}
