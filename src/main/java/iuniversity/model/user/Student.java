package iuniversity.model.user;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.DegreeProgramme;
import iuniversity.model.didactics.DidacticPlan;

public interface Student extends User {

    int getRegistrationNumber();
    
    DegreeProgramme getDegreeProgramme();
    
    AcademicYear getImmatriculationYear();
    
}
