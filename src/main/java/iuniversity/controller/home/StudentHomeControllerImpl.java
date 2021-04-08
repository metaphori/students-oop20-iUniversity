package iuniversity.controller.home;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import iuniversity.controller.AbstractController;
import iuniversity.model.exams.ExamCall;
import iuniversity.model.exams.ExamReport;
import iuniversity.model.exams.ExamResult.ExamResultType;
import iuniversity.model.user.Student;
import iuniversity.view.home.StudentHomeView;

public class StudentHomeControllerImpl extends AbstractController implements StudentHomeController {

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
    public void displayStudentInfo() {
        this.checkUser();
        final StudentHomeView view = (StudentHomeView) this.getView();
        view.setFirstName(getLoggedStudent().getName());
        view.setLastName(getLoggedStudent().getLastName());
        view.setRegistrationNumber(getLoggedStudent().getRegistrationNumber());
        view.setDegreeProgramme(getLoggedStudent().getDegreeProgramme().toString());
    }

    private Stream<ExamReport> getStudentExamReportStream() {
        return this.getModel().getExamManager().getExamReports().stream()
                .filter(e -> e.getStudent().equals(getLoggedStudent()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayStudentStatistics() {
        this.checkUser();
        final StudentHomeView view = (StudentHomeView) this.getView();
        view.setAcquiredCredits(
                getStudentExamReportStream().filter(e -> e.getResult().getResultType() == ExamResultType.SUCCEDED)
                        .mapToInt(e -> e.getCourse().getCFU()).sum());
        view.setHighestExamResult(getStudentExamReportStream().map(e -> e.getResult())
                .filter(e -> e.getResult().isPresent()).mapToInt(e -> e.getResult().get()).max().orElse(0));
        view.setLowestExamResult(getStudentExamReportStream().map(e -> e.getResult())
                .filter(e -> e.getResult().isPresent()).mapToInt(e -> e.getResult().get()).min().orElse(0));
        view.setMeanExamResult(getStudentExamReportStream().map(e -> e.getResult())
                .filter(e -> e.getResult().isPresent()).mapToDouble(e -> e.getResult().get()).average().orElse(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void withdrawStudent(final ExamCall examCall) {
        this.checkUser();
        this.getModel().getExamManager().withdrawStudent(examCall, getLoggedStudent());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayBookedExamCalls() {
        this.checkUser();
        ((StudentHomeView) this.getView()).setOpenBookedExamCalls(this.getModel().getExamManager().getExamCalls()
                .stream().filter(e -> e.getRegisteredStudents().contains(getLoggedStudent()))
                .collect(Collectors.toSet()));
    }

}
