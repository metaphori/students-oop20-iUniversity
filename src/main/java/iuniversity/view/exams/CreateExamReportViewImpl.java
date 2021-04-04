package iuniversity.view.exams;

import java.util.Objects;
import java.util.Set;

import iuniversity.controller.CreateExamReportController;
import iuniversity.model.exams.ExamCall;
import iuniversity.model.user.Student;
import iuniversity.view.AbstractView;
import iuniversity.view.PageSwitcher;
import iuniversity.view.Pages;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import iuniversity.model.exams.ExamResult.ExamResultType;

public class CreateExamReportViewImpl extends AbstractView implements CreateExamReportView {

    private static final int MAX_RESULT = 30;

    @FXML
    private ChoiceBox<ExamCall> examCallChoice;

    @FXML
    private ChoiceBox<Student> studentChoice;

    @FXML
    private ChoiceBox<ExamResultType> resultTypeChoice;

    @FXML
    private Spinner<Integer> resultSpin;

    @FXML
    private CheckBox laudeCB;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button publishBtn;

    /**
     * {@inheritDoc}
     */
    @FXML
    public void initialize() {
        this.resultSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, MAX_RESULT));
        cancelBtn.setOnAction(e -> {
            PageSwitcher.goToPage(getStage(), Pages.TEACHER_HOME, getController().getModel());
        });
        examCallChoice.setOnAction(e -> {
            final ExamCall examCall = this.examCallChoice.getValue();
            if (!Objects.isNull(examCall)) {
                ((CreateExamReportController) this.getController()).displayStudentChoices(examCall);
                System.out.println(examCall);
            }
        });
        publishBtn.setOnAction(e -> {
            ((CreateExamReportController) this.getController()).createExamReport(examCallChoice.getValue().getCourse(),
                    studentChoice.getValue(), resultTypeChoice.getValue(), resultSpin.getValue(), laudeCB.isSelected());
            PageSwitcher.goToPage(getStage(), Pages.TEACHER_HOME, getController().getModel());
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        final CreateExamReportController controller = (CreateExamReportController) this.getController();
        controller.displayExamCallChoices();
        controller.displayResultTypeChoices();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setExamCallChoices(final Set<ExamCall> examCalls) {
        this.examCallChoice.getItems().clear();
        this.examCallChoice.getItems().addAll(examCalls);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStudentChoices(final Set<Student> students) {
        this.studentChoice.getItems().clear();
        this.studentChoice.getItems().addAll(students);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setExamResultTypeChoices(final Set<ExamResultType> examResultType) {
        this.resultTypeChoice.getItems().clear();
        this.resultTypeChoice.getItems().addAll(examResultType);
    }

}
