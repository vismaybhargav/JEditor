package jeditor.util;

import javafx.scene.image.Image;
import jeditor.components.explorer.ExplorerItem;

public final class ImageUtil {
    public static final Image FOLDER_IMG = new Image(ResourceLoader.loadResource("icons8-folder-24.png", ExplorerItem.class));
    public static final Image OPEN_FOLDER_IMG = new Image(ResourceLoader.loadResource("icons8-opened-folder-24.png", ExplorerItem.class));
    public static final Image ZIP_FILE_IMG = new Image(ResourceLoader.loadResource("icons8-archive-folder-24.png", ExplorerItem.class));
    public static final Image PIC_IMG = new Image(ResourceLoader.loadResource("icons8-picture-24.png", ExplorerItem.class));
    public static final Image FILE_IMG = new Image(ResourceLoader.loadResource("icons8-file-24.png", ExplorerItem.class));
}
