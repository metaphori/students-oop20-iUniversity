package iuniversity.model.exams;

import iuniversity.model.didactics.Course;
import iuniversity.model.exams.ExamResult.ExamResultType;
import iuniversity.model.user.Student;

public interface ExamReportBuilder {

    ExamReportBuilder course(Course course);

    ExamReportBuilder student(Student student);

    ExamReportBuilder resultType(ExamResultType resultType);

    ExamReportBuilder result(int result);

    ExamReportBuilder laude(boolean laude);

    ExamReport build();
}
