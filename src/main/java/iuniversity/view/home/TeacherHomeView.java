package iuniversity.view.home;

import java.util.Set;

import iuniversity.model.exams.ExamCall;

public interface TeacherHomeView {

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setRegistrationNumber(int registrationNumber);

    void setPromotedStudents(int promotedStudents);

    void setFailedStudents(int failedStudents);

    void setWithdrawnStudents(int withdrawnStudents);

    void setCumLaudeStudents(int cumLaudeStudents);

    void setMeanResults(double meanResults);

    void setOpenExamCalls(Set<ExamCall> examCalls);

}
