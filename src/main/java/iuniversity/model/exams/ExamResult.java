package iuniversity.model.exams;

import java.util.Optional;

public interface ExamResult {

    /**
     * The result type of an {@link ExamResult}.
     *
     */
    enum ExamResultType {
        /**
         * The exam is passed.
         */
        SUCCEDED,
        /**
         * The student did not complete the exam.
         */
        WITHDRAWN,
        /**
         * The student failed in succeeding the exam.
         */
        FAILED,
        /**
         * The student passed the exam but refused the Evaluation given.
         */
        DECLINED;
    }

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
