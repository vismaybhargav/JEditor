package jeditor.components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import jeditor.components.editorview.EditorInstance;
import jeditor.components.editorview.TabbedEditorPane;
import jeditor.components.explorer.ExplorerItem;
import jeditor.components.explorer.FileExplorer;

import java.io.File;
import java.io.IOException;

public class TopMenu extends MenuBar {
    public static final TopMenu INSTANCE = new TopMenu();

    private TopMenu() {
        super();

        Menu fileMenu = new Menu("File");
        getMenus().add(fileMenu);

        MenuItem newFile = new MenuItem("New");
        MenuItem saveFile = new MenuItem("Save");

        MenuItem openFile = new MenuItem("Open");
        openFile.setOnAction(e -> openFileControl());

        MenuItem openFolder = new MenuItem("Open Folder");
        openFolder.setOnAction(e -> openFolderControl());

        fileMenu.getItems().addAll(newFile, saveFile, openFile, openFolder);
    }

    private void openFolderControl() {
        DirectoryChooser dc = new DirectoryChooser();
        File selectedDirectory = dc.showDialog(null);

        try {
            // build the file tree
            ExplorerItem root = FileExplorer.INSTANCE.buildFileTree(selectedDirectory.getCanonicalPath());

            // checking for if the directory has been expanded
            root.setExpanded(true);
            root.updateExpandedGraphic();
            root.expandedProperty().addListener(e -> root.updateExpandedGraphic());

            FileExplorer.INSTANCE.setRoot(root);
        } catch (IOException e) {
            System.out.println("error building file tree" + e.getMessage());
        }
    }

    private void openFileControl() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File requestedFile = fileChooser.showOpenDialog(null);
        if (requestedFile == null) return;
        TabbedEditorPane.INSTANCE.addEditorInstance(new EditorInstance(requestedFile, false));
    }
}
