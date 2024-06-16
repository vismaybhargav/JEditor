package jeditor.components.editorview;

import javafx.scene.control.Tab;

import java.io.File;

public abstract class AbstractFileEditor extends Tab {
    private File file;

    public AbstractFileEditor(File file) {
        super(file.getName());
        this.file = file;
    }

    protected abstract void initializeContent();

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AbstractFileEditor afe)
            return file.equals(afe.getFile());
        return false;
    }
}
