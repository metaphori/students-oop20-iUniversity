package iuniversity.model;

public interface User {

    String getName();
    
    String getLastName();
    
    String getUsername();
    
    public enum Gender {
        MALE, FEMALE, UNSPECIFIED
    }
}
