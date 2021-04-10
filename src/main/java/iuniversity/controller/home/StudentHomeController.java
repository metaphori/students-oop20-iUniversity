package iuniversity.controller.home;


import iuniversity.model.exams.ExamCall;

public interface StudentHomeController {

    void displayStudentInfo();

    void displayStudentStatistics();

    void withdrawStudent(ExamCall examCall);

    void displayOpenBookedExamCalls();
}
