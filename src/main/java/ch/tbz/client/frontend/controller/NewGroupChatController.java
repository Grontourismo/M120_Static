package ch.tbz.client.frontend.controller;

import ch.tbz.client.Data;
import ch.tbz.client.Main;
import ch.tbz.client.backend.data.Group;
import ch.tbz.client.backend.data.Message;
import ch.tbz.client.backend.data.Person;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class NewGroupChatController extends ControllerBase {
    public TextField name;

    public void createClicked(ActionEvent actionEvent) {
        ArrayList<Group> groups = Data.user.getGroups();
        groups.add(new Group(groups.size(), name.getText(), 0, new ArrayList<Person>(), new ArrayList<Message>()));
        Data.user.setGroups(groups);
        new Main().load();
    }
}
