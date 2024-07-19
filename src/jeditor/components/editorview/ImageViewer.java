package jeditor.components.editorview;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeditor.util.ResourceLoader;

import java.io.File;

public class ImageViewer extends AbstractFileView {
    Image image;
    ImageView imageViewPane;

    public ImageViewer(File file) {
        super(file);
        image = ResourceLoader.loadImageFromFile(file);
        imageViewPane = new ImageView(image);
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        setContent(imageViewPane);
    }
}
