package iuniversity.view.exams;

import java.util.List;
import java.util.Set;

import iuniversity.model.didactics.AcademicYear;
import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamCall.ExamType;

public interface ExamCreationView {

    void setAcademicYearChoices(List<AcademicYear> academicYears);

    void setExamTypeChoices(Set<ExamType> examTypes);

    void setCourseChoices(Set<Course> courses);

}
