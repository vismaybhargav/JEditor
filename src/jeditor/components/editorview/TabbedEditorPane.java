package jeditor.components.editorview;

import javafx.scene.control.TabPane;
import jeditor.core.Data;

public class TabbedEditorPane extends TabPane {
    public TabbedEditorPane() {
        super();
    }

    public void addEditorInstance(EditorInstance editorInstance) {
        Data.openEditorInstances.add(editorInstance);
        getTabs().add(editorInstance);
    }

    public void removeEditorInstance(EditorInstance editorInstance) {
        Data.openEditorInstances.remove(editorInstance);
        getTabs().remove(editorInstance);
    }
}
