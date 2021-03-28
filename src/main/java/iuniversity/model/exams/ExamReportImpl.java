package iuniversity.model.exams;

import java.time.LocalDate;

import iuniversity.model.didactics.Course;
import iuniversity.model.user.Student;

public class ExamReportImpl implements ExamReport {

    private final Course course;
    private final Student student;
    private final ExamResult result;
    private final LocalDate date;

    public ExamReportImpl(final Course course, final Student student, final ExamResult result, final LocalDate date) {
        this.course = course;
        this.student = student;
        this.result = result;
        this.date = date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Course getCourse() {
        return this.course;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Student getStudent() {
        return this.student;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ExamResult getResult() {
        return this.result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getDate() {
        return this.date;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((course == null) ? 0 : course.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        result = prime * result + ((student == null) ? 0 : student.hashCode());
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExamReportImpl other = (ExamReportImpl) obj;
        if (course == null) {
            if (other.course != null) {
                return false;
            }
        } else if (!course.equals(other.course)) {
            return false;
        }
        if (date == null) {
            if (other.date != null) {
                return false;
            }
        } else if (!date.equals(other.date)) {
            return false;
        }
        if (result == null) {
            if (other.result != null) {
                return false;
            }
        } else if (!result.equals(other.result)) {
            return false;
        }
        if (student == null) {
            if (other.student != null) {
                return false;
            }
        } else if (!student.equals(other.student)) {
            return false;
        }
        return true;
    }

}
