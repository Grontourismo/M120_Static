package ch.tbz.client.frontend.controller._prefaps;

import ch.tbz.client.Data;
import ch.tbz.client.backend.data.Friend;
import ch.tbz.client.backend.data.Group;
import ch.tbz.client.backend.data.Message;
import ch.tbz.client.backend.interfaces.Chat;
import ch.tbz.client.frontend.UIManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatController {
    public VBox vboxMessages;
    public TextField messageTb;
    public ArrayList<Message> messages;
    public Friend friend;
    public Group group;
    public String type;

    public void init(Chat chatMessages){
        this.messages = chatMessages.getMessages();
        if (chatMessages instanceof Friend){
            type = "friend";
            this.friend = (Friend) chatMessages;
        }else {
            type = "group";
            this.group = (Group) chatMessages;
        }

        vboxMessages.getChildren().clear();
        if (messages != null) {
            for (Message message : messages) {
                try {
                    FXMLLoader loader = new FXMLLoader(MessageController.class.getClassLoader().getResource("views/_prefaps/message.fxml"));
                    Parent root = loader.load();
                    MessageController controller = loader.getController();
                    controller.init(message);
                    vboxMessages.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void sendClicked(ActionEvent actionEvent) {
        String text = this.messageTb.getText();
        text = text.replace("/shrug", "¯\\_(ツ)_/¯").replace("/tableflip", "(╯°□°）╯︵ ┻━┻").replace("/unflip", "┬─┬ ノ( ゜-゜ノ)");
        switch (type){
            case "group":
                ArrayList<Message> messages = this.group.getMessages();
                messages.add(new Message(messages.size(), this.messageTb.getText(), Data.user, LocalDateTime.now()));
                this.group.setMessages(messages);
                UIManager.home(group);
                break;
            case "friend":
                ArrayList<Message> messages2 = this.friend.getMessages();
                messages2.add(new Message(messages2.size(), this.messageTb.getText(), Data.user, LocalDateTime.now()));
                this.friend.setMessages(messages2);
                UIManager.home(friend);
                break;
        }
    }
}
