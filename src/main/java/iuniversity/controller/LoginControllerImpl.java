package iuniversity.controller;

import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;

import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;
import iuniversity.model.user.User.UserType;
import iuniversity.view.login.LoginView;

public class LoginControllerImpl extends AbstractController implements LoginController {

    private final AccountsManager accountManager = new AccountsManagerImpl();

    @Override
    public final void login(final String username, final String password) {
        final Optional<Pair<UserType, Integer>> userType = accountManager.checkCredentials(username, password);
        if (userType.isEmpty()) {
            ((LoginView) this.getView()).incorrectCredentials();
            return;
        }

        switch (userType.get().getLeft()) {
        case ADMIN:
            ((LoginView) this.getView()).goToAdminHomePage();
            this.getModel().setCurrentUser(this.getModel().getArchive().getAdmin());
            break;
        case TEACHER:
            final Optional<Teacher> teacher = this.getModel().getArchive()
                    .getTeacherByRegistrationNumber(userType.get().getRight());
            if (teacher.isPresent()) {
                ((LoginView) this.getView()).goToTeacherHomePage();
                this.getModel().setCurrentUser(teacher.get());
            }
            break;
        case STUDENT:
            final Optional<Student> student = this.getModel().getArchive()
                    .getStudentByRegistrationNumber(userType.get().getRight());
            if (student.isPresent()) {
                ((LoginView) this.getView()).goToStudentHomePage();
                this.getModel().setCurrentUser(student.get());
            }
            break;
        default:
            break;
        }

    }

}
