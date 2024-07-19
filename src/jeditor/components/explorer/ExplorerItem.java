package jeditor.components.explorer;

import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import jeditor.util.FileUtils;
import jeditor.util.ImageUtil;
import jeditor.util.ResourceLoader;

import java.io.File;

/*
    A class extending from TreeItem that is used for each file in the file explorer/workspace
 */
public class ExplorerItem extends TreeItem<String> {
    private File file;
    private final boolean isDirectory;


    public ExplorerItem(File file) {
        super(file.getName());
        isDirectory = file.isDirectory();

        if(isDirectory) {
            setGraphic(new ImageView(ImageUtil.FOLDER_IMG));
        } else if(file.getName().endsWith(".zip")) {
            setGraphic(new ImageView(ImageUtil.ZIP_FILE_IMG));
        } else if(file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            setGraphic(new ImageView(ImageUtil.PIC_IMG));
        } else {
            setGraphic(new ImageView(ImageUtil.FILE_IMG));
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
                ? new ImageView(ImageUtil.OPEN_FOLDER_IMG)
                : new ImageView(ImageUtil.FOLDER_IMG));
    }
}
