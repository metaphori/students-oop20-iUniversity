package iuniversity.model.exams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.user.Student;

public class ExamCallImpl implements ExamCall {

    private static final int DAYS_BEFORE_CALL = 1;

    private Optional<Integer> maxStudents = Optional.empty();
    private List<Student> registeredStudents = new ArrayList<>();
    private LocalDate callStart;
    private LocalDate registrationStart;
    private LocalDate registrationEnd;
    private ExamType examType;
    private Course course;
    private StudentRegistrationStrategy registrationStrategy;

    /**
     * Should not be called.
     */
    public ExamCallImpl() {
        /**
         * It is functional for serialization.
         */
    }

    private ExamCallImpl(final Course course, final LocalDate callStart, final ExamType examType,
            final Optional<Integer> maxStudents, final StudentRegistrationStrategy registrationStrategy) {
        this.course = course;
        this.callStart = callStart;
        this.examType = examType;
        this.maxStudents = maxStudents;
        this.registeredStudents = new ArrayList<>();
        this.registrationStart = LocalDate.now();
        this.registrationEnd = callStart.minusDays(1);
        this.registrationStrategy = registrationStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Student> getRegisteredStudents() {
        return Set.copyOf(this.registeredStudents);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Student> getRegistrationList() {
        return Collections.unmodifiableList(this.registeredStudents);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getStart() {
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
        final LocalDate now = LocalDate.now();
        return (now.isAfter(registrationStart) || now.isEqual(registrationStart))
                && (now.isBefore(registrationEnd) || now.isEqual(registrationEnd)) ? CallStatus.OPEN
                        : CallStatus.CLOSED;
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
    public boolean isFull() {
        return this.maxStudents.isPresent() && registeredStudents.size() == this.maxStudents.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOpen() {
        return this.getStatus() == CallStatus.OPEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean registerStudent(final Student student) {
        if (isFull() || !isOpen()) {
            return false;
        }
        registrationStrategy.register(this.registeredStudents, student);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean withdrawStudent(final Student student) {
        if (!isOpen()) {
            return false;
        }
        this.registeredStudents.remove(student);
        return true;
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
        return callStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " | " + course + ", " + examType
                + ", aperto fino al " + registrationEnd.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static class Builder implements ExamCallBuilder {

        private Optional<Integer> maximumStudents;
        private LocalDate start;
        private ExamType type;
        private Course course;
        private StudentRegistrationStrategy registrationStrategy;

        public Builder() {
            this.maximumStudents = Optional.empty();
            registrationStrategy = new StudentRegistrationStrategyFactoryImpl().atTheEndOfList();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamCallBuilder callStart(final LocalDate callStart) {
            this.start = callStart;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamCallBuilder examType(final ExamType examType) {
            this.type = examType;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamCallBuilder course(final Course course) {
            this.course = course;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamCallBuilder maximumStudents(final int maximumStudents) {
            this.maximumStudents = Optional.ofNullable(maximumStudents);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamCallBuilder registrationStrategy(final StudentRegistrationStrategy strategy) {
            this.registrationStrategy = strategy;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExamCall build() {
            if (Objects.isNull(course) || Objects.isNull(start) || Objects.isNull(type)) {
                throw new IllegalStateException("Can't build an exam call, arguments missing");
            } else if (start.isBefore(LocalDate.now().plusDays(DAYS_BEFORE_CALL))) {
                throw new IllegalStateException("ExamCall must be at least " + DAYS_BEFORE_CALL + " days after today");
            }
            return new ExamCallImpl(course, start, type, maximumStudents, registrationStrategy);
        }

    }

}
