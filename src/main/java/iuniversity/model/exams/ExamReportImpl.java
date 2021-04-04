package iuniversity.model.exams;

import java.time.LocalDate;
import java.util.Optional;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamResult.ExamResultType;
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

    public static class Builder implements ExamReportBuilder {

        private Optional<Course> course;
        private Optional<Student> student;
        private Optional<ExamResultType> resultType;
        private Optional<Integer> result;
        private boolean cumLaude;

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamReportBuilder course(final Course course) {
            this.course = Optional.of(course);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamReportBuilder student(final Student student) {
            this.student = Optional.of(student);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamReportBuilder resultType(final ExamResultType resultType) {
            this.resultType = Optional.of(resultType);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamReportBuilder result(final int result) {
            this.result = Optional.of(result);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamReportBuilder laude(final boolean laude) {
            if (laude) {
                resultType = Optional.empty();
                result = Optional.empty();
            }
            cumLaude = laude;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamReport build() {
            if (this.course.isEmpty() || this.student.isEmpty()) {
                throw new IllegalStateException("A student and a course must be provided");
            } else if (this.resultType.isEmpty() && !cumLaude) {
                throw new IllegalStateException("A result type should be provided");
            } else if (!cumLaude && this.resultType.get() != ExamResultType.WITHDRAWN && this.result.isEmpty()) {
                throw new IllegalStateException("A result should be provided");
            }
            final ExamResultFactory resultFactory = new ExamResultFactoryImpl();
            ExamResult examResult = null;
            if (cumLaude) {
                examResult = resultFactory.succeededCumLaude();
            } else {
                switch (this.resultType.get()) {
                case WITHDRAWN:
                    examResult = resultFactory.withdrawn();
                    break;
                case SUCCEDED:
                    examResult = resultFactory.succeded(this.result.get());
                    break;
                case FAILED:
                    examResult = resultFactory.failed(this.result.get());
                    break;
                case DECLINED:
                    examResult = resultFactory.declined(this.result.get());
                default:
                    break;
                }
            }
            return new ExamReportImpl(this.course.get(), student.get(), examResult, LocalDate.now());
        }
    }

}
