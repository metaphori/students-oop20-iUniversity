package iuniversity.view;

public enum Pages {
    /**
     * loginPage.
     */
    LOGIN("login"),
    /**
     * Student's home page.
     */
    STUDENT_HOME("student_homepage"),
    /**
     * Teacher's home page.
     */
    TEACHER_HOME("teacher_homepage"),
    /**
     * Exam call creation page.
     */
    CREATE_EXAM_CALL("create_exam_call"),
    /**
     * Student creation page.
     */
    ADD_STUDENT("add_student"),
    /**
     * Teacher creation page.
     */
    ADD_TEACHER("add_teacher"),
    /**
     * Course creation page.
     */
    ADD_COURSE("add_course"),
    /**
     * Degree programme creation page.
     */
    ADD_DEGREE_PROGRAMME("add_degreeProgramme"),
    /**
     * Admin home page.
     */
    ADMIN_HOME("admin_homepage");
    private final String fxmlName;

    Pages(final String name) {
        this.fxmlName = name;
    }

    public String getFXMLName() {
        return this.fxmlName;
    }
}
