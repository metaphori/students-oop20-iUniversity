package iuniversity.model.exams;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.Course;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;

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
        //CREATED,
        /*
         * Exam call is created but and visible to students. Students can't register
         * yet.
         */
        //PUBLISHED,
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

    /**
     * 
     * @return the teacher's who published the call
     */
    Teacher getTeacher();

    /**
     * 
     * @return the ExamCall course
     */
    Course getCourse();

    /**
     * 
     * @return the Academic year to witch the call is referenced
     */
    AcademicYear getAcademicYear();

    /**
     * 
     * @return the set of student's that registered to the call
     */
    Set<Student> getRegisteredStudents();

    /**
     * 
     * @return the start Date and time of the call
     */
    LocalDateTime getStart();

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
     * Sets the Exam Call start.
     * 
     * @param callStart
     */
    void setStart(LocalDateTime callStart);

    /**
     * Sets the the Exam call type. See {@link ExamType}
     * 
     * @param examType
     */
    void setExamType(ExamType examType);

    /**
     * Add student to the Exam call list.
     * 
     * @param student
     */
    void registerStudent(Student student);

    /**
     * Sets the maximum number of students that can register to the exam call.
     * 
     * @param maxStudents
     */
    void setMaximumStudents(int maxStudents);

    /**
     * Set the academic year of the exam call.
     * 
     * @param academicYear
     */
    void setAcademicYear(AcademicYear academicYear);

}
