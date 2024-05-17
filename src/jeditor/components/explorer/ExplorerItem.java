package jeditor.components.explorer;

import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;

import java.io.File;

/*
    A class extending from TreeItem that is used for each file in the file explorer/workspace
 */
public class ExplorerItem extends TreeItem<String> {
    private File file;
    private final boolean isDirectory;

    public ImageView folderImg = new ImageView(
            getClass()
                    .getClassLoader()
                    .getResource("resources/icons8-folder-24.png")
                    .toString()
    );

    public ImageView openFolderImg = new ImageView(
            getClass()
                    .getClassLoader()
                    .getResource("resources/icons8-opened-folder-24.png")
                    .toString()
    );

    public ImageView zipFileImg = new ImageView(
            getClass()
                    .getClassLoader()
                    .getResource("resources/icons8-archive-folder-24.png")
                    .toString()
    );

    public ImageView picImg = new ImageView(
            getClass()
                    .getClassLoader()
                    .getResource("resources/icons8-picture-24.png")
                    .toString()
    );


    public ImageView fileImg = new ImageView(
            getClass()
                    .getClassLoader()
                    .getResource("resources/icons8-file-24.png")
                    .toString()
    );

    public ExplorerItem(File file) {
        super(file.getName());
        isDirectory = file.isDirectory();

        if(isDirectory) {
            setGraphic(folderImg);
        } else if(file.getName().endsWith(".zip")) {
            setGraphic(zipFileImg);
        } else if(file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            setGraphic(picImg);
        } else {
            setGraphic(fileImg);

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
                ? openFolderImg
                : folderImg);
    }
}
