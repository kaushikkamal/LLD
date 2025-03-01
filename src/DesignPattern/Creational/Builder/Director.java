package DesignPattern.Creational.Builder;

import DesignPattern.Creational.Builder.Builders.EngineerStudentBuilder;
import DesignPattern.Creational.Builder.Builders.MBAStudentBuilder;
import DesignPattern.Creational.Builder.Builders.Student;
import DesignPattern.Creational.Builder.Builders.StudentBuilder;

public class Director {
    StudentBuilder builder;

    public Director(StudentBuilder builder) {
        this.builder = builder;
    }

    public Student createStudent() {
        if (builder instanceof EngineerStudentBuilder) {
            return createEngineerStudent();
        }
        if (builder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineerStudent() {
        return builder
                .setRollNumber(1)
                .setName("KKB")
                .setFatherName("D")
                .setMotherName("A")
                .setAge(27)
                .setSubjects()
                .build();
    }

    private Student createMBAStudent() {
        return builder
                .setRollNumber(10)
                .setAge(27)
                .setSubjects()
                .build();
    }
}
