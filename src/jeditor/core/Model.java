package jeditor.core;

import javafx.scene.paint.Color;
import jeditor.components.editorview.AbstractFileView;

import java.util.ArrayList;

public final class Model {
    public static final ArrayList<AbstractFileView> openEditorInstances = new ArrayList<>();
    // Editor Style
    public static Color editorBackground = Color.color(0.1, 0.1, 0.1);
}
