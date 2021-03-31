package iuniversity.model.user;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.DegreeProgramme;

public interface Student extends User {

    int getRegistrationNumber();
    
    DegreeProgramme getDegreeProgramme();
    
}
