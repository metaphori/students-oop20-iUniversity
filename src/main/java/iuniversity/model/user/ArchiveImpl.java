package iuniversity.model.user;

import java.util.Collections;
import java.util.Set;

public class ArchiveImpl implements Archive {

    private Set<Student> students;
    private Set<Teacher> teachers;
    private Admin admin;
    
    public ArchiveImpl(Set<Student> students, Set<Teacher> teachers, Admin admin) {
        this.students = students;
        this.teachers = teachers;
        this.admin = admin;
    }

    @Override
    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    @Override
    public Set<Teacher> getTeachers() {
        return Collections.unmodifiableSet(teachers);
    }

    @Override
    public Admin getAdmin() {
        return this.admin;
    }
    
}
