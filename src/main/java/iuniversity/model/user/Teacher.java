package iuniversity.model.user;

import java.util.Set;

import iuniversity.model.didactics.Course;

public interface Teacher extends User {

    int getRegistrationNumber();
    
    TeacherState getState();
    
    Set<Course> getCourses();
    
    public enum TeacherState {
        ASSOCIATE, FULL, RESEARCHER
    }
    
}
