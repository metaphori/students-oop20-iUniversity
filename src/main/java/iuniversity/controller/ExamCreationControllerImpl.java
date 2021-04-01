package iuniversity.controller;

import java.time.LocalDateTime;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
import iuniversity.view.exams.ExamCreationView;

public final class ExamCreationControllerImpl extends AbstractController implements ExamCreationController {

    @Override
    public void initializeChoices() {
        this.initializeExamTypeChoices();
        this.initilizeCourseChoices();
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

    @Override
    public void publishExamCall(final LocalDateTime callStart, final Course course,
            final ExamType examType, final int maximumStudents) {
        this.getModel().getExamManager().addExamCall(callStart, course, examType, maximumStudents);
    }
}
