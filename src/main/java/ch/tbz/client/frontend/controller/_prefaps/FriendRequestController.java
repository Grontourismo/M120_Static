package ch.tbz.client.frontend.controller._prefaps;

import ch.tbz.client.backend.data.Friend;
import ch.tbz.client.frontend.UIManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class FriendRequestController {
    public Label usernameLabel;
    public Friend friend;
    private RequestsController controller;

    public void init(Friend friend, RequestsController controller){
        this.controller = controller;
        this.friend = friend;
        this.usernameLabel.setText(friend.getUsername());
    }

    public void declinedClicked(ActionEvent actionEvent) {
        friend.setState("declined");
        controller.init();
    }

    public void acceptClicked(ActionEvent actionEvent) {
        friend.setState("accepted");
        controller.init();
    }
}
