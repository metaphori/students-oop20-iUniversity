package iuniversity.model.user;

public interface User {

    String getName();
    
    String getLastName();
    
    String getUsername();
    
    public enum Gender {
        MALE, FEMALE, UNSPECIFIED
    }
    
    public enum UserType{
        STUDENT, TEACHER, ADMIN
    }
}
