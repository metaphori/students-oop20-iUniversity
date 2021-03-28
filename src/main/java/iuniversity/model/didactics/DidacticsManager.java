package iuniversity.model.didactics;

import java.util.Set;

public interface DidacticsManager {

    Set<DegreeProgramme> getDegreeProgrammes();

    Set<Course> getCourse();
    
    AcademicYear currentAcademicYear();
    
    Set<AdmissionRequest> getAdmissionRequests();
}
