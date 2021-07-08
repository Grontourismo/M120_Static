package ch.tbz.client.frontend;

import ch.tbz.client.Data;
import ch.tbz.client.Main;
import ch.tbz.client.backend.data.Friend;
import ch.tbz.client.backend.data.Group;
import ch.tbz.client.backend.util.DataProperties;
import ch.tbz.client.frontend.controller.ControllerBase;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class UIManager {
    public static Stage primaryStage;
    public static Stage secondaryStage;

    private static ControllerBase loadScene(Stage stage, String path, String title, boolean maximised) {
        FXMLLoader loader = new FXMLLoader(Main.class.getClassLoader().getResource(path));
        try {
            Parent root = loader.load();
            stage.setTitle(title);

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            primaryStage.setX(bounds.getMinX());
            primaryStage.setY(bounds.getMinY());
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());

            Scene scene = new Scene(root);
            if (DataProperties.isDarkmode()){
                scene.getStylesheets().add("darkmode.css");
            }
            stage.setScene(scene);
            stage.show();
        }catch (IOException ignored){}
        return loader.getController();
    }

    public static void login(){
        loadScene(primaryStage, "views/login.fxml", "Login", false);
    }

    public static void register(){
        loadScene(primaryStage, "views/register.fxml", "Register", false);
    }

    public static void home(){
        loadScene(primaryStage, "views/home.fxml", "Home", true).init(Data.user);
    }

    public static void home(Friend friend){
        loadScene(primaryStage, "views/home.fxml", "Home", true).init(Data.user, friend);
    }

    public static void home(Group group){
        loadScene(primaryStage, "views/home.fxml", "Home", true).init(Data.user, group);
    }

    public static void addFriend(){
        loadScene(secondaryStage, "views/addFriends.fxml", "Add Friends", false).init();
    }

    public static void settings(){
        loadScene(secondaryStage, "views/menu.fxml", "Menu", false).init();
    }

    public static void addGroup(){
        loadScene(secondaryStage, "views/newGroupchat.fxml", "Add Groupchat", false);
    }

    public static void close() {
        primaryStage.close();
        secondaryStage.close();
    }

    public static void closeSecondary(){
        secondaryStage.close();
    }
}
