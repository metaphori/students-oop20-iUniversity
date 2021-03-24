package iuniversity.model;

import iuniversity.model.user.User;

public interface Model {

    User getLoggedUser();

    void setCurrentUser(User user);
}
