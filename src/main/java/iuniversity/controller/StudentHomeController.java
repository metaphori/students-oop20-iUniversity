package iuniversity.controller;

import iuniversity.model.exams.ExamCall;

public interface StudentHomeController {

    void displayStudentInfo();

    void displayStudentStatistics();

    void withdrawStudent(ExamCall examCall);
}
