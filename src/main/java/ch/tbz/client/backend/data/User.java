package ch.tbz.client.backend.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class User extends Person {
    @Setter
    private ArrayList<Group> groups;
    @Setter
    private ArrayList<Friend> friends;

    public User(long userId, String username, ArrayList<Group> groups, ArrayList<Friend> friends, boolean online){
        super(userId, username, online);
        this.groups = groups;
        this.friends = friends;
    }

    public User(long userId, String username, boolean online){
        super(userId, username, online);
    }

    public void updateData(long userId, String username, ArrayList<Group> groups, ArrayList<Friend> friends, boolean online){
        this.userId = userId;
        this.username = username;
        this.groups = groups;
        this.friends = friends;
        this.online = online;
    }

}
