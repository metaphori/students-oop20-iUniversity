package iuniversity.model.user;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import iuniversity.model.didactics.Course;
import iuniversity.model.user.User.Gender;

public class TeacherImpl extends AbstractUser implements Teacher, Serializable {

    private static final long serialVersionUID = 1L;
    private int registrationNumber;
    private Set<Course> courses;
    
    public TeacherImpl(String firstName, String lastName, String username, LocalDate dateOfBirth, Gender gender, 
            String address, int id, int registrationNumber, Set<Course> courses) {
        super(firstName, lastName, username, dateOfBirth, gender, address, id);
        this.registrationNumber = registrationNumber;
        this.courses = courses;
    }
    
    @Override
    public int getRegistrationNumber() {
        return this.registrationNumber;
    }

    @Override
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }
    
    @Override
    public String toString() {
        return  "[" + registrationNumber + "] " + super.toString();
    }
    
    public static class Builder{
        
        private String name;
        private String lastName;
        private String username;
        private LocalDate dateOfBirth;
        private Gender gender;
        private String address;
        private int id;
        private int registrationNumber;
        private Set<Course> courses;
        
        public Builder(String name, String lastName, int id, int registrationNumber) { 
            this.name = name;
            this.lastName = lastName;
            this.id = id;
            this.registrationNumber = registrationNumber;
        }
        
        public Builder username(String username) {
            this.username=username;
            return this;
        }
        
        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        
        public Builder gender(Gender gender) {
            this.gender=gender;
            return this;
        }
        
        public Builder address(String address) {
            this.address=address;
            return this;
        }
 
        public Builder courses(Set<Course> courses) {
            this.courses=new HashSet<>(courses);
            return this;
        }
        
        public TeacherImpl build() throws IllegalStateException{
            if (this.name == null || this.lastName == null || this.username == null || this.dateOfBirth == null || this.gender == null ||
                    this.address == null || this.courses == null ) {
                throw new IllegalStateException("");
            }
            return new TeacherImpl(this.name,this.lastName,this.username,this.dateOfBirth,this.gender,this.address,this.id,this.registrationNumber,this.courses);
        }
    }
}
