package iuniversity.controller.exams;

import java.time.LocalDate;
import java.util.Set;

import iuniversity.controller.AbstractController;
import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
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
        checkTeacher();
        ((ExamCreationView) this.getView()).setCourseChoices(getLoggedTeacher().getCourses());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publishExamCall(final LocalDate callStart, final Course course, final ExamType examType,
            final int maximumStudents) {
        this.getModel().getExamManager().addExamCall(callStart, course, examType, maximumStudents);
    }
}
