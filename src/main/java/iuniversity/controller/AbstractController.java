package iuniversity.controller;

import java.io.File;

import iuniversity.model.Model;
import iuniversity.view.View;

public abstract class AbstractController implements Controller {

    private static final String PATH_SEPARATOR = System.getProperty("file.separator");
    private static final String STORAGE_PATH = System.getProperty("user.home") + PATH_SEPARATOR + ".iuniversity"
            + PATH_SEPARATOR;

    private View view;
    private Model model;

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

    @Override
    public final View getView() {
        return this.view;
    }

    @Override
    public final void setView(final View view) {
        this.view = view;
    }

    @Override
    public final Model getModel() {
        return this.model;
    }

    @Override
    public final void setModel(final Model model) {
        this.model = model;
    }
}
