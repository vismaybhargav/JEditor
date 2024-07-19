package jeditor.util;

import javafx.scene.image.Image;

import java.io.File;
import java.util.Objects;

public final class ResourceLoader {
    public static String loadResource(String path, Class<?> cls) {
        return Objects.requireNonNull(cls.getClassLoader().getResource(STR."jeditor/resources/\{path}")).toString();
    }

    public static Image loadImageFromFile(File file) {
        return new Image(file.toURI().toString());
    }
}
