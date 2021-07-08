package ch.tbz.client;

import ch.tbz.client.backend.data.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

@Getter
public class Data {
    public static ArrayList<Friend> friends = new ArrayList<Friend>();
    public static ArrayList<Group> groups = new ArrayList<Group>();
    public static User user;

    public static void init(String username){
        user = new User(1, username, true);
        setFriends();

        setGroups(friends.get(0), friends.get(1), friends.get(2), friends.get(3));

        user.setFriends(friends);
        user.setGroups(groups);
    }

    private static void setFriends() {
        Friend friend1 = new Friend(2, "Noel_GHG", false, "accepted", 0);
        ArrayList<Message> messagesFriend1 = new ArrayList<Message>();
        messagesFriend1.add(new Message(1, "Hoi, chunnsch go Valorant spiele???", user, LocalDateTime.now().minusHours(26)));
        messagesFriend1.add(new Message(2, "???", user, LocalDateTime.now().minusHours(26).minusMinutes(40)));
        messagesFriend1.add(new Message(3, "Ja, chum i 5min", friend1, LocalDateTime.now().minusHours(26).minusMinutes(40)));
        messagesFriend1.add(new Message(4, "ezi", user, LocalDateTime.now().minusHours(26).minusMinutes(40)));
        messagesFriend1.add(new Message(5, "Chumm On", user, LocalDateTime.now().minusMinutes(1)));
        friend1.setMessages(messagesFriend1);

        Friend friend2 = new Friend(3, "CR1N993R", true, "accepted", 1);
        ArrayList<Message> messagesFriend2 = new ArrayList<Message>();
        messagesFriend2.add(new Message(6, "Hello, mir mönd denn no euses Projekt fertig mache gell!!", user, LocalDateTime.now().minusHours(72).minusMinutes(46)));
        messagesFriend2.add(new Message(7, "Bock uf Minecraft?", friend2, LocalDateTime.now().minusHours(24).minusMinutes(38)));
        messagesFriend2.add(new Message(8, "Jo, ezi", user, LocalDateTime.now().minusHours(24).minusMinutes(35)));
        messagesFriend2.add(new Message(9, "Chunnsch on?", friend2, LocalDateTime.now().minusMinutes(3)));
        friend2.setMessages(messagesFriend2);

        Friend friend3 = new Friend(4, "Xediri", true, "received", 0);
        Friend friend4 = new Friend(5, "Laser126", false, "received", 0);
        Friend friend5 = new Friend(6, "Schimmelpilz99", true, "received", 0);

        Collections.addAll(friends, friend1, friend2, friend3, friend4, friend5);
    }

    private static void setGroups(Friend friend1, Friend friend2, Friend friend3, Friend friend4) {
        ArrayList<Message> messagesGroup1 = new ArrayList<>();
        messagesGroup1.add(new Message(10, "Das isch en neue Server für csgo ;D", friend1, LocalDateTime.now().minusHours(5).minusMinutes(46)));
        messagesGroup1.add(new Message(11, "Het epper bock uf cs?", friend1, LocalDateTime.now().minusMinutes(4)));
        messagesGroup1.add(new Message(12, "Jo", friend2, LocalDateTime.now().minusMinutes(1)));
        messagesGroup1.add(new Message(13, "Ezi, chumm call", friend1, LocalDateTime.now().minusMinutes(1)));
        ArrayList<Person> usersGroup1 = new ArrayList<>();
        usersGroup1.add(friend1);
        usersGroup1.add(friend2);
        usersGroup1.add(user);
        Group group1 = new Group(0, "Biotonne", 3, usersGroup1, messagesGroup1);

        ArrayList<Message> messagesGroup2 = new ArrayList<>();
        messagesGroup2.add(new Message(10, "Was lauft so?", friend3, LocalDateTime.now().minusHours(5).minusMinutes(46)));
        messagesGroup2.add(new Message(11, "nöd viel, muss lerne", friend1, LocalDateTime.now().minusMinutes(4)));
        messagesGroup2.add(new Message(12, "same here, muss no das Projekt fertig mache", friend2, LocalDateTime.now().minusMinutes(1)));
        messagesGroup2.add(new Message(13, "hahaha, bin scho fertig xD", user, LocalDateTime.now().minusMinutes(1)));
        messagesGroup2.add(new Message(13, "ehrenlos", friend1, LocalDateTime.now().minusMinutes(1)));
        messagesGroup2.add(new Message(13, "haha, same. Bin ja mit ihm im Team", friend4, LocalDateTime.now().minusMinutes(1)));
        ArrayList<Person> usersGroup2 = new ArrayList<>();
        usersGroup2.add(friend1);
        usersGroup2.add(friend2);
        usersGroup2.add(friend3);
        usersGroup2.add(friend4);
        usersGroup2.add(user);
        usersGroup2.add(new Friend(7, "Miki", true, "declined", 0));
        Group group2 = new Group(1, "CoronaServer", 0, usersGroup2, messagesGroup2);

        Collections.addAll(groups, group1, group2);
    }
}
