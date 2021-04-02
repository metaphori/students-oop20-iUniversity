package iuniversity.model.didactics;

import java.util.Set;

public interface DegreeProgramme {

    String getName();
    
    DegreeType getType();
    
    Set<Course> getCourses();
    
    public enum DegreeType {
        BACHELOR, MASTER
    }
    
}
