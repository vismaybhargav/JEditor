package jeditor.components.editorview;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import jeditor.util.FileUtils;

import java.io.File;

/*
    Class used to create a new instance of the editor inside a TabPane.
 */
public class EditorInstance extends Tab {
    private final String ID;
    private TextArea editorPane;
    private TextArea gutter;
    public File file;
    private boolean isTemp;

    public ImageView lowFileImg = new ImageView(
            getClass()
                    .getClassLoader()
                    .getResource("jeditor/resources/icons8-file-12.png")
                    .toString()
    );

    public String jbFontPath = getClass().getClassLoader().getResource("jeditor/resources/JetBrainsMonoNL-Regular.ttf").toString();

    public EditorInstance(File contents, boolean isTemp) {
        super(contents.getName());
        ID = contents.getName();
        file = contents;
        this.isTemp = isTemp;

        initialize(contents);
        setOnClosed(new EditorClosedHandler(this));
    }

    private void initialize(File contents) {
        setGraphic(lowFileImg);

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));

        // actual text area
        editorPane = new TextArea();
        HBox.setHgrow(editorPane, Priority.ALWAYS);
        VBox.setVgrow(editorPane, Priority.ALWAYS);

        // editor styling
        editorPane.setText(FileUtils.readTextAsLines(contents));
        editorPane.setFont(Font.loadFont(jbFontPath, 15));
        editorPane.setStyle("-fx-control-inner-background:rgb(43,43,44); -fx-text-fill:rgb(221,227,209)");

        initEditorPaneChangeListener();
        setupGutter();

        // add the gutter line numbers for current file
        for(int i = 1; i <= FileUtils.getLineCount(contents); i++){
            gutter.appendText(i + "\n");
        }

        // sync the scrolls of the gutter and editorPane to line up the line numbers
        gutter.setScrollTop(0);
        gutter.scrollTopProperty().bindBidirectional(editorPane.scrollTopProperty());

        // add to root
        HBox.setHgrow(editorPane, Priority.ALWAYS);
        root.getChildren().addAll(gutter, editorPane);

        // add to textbox
        setContent(root);
    }

    private void initEditorPaneChangeListener() {
        editorPane.textProperty().addListener((observable, oldValue, newValue) -> {
            /*
            This is a way to get the scroll position of the editorPane to not jitter when typing
            We get the scroll position of the gutter (binded to the editorPane) before changing the gutter text
            Then we change the gutter text, and then after reset the scroll pos back to normal

            This is a side-effect of using .appendText that scrolls down the editor all the way.
            */

            double scroll = gutter.getScrollTop(); // get the scroll position of the gutter

            String gutterText = "";
            for (int i = 1; i <= FileUtils.getLineCount(newValue); i++) {
                gutterText += i + "\n";
            }

            gutter.setText(gutterText);
            gutter.setScrollTop(scroll); // reset scroll position
        });
    }

    private void setupGutter() {
        // gutter (line number) setup
        gutter = new TextArea();
        gutter.setId("lnv");
        gutter.setPrefWidth(80);
        gutter.setEditable(false);
        gutter.setFont(Font.loadFont(jbFontPath, 15));
        gutter.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        gutter.setStyle("-fx-control-inner-background:rgb(43,43,44); -fx-text-fill:rgb(182,179,165)");
    }

    public String getID() {
        return ID;
    }

    public TextArea getEditorPane() {
        return editorPane;
    }

    public boolean equals(EditorInstance other) {
        return file.equals(other.file);
    }

    public void setIsTemp(boolean isTemp) {
        this.isTemp = isTemp;
    }

    public boolean isTemp() {
        return isTemp;
    }

    // Handles what we do once the user closes an editorInstance
    private class EditorClosedHandler implements EventHandler<Event> {
        EditorInstance instance;

        public EditorClosedHandler(EditorInstance instance) {
            this.instance = instance;
        }

        @Override
        public void handle(Event event) {
        }
    }
}