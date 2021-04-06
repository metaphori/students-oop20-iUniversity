package iuniversity.controller.exams;

import java.util.stream.Collectors;

import iuniversity.controller.AbstractController;
import iuniversity.model.user.Student;
import iuniversity.view.exams.BookletView;

public class BookletControllerImpl extends AbstractController implements BookletController {

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayReports() {
        if (!isUserLogged() && !isUserAStudent()) {
            throw new IllegalStateException("User must be a student");
        }

        ((BookletView) this.getView()).setReports(this.getModel().getExamManager().getExamReports().stream()
                .filter(r -> r.getStudent().equals((Student) this.getModel().getLoggedUser().get()))
                .collect(Collectors.toSet()));
    }

}
