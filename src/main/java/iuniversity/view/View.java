package iuniversity.view;

import iuniversity.controller.Controller;

public interface View {

    enum Pages {
        LOGIN, STUDENT_HOME, TEACHER_HOME
    }

    Controller getController();

    void setController(Controller controller);
    
    void goToPage(Pages page, Controller controller);

}
