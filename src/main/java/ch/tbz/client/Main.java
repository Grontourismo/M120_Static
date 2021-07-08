package ch.tbz.client;

import ch.tbz.client.backend.util.DataProperties;
import ch.tbz.client.frontend.UIManager;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public void load() {
        UIManager.close();
        UIManager.home();
    }

    @Override
    public void start(Stage primaryStage) {
        DataProperties.loadData();
        primaryStage.show();
        UIManager.primaryStage = primaryStage;
        UIManager.secondaryStage = new Stage();
        UIManager.secondaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                load();
            }
        });
        UIManager.secondaryStage.initOwner(UIManager.primaryStage);
        UIManager.secondaryStage.initModality(Modality.APPLICATION_MODAL);

        UIManager.login();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
