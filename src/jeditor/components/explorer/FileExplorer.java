package jeditor.components.explorer;

import javafx.scene.control.TreeView;

import java.io.File;

public class FileExplorer extends TreeView<String> {
    public FileExplorer() {
        super();
    }

    public static ExplorerItem buildFileTree(String filePath) {
        File rootFile = new File(filePath);
        ExplorerItem root = new ExplorerItem(rootFile);

        buildTree(root);
        return root;
    }

    private static void buildTree(ExplorerItem parentItem) {
        if (parentItem.isDirectory()) {
            File[] files = parentItem.getFile().listFiles();

            if (files != null) {
                for (File file : files) {
                    ExplorerItem item = new ExplorerItem(file);
                    item.expandedProperty().addListener(e -> item.updateExpandedGraphic());
                    parentItem.getChildren().add(item);
                    buildTree(item);
                }
            }
        }
    }
}
