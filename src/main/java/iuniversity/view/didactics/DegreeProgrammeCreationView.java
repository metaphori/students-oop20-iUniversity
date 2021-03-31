package iuniversity.view.didactics;

import java.util.List;

import iuniversity.model.didactics.Course;
import iuniversity.model.didactics.DegreeProgramme.DegreeType;

public interface DegreeProgrammeCreationView {
    
    void setDegreeTypeChoices(List<DegreeType> degreeTypes);
    
    void setCourseChoices(List<Course> course);
    
    void createDegreeProgramme();
}
