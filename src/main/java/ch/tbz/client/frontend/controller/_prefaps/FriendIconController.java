package ch.tbz.client.frontend.controller._prefaps;

import ch.tbz.client.Data;
import ch.tbz.client.backend.data.*;
import ch.tbz.client.frontend.UIManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FriendIconController {
    public Label usernameLabel;
    public Tooltip usernameTooltip;
    public Circle statusCircle;
    public Label newMassageCount;
    public Friend friend;
    public Menu menu;
    public Menu menu1;
    public Menu menu2;

    public void init(Friend friend){
        this.friend = friend;
        this.usernameLabel.setText(this.friend.getUsername());
        this.usernameTooltip.setText(this.friend.getUsername());
        this.newMassageCount.setText(this.friend.getUnreadMessages() != 0 ? this.friend.getUnreadMessages() + "" : "");
        this.statusCircle.setFill(this.friend.isOnline() ? Color.GREEN : Paint.valueOf("#8F979F"));

        for (Group group : Data.user.getGroups()){
            MenuItem item = new MenuItem(group.getGroupName());
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


            MenuItem item1 = new MenuItem(group.getGroupName());
            item1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ArrayList<Person> persons = group.getUsers();
                    persons.add(friend);
                    group.setUsers(persons);
                    UIManager.home(group);
                }
            });
            menu1.getItems().add(item1);


            MenuItem item2 = new MenuItem(group.getGroupName());
            item2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ArrayList<Person> persons = group.getUsers();
                    persons.add(friend);
                    group.setUsers(persons);
                    UIManager.home(group);
                }
            });
            menu2.getItems().add(item2);
        }
    }

    public void setNewMassageCount(String text){
        this.newMassageCount.setText(text);
    }

    public void setStatusCircleON(){
        this.statusCircle.setFill(Color.GREEN);
    }

    public void setStatusCircleOFF(){
        this.statusCircle.setFill(Paint.valueOf("#8F979F"));
    }

    public void iconClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            friend.setUnreadMessages(0);
            UIManager.home(friend);
        }
    }
}
