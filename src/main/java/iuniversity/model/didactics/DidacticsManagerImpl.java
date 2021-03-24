package iuniversity.model.didactics;

import java.util.Collections;
import java.util.Set;

public class DidacticsManagerImpl implements DidacticsManager {

    private Set<DegreeProgramme> degreeProgrammes;
    private Set<Course> courses;
    private Set<DidacticPlan> didacticPlan;
    private AcademicYear academicYear;
    private Set<AdmissionRequest> admissionRequests;
    
    public DidacticsManagerImpl(Set<DegreeProgramme> degreeProgrammes, Set<Course> courses,
            Set<DidacticPlan> didacticPlan, AcademicYear academicYear, Set<AdmissionRequest> admissionRequests) {
        this.degreeProgrammes = degreeProgrammes;
        this.courses = courses;
        this.didacticPlan = didacticPlan;
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
    public Set<DidacticPlan> getDidacticPlan() {
        return Collections.unmodifiableSet(didacticPlan);
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
