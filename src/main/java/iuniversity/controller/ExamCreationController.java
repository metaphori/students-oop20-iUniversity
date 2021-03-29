package iuniversity.controller;

import java.time.LocalDateTime;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;

public interface ExamCreationController {

    void initializeChoices();

    void initializeAcademicYearChoices();

    void initializeExamTypeChoices();

    void initilizeCourseChoices();

    void publishExamCall(LocalDateTime callStart, AcademicYear academicYear, Course course, ExamType examType,
            Integer maximumStudents);

}
