package iuniversity.model;

import iuniversity.model.exams.ExamsManager;
import iuniversity.model.exams.ExamsManagerImpl;
import iuniversity.model.user.User;

public class ModelImpl implements Model {

    private final ExamsManager examManager = new ExamsManagerImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public User getLoggedUser() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentUser(final User user) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExamsManager getExamManager() {
        return this.examManager;
    }

}
