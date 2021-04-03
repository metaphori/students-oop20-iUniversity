package iuniversity.model.user;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import iuniversity.model.didactics.Course;

public class TeacherImpl extends AbstractUser implements Teacher, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int registrarionNumber;
    private Set<Course> courses;
    
    public TeacherImpl(String firstName, String lastName, String username, LocalDate dateOfBirth, Gender gender, 
            String address, int id, int registrarionNumber, Set<Course> courses) {
        super(firstName, lastName, username, dateOfBirth, gender, address, id);
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
