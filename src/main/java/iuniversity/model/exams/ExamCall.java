package iuniversity.model.exams;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;

public interface ExamCall {

    /**
     * 
     * Status of a {@link ExamCall}.
     *
     */
    enum CallStatus {

        /**
         * Exam call is created but not visible to students.
         */
        CREATED,
        /**
         * Exam call is created but and visible to students. Students can't register
         * yet.
         */
        PUBLISHED,
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
        ORAL, WRITTEN, PRACTICAL;
    }

    Teacher getTeacher();

    AcademicYear getAcademicYear();

    Set<Student> getRegisteredStudents();

    LocalDateTime getStart();

    ExamType getExamType();

    CallStatus getStatus();

    Optional<Integer> maxStudents();

}
