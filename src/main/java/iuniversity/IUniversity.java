package iuniversity;

import iuniversity.view.PageSwitcher;
import iuniversity.view.Pages;
import javafx.application.Application;
import javafx.stage.Stage;

public class IUniversity extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public final void start(final Stage primaryStage) throws Exception {
        PageSwitcher.goToPage(primaryStage, Pages.LOGIN);
    }
}
