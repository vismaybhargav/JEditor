package jeditor.components.editorview;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ImageViewer extends AbstractFileEditor  {
    Image image;
    ImageView imageViewPane;

    public ImageViewer(File file) {
        super(file);
        image = new Image(file.toURI().toString());
        imageViewPane = new ImageView(image);
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        setContent(imageViewPane);
    }
}
