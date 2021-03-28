package iuniversity.model.exams;

import java.time.LocalDateTime;
import java.util.Set;

import iuniversity.model.didactics.AcademicYear;
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
     * @param academicYear    the academic year to which the exam call refers to
     * @param course          the course of the exam call
     * @param examType        the type of the exam call
     * @param maximumStudents the maximum number of students that can register to
     *                        the exam call
     */
    void addExamCall(LocalDateTime callStart, AcademicYear academicYear, Course course, ExamType examType,
            Integer maximumStudents);

    /**
     * Add a student exam report for a particular course.
     * 
     * @param course
     * @param student
     * @param result
     */
    void addExamReport(Course course, Student student, ExamResult result);

}
