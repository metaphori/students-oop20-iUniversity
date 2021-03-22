package iuniversity.model.exams;

public enum ExamResultType {
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
     * The student passed the exam but refused the EvaluationGiven.
     */
    DECLINED;
}
