package util;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    public static final Map<String, Object> data = new HashMap<>();

    public static void saveVariableOnSession(String key, Object objectValue) {
        data.put(key, objectValue);
    }

    public static <T> T getVariableOnSession(String key) {
        return (T) data.get(key);
    }

}
