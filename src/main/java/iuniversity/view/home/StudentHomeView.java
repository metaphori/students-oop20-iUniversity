package iuniversity.view.home;

import java.util.Set;

import iuniversity.model.exams.ExamCall;

public interface StudentHomeView {

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setRegistrationNumber(int registrationNumber);

    void setDegreeProgramme(String degreeProgramme);

    void setAcquiredCredits(int acquiredCredits);

    void setMeanExamResult(double meanExamResult);

    void setHighestExamResult(int highestExamResult);

    void setLowestExamResult(int lowestExamResult);

    void setOpenBookedExamCalls(Set<ExamCall> examCalls);

}
