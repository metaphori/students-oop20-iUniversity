package iuniversity.controller;



import iuniversity.model.exams.ExamCall;

public interface TeacherHomeController {

    void displayTeacherInfo();

    void displayTeacherStatistics();

    void removeExamCall(ExamCall examCall);

    void displayOpenExamCalls();
}
