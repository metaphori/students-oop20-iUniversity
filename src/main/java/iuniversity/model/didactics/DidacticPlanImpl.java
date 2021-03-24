package iuniversity.model.didactics;

import java.util.Collections;
import java.util.Set;

public class DidacticPlanImpl implements DidacticPlan {
    
    private String description;
    private Set<Course> courses;
    
    public DidacticPlanImpl(String description, Set<Course> courses) {
        this.description = description;
        this.courses = courses;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }
    
    

}
