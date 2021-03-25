package iuniversity.view;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import iuniversity.controller.Controller;
import iuniversity.controller.LoginControllerImpl;
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
        }
    };

    public static void goToPage(final Stage stage, final Pages page) {
        final FXMLLoader loader = new FXMLLoader(
                ClassLoader.getSystemResource("layoutFX/" + page.getFXMLName() + ".fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        final FXView view = loader.getController();
        view.setStage(stage);
        view.setController(PAGE_CONTROLLERS.get(page));
        PAGE_CONTROLLERS.get(page).setView(view);
        stage.centerOnScreen();
        stage.show();

    }

}
