package jeditor.core;

import jeditor.components.editorview.TabbedEditorPane;
import jeditor.components.explorer.FileExplorer;

/**
 * This is just a storage where we hold references to things
 */
public class ComponentStorage {
    private static final TabbedEditorPane tabbedEditorPane = new TabbedEditorPane();
    private static final FileExplorer explorer = new FileExplorer();

    public static TabbedEditorPane getTabbedEditorPane() {
        return tabbedEditorPane;
    }

    public static FileExplorer getExplorer() {
        return explorer;
    }
}
