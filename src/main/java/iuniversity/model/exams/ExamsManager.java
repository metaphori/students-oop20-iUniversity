package iuniversity.model.exams;

import java.time.LocalDate;
import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;
import iuniversity.model.user.Student;

public interface ExamsManager {

    Set<ExamCall> getExamCalls();

    Set<ExamReport> getExamReports();

    /**
     * Creates a new Exam call.
     * 
     * @param callStart       start date and time of the exam call
     * @param course          the course of the exam call
     * @param examType        the type of the exam call
     * @param maximumStudents the maximum number of students that can register to
     *                        the exam call
     */
    void addExamCall(LocalDate callStart, Course course, ExamType examType, Integer maximumStudents);

    /**
     * Add a student exam report for a particular course.
     * 
     * @param course
     * @param student
     * @param result
     * @param date
     */
    void addExamReport(Course course, Student student, ExamResult result, LocalDate date);

    void addExamReport(ExamReport examReport);

    void removeExamCall(ExamCall examCall);

    boolean withdrawStudent(ExamCall examCall, Student student);

    boolean registerStudent(ExamCall examCall, Student student);

    boolean alreadyHeld(ExamCall examCall);

    boolean alreadyReported(ExamReport examReport);

}
