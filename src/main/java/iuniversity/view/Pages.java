package iuniversity.view;

public enum Pages {
    /**
     * loginPage.
     */
    LOGIN("login"),
    /**
     * Student's home page.
     */
    STUDENT_HOME("home_student"),
    /**
     * Teacher's home page.
     */
    TEACHER_HOME("home_teacher"),
    /**
     * Exam call creation page.
     */
    CREATE_EXAM_CALL("create_exam_call");

    private final String fxmlName;

    Pages(final String name) {
        this.fxmlName = name;
    }

    public String getFXMLName() {
        return this.fxmlName;
    }
}
