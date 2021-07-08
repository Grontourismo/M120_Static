package ch.tbz.client.backend.data;

import ch.tbz.client.backend.interfaces.Chat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Friend extends Person implements Chat {
    @Setter
    private String state; //accepted, send, received
    @Setter
    private ArrayList<Message> messages;
    @Setter
    private int unreadMessages;

    public Friend(int userId, String name, String state, ArrayList<Message> messages, int unreadMessages, boolean online){
        super(userId, name, online);
        this.state = state;
        this.messages = messages;
        this.unreadMessages = unreadMessages;
    }

    public Friend(int userId, String name, boolean online, String state, int unreadMessages){
        super(userId, name, online);
        this.state = state;
        this.unreadMessages = unreadMessages;
    }


    public String getState() {
        return state;
    }

}
