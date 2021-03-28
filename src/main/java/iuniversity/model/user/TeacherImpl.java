package iuniversity.model.user;
import java.util.*;

import iuniversity.model.didactics.Course;

public class TeacherImpl extends AbstractUser implements Teacher{

    private int registrarionNumber;
    private Set<Course> courses;
    
    public TeacherImpl(int registrarionNumber, Set<Course> courses) {
        this.registrarionNumber = registrarionNumber;
        this.courses = courses;
    }

    @Override
    public int getRegistrationNumber() {
        return this.registrarionNumber;
    }

    @Override
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }

}
