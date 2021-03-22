package iuniversity.model.exams;

/**
 * 
 * Status of a {@link ExamCall}. An ExamCall as to be considered.
 *
 */
public enum CallStatus {

    /**
     * Exam call is created but not visible to students.
     */
    CREATED,
    /**
     * Exam call is created but and visible to students. Students can't register yet.
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
