package iuniversity.controller;

import java.util.Optional;
import iuniversity.model.user.User.UserType;

import iuniversity.view.login.LoginView;

public class LoginControllerImpl extends AbstractController implements LoginController {

    private final AccountsManager accountManager = new AccountsManagerImpl();

    @Override
    public final void login(final String username, final String password) {
        final Optional<UserType> userType = accountManager.checkCredentials(username, password);
        if (userType.isEmpty()) {
            ((LoginView) this.getView()).incorrectCredentials();
            return;
        }

        switch (userType.get()) {
        case ADMIN:
            System.out.println("Admin");
            break;
        case TEACHER:
            System.out.println("Teacher");
            break;
        case STUDENT:
            System.out.println("Student");
            break;
        default:
            break;
        }

    }

}
