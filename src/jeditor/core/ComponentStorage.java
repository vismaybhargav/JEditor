package jeditor.core;

import jeditor.components.editorview.TabbedEditorPane;

/**
 * This is just a storage where we hold references to things
 */
public class ComponentStorage {
    private static final TabbedEditorPane tabbedEditorPane = new TabbedEditorPane();

    public static TabbedEditorPane getTabbedEditorPane() {
        return tabbedEditorPane;
    }
}
