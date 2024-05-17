package jeditor.util;

import java.util.Objects;

public class ResourceLoader {
    public static String loadResource(String path, Class<?> cls) {
        return Objects.requireNonNull(cls.getClassLoader().getResource("jeditor/resources/" + path)).toString();
    }
}
