package ch.tbz.client.frontend.controller._prefaps;

import ch.tbz.client.Data;
import ch.tbz.client.backend.data.Friend;
import ch.tbz.client.backend.data.Group;
import ch.tbz.client.backend.data.Person;
import ch.tbz.client.frontend.UIManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class GroupIconController {
    public Button serverButton;
    public Tooltip tooltip;
    public Menu menu;
    private Group group;

    public void init(Group group){
        this.group = group;
        serverButton.setText(this.group.getGroupName().substring(0, 1));
        tooltip.setText(this.group.getGroupName());

        for (Friend friend : Data.user.getFriends()){
            if (friend.getState().equals("accepted")) {
                MenuItem item = new MenuItem(friend.getUsername() + " | " + friend.getUserId());
                item.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ArrayList<Person> persons = group.getUsers();
                        persons.add(friend);
                        group.setUsers(persons);
                        UIManager.home(group);
                    }
                });
                menu.getItems().add(item);
            }
        }
    }

    public void clicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            UIManager.home(group);
        }
    }
}
