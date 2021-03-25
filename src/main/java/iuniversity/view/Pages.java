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
    TEACHER_HOME("home_teacher");

    private final String fxmlName;

    Pages(final String name) {
        this.fxmlName = name;
    }

    public String getFXMLName() {
        return this.fxmlName;
    }
}
