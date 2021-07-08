package ch.tbz.client.backend.util;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {
    private static boolean isDarkmode;
    private static Properties properties = new Properties();

    public static void loadData() {
        try {
            properties.load(new FileReader("src/main/java/ch/tbz/client/backend/data/data.properties"));
        } catch (IOException ignored) {}
        isDarkmode = Boolean.parseBoolean(properties.getProperty("isDarkmode"));
        //isFullscreen = Boolean.parseBoolean(properties.getProperty("isFullscreen"));
    }

    public static boolean isDarkmode() {
        return isDarkmode;
    }

    /*public static boolean isFullscreen() {
        return isFullscreen;
    }*/

    public static void setIsDarkmode(boolean isDarkmode) {
        DataProperties.isDarkmode = isDarkmode;
        saveData();
    }

    /*public static void setIsFullscreen(boolean isFullscreen) {
        DataProperties.isFullscreen = isFullscreen;
        saveData();
    }*/

    public static void saveData(){
        properties.setProperty("isDarkmode", String.valueOf(isDarkmode));
        try {
            properties.store(new FileOutputStream("src/main/java/ch/tbz/client/backend/data/data.properties"), null);
        } catch (IOException ignored) {}
    }
}
