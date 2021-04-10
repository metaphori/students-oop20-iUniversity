package iuniversity.model.exams;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
import iuniversity.model.exams.ExamResult.ExamResultType;
import iuniversity.model.user.Student;

public final class ExamsManagerImpl implements ExamsManager {

    private final Set<ExamCall> examCalls;
    private final Set<ExamReport> examReports;

    public ExamsManagerImpl() {
        this.examCalls = new HashSet<>();
        this.examReports = new HashSet<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<ExamCall> getExamCalls() {
        return Collections.unmodifiableSet(examCalls);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<ExamReport> getExamReports() {
        return Collections.unmodifiableSet(examReports);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addExamCall(final LocalDate callStart, final Course course, final ExamType examType,
            final Integer maximumStudents) {
        addExamCall(new ExamCallImpl.Builder().callStart(callStart).course(course).examType(examType)
                .maximumStudents(maximumStudents).build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addExamReport(final Course course, final Student student, final ExamResult result,
            final LocalDate date) {
        addExamReport(new ExamReportImpl(course, student, result, date));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean alreadyReportedSuccess(final Student student, final Course course) {
        return this.getExamReports().stream().filter(e -> e.getResult().getResultType() == ExamResultType.SUCCEDED)
                .filter(e -> e.getStudent().equals(student))
                .anyMatch(e -> e.getCourse().equals(course));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean alreadyReportedSuccess(final ExamReport examReport) {
        return alreadyReportedSuccess(examReport.getStudent(), examReport.getCourse());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addExamReport(final ExamReport examReport) {
        if (alreadyReportedSuccess(examReport)) {
            throw new IllegalStateException("Student already have a successful report");
        }
        this.examReports.add(examReport);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean alreadyHeld(final ExamCall examCall) {
        return LocalDate.now().isAfter(examCall.getStart()) || LocalDate.now().isEqual(examCall.getStart());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeExamCall(final ExamCall examCall) {
        if (alreadyHeld(examCall)) {
            throw new IllegalStateException("Can't remove an exam call which has been already held");
        }
        examCalls.remove(examCall);
    }

    private void addExamCall(final ExamCall examCall) {
        examCalls.add(examCall);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean withdrawStudent(final ExamCall examCall, final Student student) {
        removeExamCall(examCall);
        final boolean result = examCall.withdrawStudent(student);
        addExamCall(examCall);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean registerStudent(final ExamCall examCall, final Student student) {
        removeExamCall(examCall);
        final boolean result = examCall.registerStudent(student);
        addExamCall(examCall);
        return result;
    }

}
