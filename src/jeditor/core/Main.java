package jeditor.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jeditor.components.ButtonBar;
import jeditor.components.TopMenu;
import jeditor.components.explorer.FileExplorer;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initConfigs(primaryStage);
        BorderPane root = new BorderPane();

        root.setTop(new TopMenu());

        HBox sideBar = new HBox();
        sideBar.getChildren().addAll(new ButtonBar(), new FileExplorer());
        root.setLeft(sideBar);

        root.setCenter(ComponentStorage.getTabbedEditorPane());

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
