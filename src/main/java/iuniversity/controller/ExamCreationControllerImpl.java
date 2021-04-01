package iuniversity.controller;

import java.time.LocalDateTime;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
import iuniversity.model.user.Teacher;
import iuniversity.view.exams.ExamCreationView;

public class ExamCreationControllerImpl extends AbstractController implements ExamCreationController {

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeChoices() {
        this.initializeExamTypeChoices();
        this.initilizeCourseChoices();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeExamTypeChoices() {
        ((ExamCreationView) this.getView()).setExamTypeChoices(Set.of(ExamType.values()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initilizeCourseChoices() {
        if (this.isUserATeacher()) {
            ((ExamCreationView) this.getView())
                    .setCourseChoices(((Teacher) this.getModel().getLoggedUser().get()).getCourses());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publishExamCall(final LocalDateTime callStart, final Course course, final ExamType examType,
            final int maximumStudents) {
        this.getModel().getExamManager().addExamCall(callStart, course, examType, maximumStudents);
    }
}
