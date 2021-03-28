package iuniversity.model.didactics;

import java.util.Collections;
import java.util.Set;

public class DidacticsManagerImpl implements DidacticsManager {

    private Set<DegreeProgramme> degreeProgrammes;
    private Set<Course> courses;
    private AcademicYear academicYear;
    private Set<AdmissionRequest> admissionRequests;
    
    public DidacticsManagerImpl(Set<DegreeProgramme> degreeProgrammes, Set<Course> courses,
            AcademicYear academicYear, Set<AdmissionRequest> admissionRequests) {
        this.degreeProgrammes = degreeProgrammes;
        this.courses = courses;
        this.academicYear = academicYear;
        this.admissionRequests = admissionRequests;
    }

    @Override
    public Set<DegreeProgramme> getDegreeProgrammes() {
        return Collections.unmodifiableSet(degreeProgrammes);
    }

    @Override
    public Set<Course> getCourse() {
        return Collections.unmodifiableSet(courses);
    }

    @Override
    public Set<AdmissionRequest> getAdmissionRequests() {
        return Collections.unmodifiableSet(admissionRequests);
    }
    
    @Override
    public AcademicYear currentAcademicYear() {
        return this.academicYear;
    }

}
