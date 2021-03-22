package iuniversity.model;
import java.util.*;

public class TeacherImpl extends AbstractUser implements Teacher{

    private int registrarionNumber;
    private TeacherState academicPosition;
    private Set<Course> courses;
    
    @Override
    public int getRegistrationNumber() {
        return this.registrarionNumber;
    }

    @Override
    public TeacherState getState() {
        return this.academicPosition;
    }

    @Override
    public String getCourses() {
        return Collections.unmodifiableSet(courses);
    }

}
