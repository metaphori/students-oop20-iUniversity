package iuniversity.controller;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import iuniversity.model.exams.ExamCall;
import iuniversity.model.exams.ExamCall.CallStatus;
import iuniversity.model.exams.ExamReport;
import iuniversity.model.exams.ExamResult.ExamResultType;
import iuniversity.model.user.Teacher;
import iuniversity.view.home.TeacherHomeView;

public class TeacherHomeControllerImpl extends AbstractController implements TeacherHomeController {

    private void checkUser() {
        if (!isUserLogged()) {
            throw new IllegalStateException("No user logged");
        } else if (!isUserATeacher()) {
            throw new IllegalStateException("User must be a teacher");
        }
    }

    private Teacher getLoggedTeacher() {
        return (Teacher) this.getModel().getLoggedUser().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayTeacherInfo() {
        this.checkUser();
        final Teacher teacher = getLoggedTeacher();
        final TeacherHomeView view = (TeacherHomeView) this.getView();
        view.setFirstName(teacher.getName());
        view.setLastName(teacher.getLastName());
        view.setRegistrationNumber(teacher.getRegistrationNumber());
    }

    private Stream<ExamReport> getTeacherExamReportStream() {
        return this.getModel().getExamManager().getExamReports().stream()
                .filter(e -> getLoggedTeacher().getCourses().contains(e.getCourse()));
    }

    private Stream<ExamReport> getTeacherExamReportStreamByResultType(final ExamResultType examResultType) {
        return getTeacherExamReportStream().filter(e -> e.getResult().getResultType() == examResultType);
    }

    private Stream<ExamCall> getTeacherExamCallsStream() {
        return this.getModel().getExamManager().getExamCalls().stream()
                .filter(e -> getLoggedTeacher().getCourses().contains(e.getCourse()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayTeacherStatistics() {
        this.checkUser();
        final TeacherHomeView view = (TeacherHomeView) this.getView();
        view.setPromotedStudents((int) getTeacherExamReportStreamByResultType(ExamResultType.SUCCEDED).count());
        view.setFailedStudents((int) getTeacherExamReportStreamByResultType(ExamResultType.FAILED).count());
        view.setWithdrawnStudents((int) getTeacherExamReportStreamByResultType(ExamResultType.WITHDRAWN).count());
        view.setCumLaudeStudents((int) getTeacherExamReportStreamByResultType(ExamResultType.SUCCEDED)
                .filter(e -> e.getResult().cumLaude()).count());
        view.setMeanResults(getTeacherExamReportStream().map(e -> e.getResult()).filter(r -> r.getResult().isPresent())
                .mapToDouble(r -> r.getResult().get()).average().orElse(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeExamCall(final ExamCall examCall) {
        this.getModel().getExamManager().removeExamCall(examCall);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayOpenExamCalls() {
        ((TeacherHomeView) this.getView()).setOpenExamCalls(
                getTeacherExamCallsStream().filter(e -> e.getStatus() == CallStatus.OPEN).collect(Collectors.toSet()));
    }

}
