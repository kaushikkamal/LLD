package DesignPattern.Creational.Builder;

import DesignPattern.Creational.Builder.Builders.EngineerStudentBuilder;
import DesignPattern.Creational.Builder.Builders.MBAStudentBuilder;
import DesignPattern.Creational.Builder.Builders.Student;

public class BuilderDesignPatternDriver {
    // This class will act as a Client

    public static void execute() {
        Director obj1 = new Director(new EngineerStudentBuilder());
        Director obj2 = new Director(new MBAStudentBuilder());

        Student engineerStudent = obj1.createStudent();
        Student mbaStudent = obj2.createStudent();

        System.out.println(engineerStudent);
        System.out.println(mbaStudent);

    }
}
