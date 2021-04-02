package iuniversity.view.exams;

import java.util.Set;

import iuniversity.model.exams.ExamCall;

public interface ExamBookingView {

    void setAvailableExamCalls(Set<ExamCall> examCalls);

}
