package iuniversity.controller;

public interface LoginController {

    /**
     * Logs user.
     * @param username User's username.
     * @param password User's password.
     */
    void login(String username, String password);

}
