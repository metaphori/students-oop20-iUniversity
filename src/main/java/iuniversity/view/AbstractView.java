package iuniversity.view;

import iuniversity.controller.Controller;
import javafx.stage.Stage;

public abstract class AbstractView implements FXView {

    private Stage stage;
    private Controller controller;

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

}
