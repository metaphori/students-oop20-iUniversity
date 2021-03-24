package iuniversity.view;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import iuniversity.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AbstractView implements FXView {

    private Stage stage;
    private Controller controller;

    private final Map<Pages, String> fxmlPages = new EnumMap<>(View.Pages.class) {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        {
            this.put(Pages.LOGIN, "");
        }
    };

    @Override
    public final Stage getStage() {
        return this.stage;
    }

    @Override
    public final void setStage(final Stage stage) {
        this.stage = stage;
    }

    @Override
    public final Controller getController() {
        return this.controller;
    }

    @Override
    public final void setController(final Controller controller) {
        this.controller = controller;
    }

    private Parent loadFXML(final String name) {
        try {
            return FXMLLoader.load(ClassLoader.getSystemResource("/src/main/resources/layoutFX/" + name));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public final void goToPage(final Pages page, final Controller controller) {
        this.getStage().setScene(new Scene(loadFXML(fxmlPages.get(page))));
        this.setController(controller);
    }
}
