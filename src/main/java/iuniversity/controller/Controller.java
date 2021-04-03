package iuniversity.controller;

import iuniversity.model.Model;
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

    void logout();

    DataStore getStorage();

}
