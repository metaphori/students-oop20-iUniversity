package iuniversity.view;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import iuniversity.controller.Controller;
import iuniversity.controller.ExamCreationControllerImpl;
import iuniversity.controller.LoginControllerImpl;
import iuniversity.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class PageSwitcher {

    private PageSwitcher() {
    }

    private static final Map<Pages, Controller> PAGE_CONTROLLERS = new EnumMap<>(Pages.class) {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        {
            this.put(Pages.LOGIN, new LoginControllerImpl());
            this.put(Pages.CREATE_EXAM_CALL, new ExamCreationControllerImpl());
        }
    };

    public static void goToPage(final Stage stage, final Pages page, final Model model) {
        final FXMLLoader loader = new FXMLLoader(
                ClassLoader.getSystemResource("layoutFX/" + page.getFXMLName() + ".fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root));
        final FXView view = loader.getController();
        view.setStage(stage);
        view.setController(PAGE_CONTROLLERS.get(page));
        PAGE_CONTROLLERS.get(page).setView(view);
        PAGE_CONTROLLERS.get(page).setModel(model);
        view.start();
        stage.centerOnScreen();
        stage.sizeToScene();
        stage.show();

    }

}
