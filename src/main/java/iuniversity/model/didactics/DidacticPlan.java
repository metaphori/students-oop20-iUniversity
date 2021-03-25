package iuniversity.model.didactics;

import java.util.Set;

public interface DidacticPlan {

    String getDescription();
    
    Set<Course> getCourses();
    
}
