package Framework;

import java.io.IOException;
import java.io.InputStream;
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
        String filePath = "configs/"+configFile+".properties";
        InputStream inputStream;
        Properties newProps = new Properties();

        inputStream = Config.class.getClassLoader().getResourceAsStream(filePath);
        newProps.load(inputStream);
        props.put(configFile, newProps);
    }

    public static Object get(String configFile, String key) throws IOException {
        if (props.containsKey(configFile)) {
            return props.get(configFile).get(key);
        }
        readProperties(configFile);
        return get(configFile, key);
    }

}
