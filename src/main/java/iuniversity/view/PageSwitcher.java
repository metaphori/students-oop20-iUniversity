package iuniversity.view;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import iuniversity.controller.Controller;
import iuniversity.controller.didactics.CourseCreationControllerImpl;
import iuniversity.controller.didactics.DegreeProgrammeCreationControllerImpl;
import iuniversity.controller.exams.CreateExamReportControllerImpl;
import iuniversity.controller.exams.ExamBookingControllerImpl;
import iuniversity.controller.exams.ExamCreationControllerImpl;
import iuniversity.controller.home.AdminHomeControllerImpl;
import iuniversity.controller.home.StudentHomeControllerImpl;
import iuniversity.controller.home.TeacherHomeControllerImpl;
import iuniversity.controller.login.LoginControllerImpl;
import iuniversity.controller.users.StudentCreationControllerImpl;
import iuniversity.controller.users.TeacherCreationControllerImpl;
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
            this.put(Pages.ADD_STUDENT, new StudentCreationControllerImpl());
            this.put(Pages.ADD_TEACHER, new TeacherCreationControllerImpl());
            this.put(Pages.ADD_COURSE, new CourseCreationControllerImpl());
            this.put(Pages.ADD_DEGREE_PROGRAMME, new DegreeProgrammeCreationControllerImpl());
            this.put(Pages.CREATE_EXAM_CALL, new ExamCreationControllerImpl());
            this.put(Pages.ADMIN_HOME, new AdminHomeControllerImpl());
            this.put(Pages.TEACHER_HOME, new TeacherHomeControllerImpl());
            this.put(Pages.STUDENT_HOME, new StudentHomeControllerImpl());
            this.put(Pages.BOOK_EXAM_CALL, new ExamBookingControllerImpl());
            this.put(Pages.CREATE_EXAM_REPORT, new CreateExamReportControllerImpl());
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
