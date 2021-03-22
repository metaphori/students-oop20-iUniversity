package iuniversity.model.exams;

import java.util.Optional;

public interface ExamResult {
    /**
     * 
     * @return The type of evaluation given to the student 
     */
    ExamResultType getResultType();

    /**
     * 
     * @return Whether the student passed the exam with honors
     */
    boolean cumLaude();

    /**
     * 
     * @return if provided, the numeric result of the exam 
     */
    Optional<Integer> getResult();
}
