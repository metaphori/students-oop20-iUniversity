package iuniversity.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import com.password4j.Password;

public class LoginControllerImpl extends AbstractController implements LoginController {

    private static final String CHARSET = "UTF-8";
    /*
     * TODO Rettificare in un file di configurazione
     */
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD_HASH = "";
    private static final String TEACHER_USERNAME_PREFIX = "doc";
    private static final String STUDENT_USERNAME_PREFIX = "stu";

    private final Map<UserType, String> passwordFileMap = new HashMap<>() {
        /**
        * 
        */
        private static final long serialVersionUID = 1L;

        {
            this.put(UserType.TEACHER, "pass_teachers.txt");
            this.put(UserType.STUDENT, "pass_students.txt");
        }
    };

    private List<String> readUsersCredentials(final UserType userType) {
        try {
            return FileUtils.readLines(passwordFileMap.get(userType), CHARSET);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Optional<UserType> getUserTypeFromUsername(final String username) {
        final String prefix = username.split("\\.")[0]; 
        return prefix.equals(TEACHER_USERNAME_PREFIX) ? Optional.of(UserType.TEACHER) : 
            prefix.equals(STUDENT_USERNAME_PREFIX)  ? Optional.of(UserType.STUDENT) : Optional.empty();
    }

    private boolean checkPassword(final String password, final String hashedPassword) {
        return Password.check(password, hashedPassword).withBCrypt();
    }

    @Override
    public final void login(final String username, final String password) {
        if (username.equals(ADMIN_USERNAME) && checkPassword(password, ADMIN_PASSWORD_HASH)) {
            /*
             * Setta la pagina dell'admin
             */
        }
        final UserType userType = getUserTypeFromUsername(username);
        final Optional<Triple<String, String, String>> user = this
                .readUsersCredentials(userType).stream().map(l -> {
                    final var tokens = l.split(" +");
                    return Triple.of(tokens[0], tokens[1], tokens[2]);
                }).filter(t -> t.getMiddle().equals(username)).findFirst();

        if (user.isPresent() && checkPassword(password, user.get().getRight())) {
            // setta il current user e vai alla pagina
            return;
        }
    }

}
