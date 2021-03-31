package iuniversity.view.login;

public interface LoginView {

    /**
     * Try to log user.
     * 
     * @param username user's username
     * @param password user's password
     */
    void login(String username, String password);

    /**
     * Manages incorrect credentials.
     */
    void incorrectCredentials();

    void goToAdminHomePage();

    void goToStudentHomePage();

    void goToTeacherHomePage();

}
