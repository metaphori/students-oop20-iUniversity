package iuniversity.controller;

import java.io.File;

import iuniversity.model.Model;
import iuniversity.model.user.Student;
import iuniversity.model.user.Teacher;
import iuniversity.storage.DataStore;
import iuniversity.storage.io.FileDataStoreImpl;
import iuniversity.view.View;

public abstract class AbstractController implements Controller {

    private static final String PATH_SEPARATOR = System.getProperty("file.separator");
    private static final String STORAGE_PATH = System.getProperty("user.home") + PATH_SEPARATOR + ".iuniversity"
            + PATH_SEPARATOR;

    private View view;
    private Model model;
    private final DataStore storage = new FileDataStoreImpl();

    protected final String getFileStoragePath() {
        return STORAGE_PATH;
    }

    /**
     * Create a {@link File} pointing to the specified file in application folder.
     * 
     * @param fileName
     * @return the file
     */
    protected File createFile(final String fileName) {
        return new File(this.getFileStoragePath() + fileName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final View getView() {
        return this.view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setView(final View view) {
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Model getModel() {
        return this.model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setModel(final Model model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataStore getStorage() {
        return this.storage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isUserLogged() {
        return this.getModel().getLoggedUser().isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isUserATeacher() {
        return this.isUserLogged() && this.getModel().getLoggedUser().get() instanceof Teacher;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isUserAStudent() {
        return this.isUserLogged() && this.getModel().getLoggedUser().get() instanceof Student;
    }

    /**
     * @throws IllegalStateException is no user is logged or is not a teacher
     */
    protected void checkStudent() {
        if (!isUserAStudent()) {
            throw new IllegalStateException("A user must be logged and should be a student");
        }
    }

    /**
     * @throws IllegalStateException is no user is logged or is not a teacher
     */
    protected void checkTeacher() {
        if (!isUserATeacher()) {
            throw new IllegalStateException("A user must be logged and should be a teacher");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Teacher getLoggedTeacher() {
        return (Teacher) this.model.getLoggedUser().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Student getLoggedStudent() {
        return (Student) this.model.getLoggedUser().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void logout() {
        this.getModel().unsetCurrentUser();
    }
}
