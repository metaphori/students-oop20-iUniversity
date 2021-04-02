package iuniversity.view.exams;

import java.util.Set;

import iuniversity.model.exams.ExamCall;
import iuniversity.view.AbstractView;
import iuniversity.view.PageSwitcher;
import iuniversity.view.Pages;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ExamBookingViewImpl extends AbstractView implements ExamBookingView {

    @FXML
    private ListView<ExamCall> examCallList;

    @FXML
    private Button bookBtn;

    @FXML
    private Button cancelBtn;

    /**
     * {@inheritDoc}
     */
    @FXML
    public void initialize() {
        cancelBtn.setOnAction(e -> {
            PageSwitcher.goToPage(getStage(), Pages.STUDENT_HOME, getController().getModel());
        });
    }

    @Override
    public void start() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAvailableExamCalls(final Set<ExamCall> examCalls) {
        examCallList.getItems().clear();
        examCallList.getItems().addAll(examCalls);
    }

}
