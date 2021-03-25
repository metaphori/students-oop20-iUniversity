package iuniversity.model.exams;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.Course;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;

public final class ExamCallImpl implements ExamCall {

    private static final int DAYS_BEFORE_CALL = 10;

    private Optional<Integer> maxStudents;
    private AcademicYear academicYear;
    private final Set<Student> registeredStudents;
    private LocalDateTime callStart;
    private final LocalDateTime registrationStart;
    private final LocalDateTime registrationEnd;
    private ExamType examType;
    private final Course course;
    private final boolean published;

    private ExamCallImpl(final Course course, final LocalDateTime callStart, final AcademicYear academicYear,
            final ExamType examType, final Optional<Integer> maxStudents) {
        this.course = course;
        this.setStart(callStart);
        this.academicYear = academicYear;
        this.examType = examType;
        this.maxStudents = maxStudents;
        this.registeredStudents = new HashSet<>();
        this.published = true;
        this.registrationStart = LocalDateTime.now();
        this.registrationEnd = callStart.minusDays(1);
    }

    @Override
    public Teacher getTeacher() {
        return null;
    }

    @Override
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    @Override
    public Set<Student> getRegisteredStudents() {
        return Collections.unmodifiableSet(this.registeredStudents);
    }

    @Override
    public LocalDateTime getStart() {
        return this.callStart;
    }

    @Override
    public ExamType getExamType() {
        return this.examType;
    }

    @Override
    public CallStatus getStatus() {
        final LocalDateTime now = LocalDateTime.now();
        return now.isAfter(registrationStart) && now.isBefore(registrationEnd) ? CallStatus.OPEN : CallStatus.CLOSED;
    }

    @Override
    public Course getCourse() {
        return this.course;
    }

    @Override
    public Optional<Integer> maxStudents() {
        return this.maxStudents;
    }

    @Override
    public void setStart(final LocalDateTime callStart) {
        if (LocalDateTime.now().isAfter(callStart.minusDays(DAYS_BEFORE_CALL))) {
            throw new IllegalStateException("No enough time for student to register");
        }
        this.callStart = callStart;
    }

    @Override
    public void setExamType(final ExamType examType) {
        this.examType = examType;
    }

    @Override
    public void registerStudent(final Student student) {
        this.registeredStudents.add(student);
    }

    @Override
    public void setMaximumStudents(final int maxStudents) {
        if (this.published && maxStudents < this.registeredStudents.size()) {
            throw new IllegalStateException("The maximum number can't be set lower to currently registered students");
        }
        this.maxStudents = Optional.of(maxStudents);
    }

    @Override
    public void setAcademicYear(final AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public static class ExamCallBuilderImpl implements ExamCallBuilder {

        private Optional<Integer> maximumStudents;
        private AcademicYear academicYear;
        private LocalDateTime start;
        private ExamType type;
        private Course course;

        public ExamCallBuilderImpl() {
            this.maximumStudents = Optional.empty();
        }

        @Override
        public final ExamCallBuilder academicYear(final AcademicYear academicYear) {
            this.academicYear = academicYear;
            return this;
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
            if (Objects.isNull(course) || Objects.isNull(start) || Objects.isNull(academicYear) || Objects.isNull(type)) {
                throw new IllegalStateException();
            }
            return new ExamCallImpl(course, start, academicYear, type, maximumStudents);
        }

    }

}
