package jeditor.components;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import jeditor.util.ImageUtil;

public final class ButtonBar extends VBox {
    public static final ButtonBar INSTANCE = new ButtonBar();
    private ButtonBar() {
        super();

        Button fileExplorer = new Button();
        fileExplorer.setGraphic(new ImageView(ImageUtil.FOLDER_IMG));

        getChildren().add(fileExplorer);
    }
}
