package iuniversity.model.exams;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;

public class ExamCallImpl implements ExamCall {

    private static final int DAYS_BEFORE_CALL = 2;

    private final Optional<Integer> maxStudents;
    private final Set<Student> registeredStudents;
    private final LocalDateTime callStart;
    private final LocalDateTime registrationStart;
    private final LocalDateTime registrationEnd;
    private final ExamType examType;
    private final Course course;

    public ExamCallImpl(final Course course, final LocalDateTime callStart, final ExamType examType,
            final Optional<Integer> maxStudents) {
        this.course = course;
        this.callStart = callStart;
        this.examType = examType;
        this.maxStudents = maxStudents;
        this.registeredStudents = new HashSet<>();
        this.registrationStart = LocalDateTime.now();
        this.registrationEnd = callStart.minusDays(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Teacher getTeacher() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Student> getRegisteredStudents() {
        return Collections.unmodifiableSet(this.registeredStudents);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime getStart() {
        return this.callStart;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExamType getExamType() {
        return this.examType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CallStatus getStatus() {
        final LocalDateTime now = LocalDateTime.now();
        return now.isAfter(registrationStart) && now.isBefore(registrationEnd) ? CallStatus.OPEN : CallStatus.CLOSED;
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
    public Optional<Integer> maxStudents() {
        return this.maxStudents;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerStudent(final Student student) {
        this.registeredStudents.add(student);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((callStart == null) ? 0 : callStart.hashCode());
        result = prime * result + ((course == null) ? 0 : course.hashCode());
        result = prime * result + ((examType == null) ? 0 : examType.hashCode());
        result = prime * result + ((maxStudents == null) ? 0 : maxStudents.hashCode());
        result = prime * result + ((registeredStudents == null) ? 0 : registeredStudents.hashCode());
        result = prime * result + ((registrationEnd == null) ? 0 : registrationEnd.hashCode());
        result = prime * result + ((registrationStart == null) ? 0 : registrationStart.hashCode());
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
        final ExamCallImpl other = (ExamCallImpl) obj;
        if (callStart == null) {
            if (other.callStart != null) {
                return false;
            }
        } else if (!callStart.equals(other.callStart)) {
            return false;
        }
        if (course == null) {
            if (other.course != null) {
                return false;
            }
        } else if (!course.equals(other.course)) {
            return false;
        }
        if (examType != other.examType) {
            return false;
        }
        if (maxStudents == null) {
            if (other.maxStudents != null) {
                return false;
            }
        } else if (!maxStudents.equals(other.maxStudents)) {
            return false;
        }
        if (registeredStudents == null) {
            if (other.registeredStudents != null) {
                return false;
            }
        } else if (!registeredStudents.equals(other.registeredStudents)) {
            return false;
        }
        if (registrationEnd == null) {
            if (other.registrationEnd != null) {
                return false;
            }
        } else if (!registrationEnd.equals(other.registrationEnd)) {
            return false;
        }
        if (registrationStart == null) {
            if (other.registrationStart != null) {
                return false;
            }
        } else if (!registrationStart.equals(other.registrationStart)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ExamCallImpl [maxStudents=" + maxStudents + ", registeredStudents=" + registeredStudents
                + ", callStart=" + callStart + ", registrationStart=" + registrationStart + ", registrationEnd="
                + registrationEnd + ", examType=" + examType + ", course=" + course + "]";
    }

    public static class Builder implements ExamCallBuilder {

        private Optional<Integer> maximumStudents;
        private LocalDateTime start;
        private ExamType type;
        private Course course;

        public Builder() {
            this.maximumStudents = Optional.empty();
        }

        @Override
        public final ExamCallBuilder callStart(final LocalDateTime callStart) {
            this.start = callStart;
            return this;
        }

        @Override
        public final ExamCallBuilder examType(final ExamType examType) {
            this.type = examType;
            return this;
        }

        @Override
        public final ExamCallBuilder course(final Course course) {
            this.course = course;
            return this;
        }

        @Override
        public final ExamCallBuilder maximumStudents(final int maximumStudents) {
            this.maximumStudents = Optional.of(maximumStudents);
            return this;
        }

        @Override
        public final ExamCall build() {
            if (Objects.isNull(course) || Objects.isNull(start) || Objects.isNull(type)) {
                throw new IllegalStateException();
            } else if (start.isBefore(LocalDateTime.now().plusDays(DAYS_BEFORE_CALL))) {
                throw new IllegalStateException("ExamCall must be at least " + DAYS_BEFORE_CALL + " days after today");
            }
            return new ExamCallImpl(course, start, type, maximumStudents);
        }

    }

}
