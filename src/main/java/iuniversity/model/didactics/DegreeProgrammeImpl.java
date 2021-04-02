package iuniversity.model.didactics;

import java.util.Collections;
import java.util.Set;

public class DegreeProgrammeImpl implements DegreeProgramme {

    private String name;
    private DegreeType type;
    private Set<Course> courses;
    
    public DegreeProgrammeImpl(String name, DegreeType type, Set<Course> courses) {
        this.name = name;
        this.type = type;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public DegreeType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return name + "[" + type + "]";
    }

    @Override
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }
    
}
