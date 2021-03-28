package iuniversity.model.user;

import java.util.Set;

import iuniversity.model.didactics.Course;

public interface Teacher extends User {

    int getRegistrationNumber();
    
    Set<Course> getCourses();
    
}
