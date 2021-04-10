package iuniversity.controller;

import iuniversity.model.Model;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;
import iuniversity.storage.DataStore;
import iuniversity.view.View;

public interface Controller {

    View getView();

    void setView(View view);

    Model getModel();

    void setModel(Model model);

    boolean isUserLogged();

    boolean isUserATeacher();

    boolean isUserAStudent();

    Teacher getLoggedTeacher();

    Student getLoggedStudent();

    void logout();

    DataStore getStorage();

}
