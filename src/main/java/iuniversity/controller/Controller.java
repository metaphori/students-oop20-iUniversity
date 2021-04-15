package iuniversity.controller;

import iuniversity.model.Model;
import iuniversity.view.View;

public interface Controller {

    View getView();

    void setView(View view);

    Model getModel();

    void setModel(Model model);

    void logout();

}
