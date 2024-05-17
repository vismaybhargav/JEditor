package jeditor.components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import jeditor.components.editorview.EditorInstance;
import jeditor.core.ComponentStorage;

import java.io.File;

public class TopMenu extends MenuBar {
    public TopMenu() {
        super();

        Menu fileMenu = new Menu("File");
        getMenus().add(fileMenu);
        MenuItem newFile = new MenuItem("New");
        MenuItem saveFile = new MenuItem("Save");
        MenuItem openFile = new MenuItem("Open");

        openFile.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File requestedFile = fileChooser.showOpenDialog(null);
            if(requestedFile == null) return;
            ComponentStorage.getTabbedEditorPane().addEditorInstance(new EditorInstance(requestedFile, false));
        });

        MenuItem openFolder = new MenuItem("Open Folder");
        fileMenu.getItems().addAll(newFile, saveFile, openFile, openFolder);
    }
}
