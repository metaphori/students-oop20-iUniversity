package iuniversity.controller;

import java.util.Optional;

import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;
import iuniversity.model.user.User.UserType;

public interface AccountsManager {

    /**
     * 
     * @param username
     * @param password
     * @return an optional with the type of user logged
     */
    Optional<UserType> checkCredentials(String username, String password);
    /**
     * Stores the student credentials.
     * @param student
     * @param password
     */
    void registerStudentAccount(Student student, String password);
    /**
     * Stores the teacher credentials.
     * @param teacher
     * @param password
     */
    void registerTeacherAccount(Teacher teacher, String password);

}
