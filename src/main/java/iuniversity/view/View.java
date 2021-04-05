package iuniversity.view;

import iuniversity.controller.Controller;

public interface View {

    Controller getController();

    void setController(Controller controller);

    void start();

    void showErrorMessage(String message);

}
