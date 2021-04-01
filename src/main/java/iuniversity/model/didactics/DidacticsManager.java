package iuniversity.model.didactics;

import java.util.Set;

public interface DidacticsManager {

    Set<DegreeProgramme> getDegreeProgrammes();

    Set<Course> getCourse();
    
    AcademicYear currentAcademicYear();
    
    void addCourse(Course course);
    
    void addDegreeProgramme(DegreeProgramme degreeProgramme);
    
    void removeCourse(Course course);
    
    void removeDegreeProgramme(DegreeProgramme degreeProgramme);
    
    void setCourses(Set<Course> courses);
    
    void setDegreeProgrammes(Set<DegreeProgramme> degreeProgramms);
}
