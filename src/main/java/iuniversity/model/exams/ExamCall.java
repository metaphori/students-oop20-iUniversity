package iuniversity.model.exams;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.user.Student;

public interface ExamCall {

    /**
     * 
     * Status of a {@link ExamCall}.
     *
     */
    enum CallStatus {

        /*
         * Exam call is created but not visible to students.
         */
        // CREATED,
        /*
         * Exam call is created but and visible to students. Students can't register
         * yet.
         */
        // PUBLISHED,
        /**
         * Exam call is published and students can register to the call.
         */
        OPEN,
        /**
         * Exam call is published but students can't register no more.
         */
        CLOSED;
    }

    enum ExamType {
        ORAL("Orale"), WRITTEN("Scritto"), PRACTICAL("Pratico");

        private final String label;

        ExamType(final String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return this.label;
        }

    }

    /**
     * 
     * @return the ExamCall course
     */
    Course getCourse();

    /**
     * 
     * @return the set of student's that registered to the call
     */
    Set<Student> getRegisteredStudents();

    /**
     * 
     * @return the list of student based on the registration strategy
     */
    List<Student> getRegistrationList();

    /**
     * 
     * @return the start Date and time of the call
     */
    LocalDate getStart();

    /**
     * 
     * @return the {@link ExamType} of the call
     */
    ExamType getExamType();

    /**
     * 
     * @return the status of the call
     */
    CallStatus getStatus();

    /**
     * 
     * @return an optional with is filled with the maximum number of student that
     *         register to the call
     */
    Optional<Integer> maxStudents();

    /**
     * Add student to the Exam call list.
     * 
     * @param student
     */
    void registerStudent(Student student);

    void withdrawStudent(Student student);

}
