package iuniversity.model.user;

import iuniversity.model.didactics.AcademicYear;

public interface Student {

    int getRegistrationNumber();
    
    StudentState getState();
    
    DegreeProgramme getDegreeProgramme();
    
    AcademicYear getImmatriculationYear();
    
    DidacticPlan getDidacticPlan();
    
    void suspendCareer();
    
    void resumeCareer();
    
    public enum StudentState {
        ACTIVE, INACTIVE, COMPLETED
    }
    
}
