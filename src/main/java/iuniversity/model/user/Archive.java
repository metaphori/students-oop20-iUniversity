package iuniversity.model.user;

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
}
