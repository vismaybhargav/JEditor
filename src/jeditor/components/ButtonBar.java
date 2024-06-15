package jeditor.components;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class ButtonBar extends VBox {
    public static final ButtonBar INSTANCE = new ButtonBar();
    private ButtonBar() {
        super();

        Button workspace = new Button("W");
        getChildren().add(workspace);
    }
}
