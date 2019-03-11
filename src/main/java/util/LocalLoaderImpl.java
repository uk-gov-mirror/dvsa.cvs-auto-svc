package util;

import exceptions.AutomationException;
import org.apache.commons.exec.environment.EnvironmentUtils;

import java.util.Properties;

public class LocalLoaderImpl implements Loader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";

    static {
        try {

            properties = new Properties();
            properties.load(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AutomationException("Could not load environment setup");
        }
    }

    public String getBasePathUrl() {
        return properties.getProperty("base.path.url");
    }

    public String getNoDataBasePathUrl() { return properties.getProperty("no.data.base.path.url"); }


    public String getMicrosoftonlineUrl() { return properties.getProperty("microsoftonline.url"); }

    public String getMicrosoftonlineUserName() { return properties.getProperty("microsoftonline.username"); }

    public String getMicrosoftonlinePass() { return properties.getProperty("microsoftonline.pass"); }

    public String getUsername() {
        return properties.getProperty("browserstack.username");
    }

    public String getPassword() {
        return properties.getProperty("browserstack.password");
    }


}
