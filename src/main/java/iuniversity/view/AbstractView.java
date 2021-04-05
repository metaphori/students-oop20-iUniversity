package iuniversity.view;

import iuniversity.controller.Controller;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public abstract class AbstractView implements FXView {

    private Stage stage;
    private Controller controller;

    /**
     * {@inheritDoc}
     */
    @Override
    public Stage getStage() {
        return this.stage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStage(final Stage stage) {
        this.stage = stage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Controller getController() {
        return this.controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setController(final Controller controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showErrorMessage(final String message) {
        new Alert(Alert.AlertType.ERROR, message).showAndWait();
    }

}
