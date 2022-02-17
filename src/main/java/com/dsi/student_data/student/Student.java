package com.dsi.student_data.student;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private Integer classStanding;
    private String subject;
    private double fees;

    public Student() {
    }

    public Student(long id, String name, Integer classStanding) {
        this.id = id;
        this.name = name;
        this.classStanding = classStanding;
        this.subject = "Mathematics";
    }

    public Student(String name, Integer classStanding) {
        this.name = name;
        this.classStanding = classStanding;
        this.subject = "Mathematics";
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassStanding(Integer classStanding) {
        this.classStanding = classStanding;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getClassStanding() {
        return classStanding;
    }

    public String getSubject() {
        return subject;
    }

    public double getFees() {
        return 1000 * (4 + 0.5*classStanding);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classStanding=" + classStanding +
                ", subject='" + subject + '\'' +
                ", fees=" + fees +
                '}';
    }
}

