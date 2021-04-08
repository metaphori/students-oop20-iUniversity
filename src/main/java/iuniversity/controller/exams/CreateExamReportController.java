package iuniversity.controller.exams;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall;
import iuniversity.model.user.Student;
import iuniversity.model.exams.ExamResult.ExamResultType;

public interface CreateExamReportController {

    void displayExamCallChoices();

    void displayResultTypeChoices();

    void displayStudentChoices(ExamCall examCall);

    void createExamReport(Course course, Student student, ExamResultType resultType, int result, boolean cumLaude);

}
