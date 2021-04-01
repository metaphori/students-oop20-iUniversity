package iuniversity.view.exams;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import iuniversity.controller.ExamCreationController;
import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
import iuniversity.view.AbstractView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public final class ExamCreationViewImpl extends AbstractView implements ExamCreationView {

    private static final int CUSTOM_CALL_START_HOUR = 9;

    @FXML
    private ChoiceBox<Course> courseChoice;

    @FXML
    private ChoiceBox<ExamType> examTypeChoice;

    @FXML
    private DatePicker callDatePicker;

    @FXML
    private Spinner<Integer> maxStudentSpin;

    @FXML
    private Button publishBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    public void initialize() {
        this.maxStudentSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE));
        this.publishBtn.setOnAction(e -> {
            ((ExamCreationController) this.getController()).publishExamCall(
                    LocalDateTime.of(callDatePicker.getValue(), LocalTime.of(CUSTOM_CALL_START_HOUR, 0)),
                    courseChoice.getValue(), examTypeChoice.getValue(), maxStudentSpin.getValue());
        });
    }

    @Override
    public void start() {
        ((ExamCreationController) this.getController()).initializeChoices();
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
