package iuniversity.model.user;
import java.util.*;

public class TeacherImpl extends AbstractUser implements Teacher{

    private int registrarionNumber;
    private TeacherState academicPosition;
    private Set<Course> courses;
    
    public TeacherImpl(int registrarionNumber, TeacherState academicPosition, Set<Course> courses) {
        super();
        this.registrarionNumber = registrarionNumber;
        this.academicPosition = academicPosition;
        this.courses = courses;
    }

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
