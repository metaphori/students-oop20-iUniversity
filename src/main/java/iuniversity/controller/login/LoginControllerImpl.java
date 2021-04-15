package iuniversity.controller.login;

import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;

import iuniversity.controller.AbstractController;
import iuniversity.controller.AccountsManager;
import iuniversity.controller.AccountsManagerImpl;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;
import iuniversity.model.user.User.UserType;
import iuniversity.view.login.LoginView;

public class LoginControllerImpl extends AbstractController implements LoginController {

    private final AccountsManager accountManager = new AccountsManagerImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public void login(final String username, final String password) {
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
                this.getModel().setCurrentUser(teacher.get());
                ((LoginView) this.getView()).goToTeacherHomePage();
            }
            break;
        case STUDENT:
            final Optional<Student> student = this.getModel().getArchive()
                    .getStudentByRegistrationNumber(userType.get().getRight());
            if (student.isPresent()) {
                this.getModel().setCurrentUser(student.get());
                ((LoginView) this.getView()).goToStudentHomePage();
            }
            break;
        default:
            break;
        }

    }

}
