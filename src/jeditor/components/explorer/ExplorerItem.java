package jeditor.components.explorer;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeditor.util.ResourceLoader;

import java.io.File;

/*
    A class extending from TreeItem that is used for each file in the file explorer/workspace
 */
public class ExplorerItem extends TreeItem<String> {
    private File file;
    private final boolean isDirectory;
    private static final Image FOLDER_IMG = new Image(ResourceLoader.loadResource("icons8-folder-24.png", ExplorerItem.class));
    private static final Image OPEN_FOLDER_IMG = new Image(ResourceLoader.loadResource("icons8-opened-folder-24.png", ExplorerItem.class));
    private static final Image ZIP_FILE_IMG = new Image(ResourceLoader.loadResource("icons8-archive-folder-24.png", ExplorerItem.class));
    private static final Image PIC_IMG = new Image(ResourceLoader.loadResource("icons8-picture-24.png", ExplorerItem.class));
    private static final Image FILE_IMG = new Image(ResourceLoader.loadResource("icons8-file-24.png", ExplorerItem.class));

    public ExplorerItem(File file) {
        super(file.getName());
        isDirectory = file.isDirectory();

        if(isDirectory) {
            setGraphic(new ImageView(FOLDER_IMG));
        } else if(file.getName().endsWith(".zip")) {
            setGraphic(new ImageView(ZIP_FILE_IMG));
        } else if(file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            setGraphic(new ImageView(PIC_IMG));
        } else {
            setGraphic(new ImageView(FILE_IMG));
        }

        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void updateExpandedGraphic() {
        setGraphic(isExpanded()
                ? new ImageView(OPEN_FOLDER_IMG)
                : new ImageView(FOLDER_IMG));
    }
}
