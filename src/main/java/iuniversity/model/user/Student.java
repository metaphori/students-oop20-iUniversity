package iuniversity.model.user;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.DegreeProgramme;

public interface Student extends User {

    int getRegistrationNumber();
    
    StudentState getState();
    
    DegreeProgramme getDegreeProgramme();
    
    AcademicYear getImmatriculationYear();
    
    void suspendCareer();
    
    void resumeCareer();
    
    public enum StudentState {
        ACTIVE, INACTIVE, COMPLETED
    }
    
}
