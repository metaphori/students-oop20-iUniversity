package iuniversity.model.user;

import java.util.Optional;
import java.util.Set;

public interface Archive {

    Set<Student> getStudents();
    
    Set<Teacher> getTeachers();
    
    Admin getAdmin();
    
    void addStudent(Student student);
    
    void addTeacher(Teacher teacher);
    
    void setStudents(Set<Student> students);
    
    void setTeachers(Set<Teacher> teachers);
    
    void removeStudent(Student student);
    
    void removeTeacher(Teacher teacher);
    
    int getNewStudentRegistrationNumber();
    
    int getNewTeacherRegistrationNumber();
    
    int getNewUserId();
    
    /**
     * 
     * @param registrationNumber
     * @return the teacher with the specified registration number
     */
    Optional<Teacher> getTeacherByRegistrationNumber(int registrationNumber);

    /**
     * 
     * @param registrationNumber
     * @return the student with the specified registration number
     */
    Optional<Student> getStudentByRegistrationNumber(int registrationNumber);
}
