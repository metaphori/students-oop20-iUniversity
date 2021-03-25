package iuniversity.model.exams;

import iuniversity.model.didactics.Course;
import iuniversity.model.user.Student;

public final class ExamReportImpl implements ExamReport {

    private final Course course;

    private final Student student;

    private final ExamResult result;

    public ExamReportImpl(final Course course, final Student student, final ExamResult result) {
        this.course = course;
        this.student = student;
        this.result = result;
    }

    @Override
    public Course getCourse() {
        return this.course;
    }

    @Override
    public Student getStudent() {
        return this.student;
    }

    @Override
    public ExamResult getResult() {
        return this.result;
    }

}
