package iuniversity.model.user;

public interface Teacher {

    int getRegistrationNumber();
    
    TeacherState getState();
    
    String getCourses();
    
    public enum TeacherState {
        ASSOCIATE, FULL, RESEARCHER
    }
    
}
