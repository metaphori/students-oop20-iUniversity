package iuniversity.model.didactics;

import java.util.Set;

public interface DidacticsManager {

    Set<DegreeProgramme> getDegreeProgrammes();

    Set<Course> getCourse();
    
    Set<DidacticPlan> getDidacticPlan();
    
    AcademicYear currentAcademicYear();
    
    Set<AdmissionRequest> getAdmissionRequests();
}
