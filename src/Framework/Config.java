package Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public final class Config {
    private static HashMap<String, Properties> props = new HashMap<>();

    private Config() {
    }

    private static void readProperties(String configFile) throws IOException {
        FileInputStream file;
        String filePath = "configs/" +configFile+".properties";
        file = new FileInputStream(filePath);

        Properties newProps = new Properties();
        newProps.load(file);
        props.put(configFile, newProps);
    }

    public static String get(String configFile, String key) throws IOException {
        if (props.containsKey(configFile)) {
            return (String) props.get(configFile).get(key);
        }
        readProperties(configFile);
        return get(configFile, key);
    }

}
