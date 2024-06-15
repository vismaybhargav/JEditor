package jeditor.components.explorer;

import javafx.scene.control.TreeView;
import jeditor.components.editorview.EditorInstance;
import jeditor.components.editorview.TabbedEditorPane;
import jeditor.core.Model;

import java.io.File;

public class FileExplorer extends TreeView<String> {
    public static final FileExplorer INSTANCE = new FileExplorer();

    private FileExplorer() {
        super();
        setupMouseClickedActions();
    }

    private void setupMouseClickedActions() {
        setOnMouseClicked(event -> {
            if(event.getClickCount() != 2) return; // Only allow a double click
            ExplorerItem selectedItem = (ExplorerItem) getSelectionModel().getSelectedItem();

            if(selectedItem == null || selectedItem.isDirectory()) return; // Only allow non-null files

            EditorInstance editorInstance = new EditorInstance(selectedItem.getFile(), false);

            for(EditorInstance instance : Model.openEditorInstances) {
                if(editorInstance.equals(instance)) {
                    TabbedEditorPane.INSTANCE.selectEditorInstance(instance);
                    return;
                }
            }

            TabbedEditorPane.INSTANCE.addEditorInstance(editorInstance);
            TabbedEditorPane.INSTANCE.selectEditorInstance(editorInstance);
            Model.openEditorInstances.add(editorInstance);
        });
    }

    public ExplorerItem buildFileTree(String filePath) {
        File rootFile = new File(filePath);
        ExplorerItem root = new ExplorerItem(rootFile);

        buildTree(root);
        return root;
    }

    private void buildTree(ExplorerItem parentItem) {
        if (parentItem.isDirectory()) {
            File[] files = parentItem.getFile().listFiles();

            if (files != null) {
                for (File file : files) {
                    ExplorerItem item = new ExplorerItem(file);
                    item.expandedProperty().addListener(e -> item.updateExpandedGraphic());
                    parentItem.getChildren().add(item);
                    buildTree(item);
                }
            }
        }
    }
}
