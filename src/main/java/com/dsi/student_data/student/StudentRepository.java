package com.dsi.student_data.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //@Query("SELECT s FROM Student s WHERE s.name = ?1 AND s.classStanding = ?2")
    Optional<Student> findStudentByName(String name);
    Optional<Student> findStudentByClassStanding(Integer classStanding);
}
