package iuniversity.controller;

import java.util.stream.Collectors;

import iuniversity.model.exams.ExamCall;
import iuniversity.model.exams.ExamCall.CallStatus;
import iuniversity.model.user.Student;
import iuniversity.view.exams.ExamBookingView;

public class ExamBookingControllerImpl extends AbstractController implements ExamBookingController {

    private void checkUser() {
        if (!isUserLogged()) {
            throw new IllegalStateException("No user logged");
        } else if (!isUserAStudent()) {
            throw new IllegalStateException("User must be a student");
        }
    }

    private Student getLoggedStudent() {
        return (Student) this.getModel().getLoggedUser().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayAvailableExamCalls() {
        checkUser();
        ((ExamBookingView) this.getView()).setAvailableExamCalls(this.getModel().getExamManager().getExamCalls()
                .stream().filter(e -> !e.getRegisteredStudents().contains(getLoggedStudent()))
                .filter(e -> e.getStatus() == CallStatus.OPEN)
                .filter(e -> getLoggedStudent().getDegreeProgramme().getCourses().contains(e.getCourse()))
                .collect(Collectors.toSet()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bookExamCall(final ExamCall examCall) {
        checkUser();
        this.getModel().getExamManager().registerStudent(examCall, getLoggedStudent());
    }

}
