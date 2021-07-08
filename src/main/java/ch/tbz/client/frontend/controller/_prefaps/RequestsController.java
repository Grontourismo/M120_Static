package ch.tbz.client.frontend.controller._prefaps;

import ch.tbz.client.Data;
import ch.tbz.client.backend.data.Friend;
import ch.tbz.client.frontend.controller.ControllerBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RequestsController extends ControllerBase {
    public VBox friendRequestVbox;

    public void init(){
        friendRequestVbox.getChildren().clear();
        for (Friend friend : Data.user.getFriends()) {
            if (friend.getState().equals("received")) {
                try {
                    FXMLLoader loader = new FXMLLoader(FriendRequestController.class.getClassLoader().getResource("views/_prefaps/friendRequest.fxml"));
                    Parent root = loader.load();
                    FriendRequestController controller = loader.getController();
                    controller.init(friend, this);
                    friendRequestVbox.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
