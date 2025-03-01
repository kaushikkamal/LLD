package DesignPattern.Creational.Builder.Builders;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        List<String> sub = new ArrayList<>();
        sub.add("Finance");
        sub.add("Marketing");

        this.subjects = sub;
        return this;
    }
}
