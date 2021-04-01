package iuniversity.view.home;

import java.util.Set;

import iuniversity.model.exams.ExamCall;
import iuniversity.view.AbstractView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class TeacherHomeViewImpl extends AbstractView implements TeacherHomeView {

    @FXML
    private Label firstNameLbl;

    @FXML
    private Label lastNameLbl;

    @FXML
    private Label registrationNameLbl;

    @FXML
    private Label promotedStudentsLbl;

    @FXML
    private Label failedStudentsLbl;

    @FXML
    private Label withdrawnStudentsLbl;

    @FXML
    private Label cumLaudeStudentsLbl;

    @FXML
    private Label meanResultsLbl;

    @FXML
    private ListView<ExamCall> openExamCallList;

    @FXML
    private Button addExamResultBtn;

    @FXML
    private Button newExamCallBtn;

    @FXML
    private Button removeExamCallBtn;

    @FXML
    private Button logoutBtn;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFirstName(final String firstName) {
        firstNameLbl.setText(firstName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLastName(final String lastName) {
        lastNameLbl.setText(lastName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRegistrationNumber(final int registraionNumeber) {
        registrationNameLbl.setText(String.valueOf(registraionNumeber));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPromotedStudents(final int promotedStudents) {
        promotedStudentsLbl.setText(String.valueOf(promotedStudents));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFailedStudents(final int failedStudents) {
        failedStudentsLbl.setText(String.valueOf(failedStudents));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWithdrawnStudents(final int withdrawnStudents) {
        withdrawnStudentsLbl.setText(String.valueOf(withdrawnStudents));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCumLaudeStudents(final int cumLaudeStudents) {
        cumLaudeStudentsLbl.setText(String.valueOf(cumLaudeStudents));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMeanResults(final double meanResults) {
        meanResultsLbl.setText(String.valueOf(meanResults));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOpenExamCalls(final Set<ExamCall> examCalls) {
        this.openExamCallList.getItems().addAll(examCalls);
    }

    @Override
    public void start() {
    }

}
