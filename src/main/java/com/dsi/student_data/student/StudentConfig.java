package com.dsi.student_data.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student aly = new Student(
                    "Aly Mooltazeem",
                    9
            );

            Student sams = new Student(
                    "Toufiqul Alam Sams",
                    10
            );

            repository.saveAll(
                    List.of(aly, sams)
            );

        };
    }
}
