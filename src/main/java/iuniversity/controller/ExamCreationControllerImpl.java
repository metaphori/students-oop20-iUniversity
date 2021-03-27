package iuniversity.controller;

import java.util.Collections;
import java.util.Set;

import iuniversity.model.exams.ExamCall.ExamType;
import iuniversity.model.user.Teacher;
import iuniversity.view.exams.ExamCreationView;

public final class ExamCreationControllerImpl extends AbstractController implements ExamCreationController {

    public ExamCreationControllerImpl() {
        // this.initializeChoices();
    }

    @Override
    public void initializeChoices() {
        this.initializeAcademicYearChoices();
        this.initializeExamTypeChoices();
        this.initilizeCourseChoices();
    }

    @Override
    public void initializeAcademicYearChoices() {
        ((ExamCreationView) this.getView()).setAcademicYearChoices(Collections.emptyList());
    }

    @Override
    public void initializeExamTypeChoices() {
        ((ExamCreationView) this.getView()).setExamTypeChoices(Set.of(ExamType.values()));
    }

    @Override
    public void initilizeCourseChoices() {
        // ((ExamCreationView) this.getView()).setCourseChoices(((Teacher)
        // this.getModel().getLoggedUser()).getCourses());
    }
}
