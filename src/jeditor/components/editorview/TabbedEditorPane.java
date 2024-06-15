package jeditor.components.editorview;

import javafx.scene.control.TabPane;
import jeditor.core.Model;

public class TabbedEditorPane extends TabPane {
    public static final TabbedEditorPane INSTANCE = new TabbedEditorPane();

    private TabbedEditorPane() {
        super();
    }

    public void addEditorInstance(EditorInstance editorInstance) {
        Model.openEditorInstances.add(editorInstance);
        getTabs().add(editorInstance);
    }

    public void removeEditorInstance(EditorInstance editorInstance) {
        Model.openEditorInstances.remove(editorInstance);
        getTabs().remove(editorInstance);
    }

    public void selectEditorInstance(EditorInstance editorInstance) {
        getSelectionModel().select(editorInstance);
    }
}
