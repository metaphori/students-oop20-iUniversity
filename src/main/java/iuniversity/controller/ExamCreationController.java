package iuniversity.controller;

import java.time.LocalDateTime;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;

public interface ExamCreationController {

    void initializeChoices();

    void initializeExamTypeChoices();

    void initilizeCourseChoices();

    void publishExamCall(LocalDateTime callStart, Course course, ExamType examType,
            int maximumStudents);

}
