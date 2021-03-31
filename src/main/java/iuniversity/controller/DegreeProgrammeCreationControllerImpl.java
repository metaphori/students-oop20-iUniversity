package iuniversity.controller;

import iuniversity.model.didactics.DegreeProgrammeImpl;
import iuniversity.view.didactics.DegreeProgrammeCreationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.didactics.DegreeProgramme.DegreeType;

public class DegreeProgrammeCreationControllerImpl extends AbstractController implements DegreeProgrammeCreationController {

    @Override
    public void createDegreeProgramme(String name, DegreeType type, Set<Course> courses) {
        this.getModel().getDidacticsManager().addDegreeProgramme(new DegreeProgrammeImpl(name, type, courses));
    }

    @Override
    public void initializeChoices() {
        List<Course> courses = new ArrayList<>(this.getModel().getDidacticsManager().getCourse());
        ((DegreeProgrammeCreationView) this.getView()).setDegreeTypeChoices(Arrays.asList(DegreeType.values()));
        ((DegreeProgrammeCreationView) this.getView()).setCourseChoices(courses);
    }

}
