package iuniversity.controller.home;



import iuniversity.model.exams.ExamCall;

public interface TeacherHomeController {

    void displayTeacherInfo();

    void displayTeacherStatistics();

    void removeExamCall(ExamCall examCall);

    void displayOpenExamCalls();
}
