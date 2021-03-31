package iuniversity.controller;

import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.didactics.DegreeProgramme.DegreeType;

public interface DegreeProgrammeCreationController {
    
    void createDegreeProgramme(String name, DegreeType type, Set<Course> course);
    
    void initializeChoices();
}
