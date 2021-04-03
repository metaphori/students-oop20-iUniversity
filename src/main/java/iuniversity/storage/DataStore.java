package iuniversity.storage;

import java.util.Collection;

import iuniversity.model.didactics.Course;
import iuniversity.model.didactics.DegreeProgramme;
import iuniversity.model.exams.ExamCall;
import iuniversity.model.exams.ExamReport;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;

public interface DataStore {

    void saveStudents(Collection<Student> students);

    Collection<Student> loadStudents();

    void saveTeachers(Collection<Teacher> teachers);

    Collection<Teacher> loadTeachers();

    void saveCourses(Collection<Course> courses);

    Collection<Course> loadCourses();

    void saveDegreeProgrammes(Collection<DegreeProgramme> degreeProgrammes);

    Collection<DegreeProgramme> loadDegreeProgrammes();

    void saveExamCalls(Collection<ExamCall> examCalls);

    Collection<ExamCall> loadExamCalls();

    void saveExamReports(Collection<ExamReport> examReports);

    Collection<ExamReport> loadExamReports();

}
