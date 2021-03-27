package iuniversity.model.exams;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
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
    public void addExamCall(final LocalDateTime callStart, final AcademicYear academicYear, final Course course,
            final ExamType examType, final Integer maximumStudents) {
        this.examCalls.add(new ExamCallImpl.Builder()
                .callStart(callStart)
                .academicYear(academicYear)
                .course(course)
                .examType(examType)
                .maximumStudents(maximumStudents)
                .build());
    }

    @Override
    public void addExamReport(final Course course, final Student student, final ExamResult result) {
        this.examReports.add(new ExamReportImpl(course, student, result));
    }

}
