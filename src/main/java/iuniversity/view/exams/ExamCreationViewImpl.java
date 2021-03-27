package iuniversity.view.exams;

import java.util.List;
import java.util.Set;

import iuniversity.controller.ExamCreationController;
import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
import iuniversity.view.AbstractView;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;

public final class ExamCreationViewImpl extends AbstractView implements ExamCreationView {

    @FXML
    private ChoiceBox<AcademicYear> academicYearChoice;

    @FXML
    private ChoiceBox<Course> courseChoice;

    @FXML
    private ChoiceBox<ExamType> examTypeChoice;

    @FXML
    private DatePicker callDatePicker;

    @FXML
    private Spinner<Integer> maxStudentSpin;

    public ExamCreationViewImpl() {
        System.out.println(this.getController());
    }

    @FXML
    public void initialize() {
    }

    @Override
    public void init() {
        ((ExamCreationController) this.getController()).initializeChoices();
    }

    @Override
    public void setAcademicYearChoices(final List<AcademicYear> academicYears) {
        academicYears.stream().forEach(academicYearChoice.getItems()::add);
    }

    @Override
    public void setExamTypeChoices(final Set<ExamType> examTypes) {
        examTypes.stream().forEach(examTypeChoice.getItems()::add);
    }

    @Override
    public void setCourseChoices(final Set<Course> courses) {
        courses.stream().forEach(courseChoice.getItems()::add);
    }

}
