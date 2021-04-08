package iuniversity.view.exams;

import java.util.Set;

import iuniversity.model.exams.ExamCall;
import iuniversity.model.user.Student;
import iuniversity.model.exams.ExamResult.ExamResultType;

public interface CreateExamReportView {

    void setExamCallChoices(Set<ExamCall> examCalls);

    void setStudentChoices(Set<Student> students);

    void setExamResultTypeChoices(Set<ExamResultType> examResultType);
}
