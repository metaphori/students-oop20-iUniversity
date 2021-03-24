package iuniversity.model.user;

import java.util.Set;

public interface Archive {

    Set<Student> getStudents();
    
    Set<Teacher> getTeachers();
    
    Admin getAdmin();
    
}
