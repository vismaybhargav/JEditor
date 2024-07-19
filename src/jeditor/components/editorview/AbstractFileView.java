package jeditor.components.editorview;

import javafx.scene.control.Tab;
import jeditor.core.Model;

import java.io.File;

public abstract class AbstractFileView extends Tab {
    private File file;

    public AbstractFileView(File file) {
        super(file.getName());
        this.file = file;
        setOnClosed(_ -> Model.openEditorInstances.remove(this));
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
        if(obj instanceof AbstractFileView afe)
            return file.equals(afe.getFile());
        return false;
    }
}
