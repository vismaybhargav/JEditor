package jeditor.core;

import javafx.scene.paint.Color;
import jeditor.components.editorview.EditorInstance;

import java.util.ArrayList;

public class Data {
    public static ArrayList<EditorInstance> openEditorInstances = new ArrayList<>();
    // Editor Style
    public static Color editorBackground = Color.color(0.1, 0.1, 0.1);
}