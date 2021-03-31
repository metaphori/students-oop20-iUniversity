package iuniversity.model;

import java.util.Optional;

import iuniversity.model.didactics.DidacticsManager;
import iuniversity.model.exams.ExamsManager;
import iuniversity.model.user.Archive;
import iuniversity.model.user.User;

public interface Model {

    Optional<User> getLoggedUser();

    void setCurrentUser(User user);

    void unsetCurrentUser();

    ExamsManager getExamManager();

    DidacticsManager getDidacticsManager();

    Archive getArchive();
}
