package iuniversity.model.user;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.DegreeProgramme;
import iuniversity.model.didactics.DidacticPlan;

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
