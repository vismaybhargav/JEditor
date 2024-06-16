package jeditor.components.editorview;

import javafx.scene.control.TabPane;
import jeditor.core.Model;

public class TabbedEditorPane extends TabPane {
    public static final TabbedEditorPane INSTANCE = new TabbedEditorPane();

    private TabbedEditorPane() {
        super();
    }

    public void addEditorInstance(AbstractFileEditor fileEditor) {
        Model.openEditorInstances.add(fileEditor);
        getTabs().add(fileEditor);
    }

    public void removeEditorInstance(AbstractFileEditor fileEditor) {
        Model.openEditorInstances.remove(fileEditor);
        getTabs().remove(fileEditor);
    }

    public void selectEditorInstance(AbstractFileEditor fileEditor) {
        getSelectionModel().select(fileEditor);
    }
}
