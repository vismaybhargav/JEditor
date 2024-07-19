package jeditor.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import jeditor.components.ButtonBar;
import jeditor.components.TopMenu;
import jeditor.components.editorview.TabbedEditorPane;
import jeditor.components.explorer.FileExplorer;

public final class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initConfigs(primaryStage);
        BorderPane root = new BorderPane();

        root.setTop(TopMenu.INSTANCE);

        HBox sideBar = new HBox();
        sideBar.getChildren().addAll(ButtonBar.INSTANCE, FileExplorer.INSTANCE);
        HBox.setHgrow(FileExplorer.INSTANCE, Priority.ALWAYS);

        SplitPane componentPane = new SplitPane();
        componentPane.getItems().addAll(sideBar, TabbedEditorPane.INSTANCE);

        root.setCenter(componentPane);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initConfigs(Stage primaryStage) {
        primaryStage.setTitle("JEditor");
        primaryStage.setMinHeight(1080);
        primaryStage.setMinWidth(1920);
        primaryStage.setResizable(true);
    }
}
