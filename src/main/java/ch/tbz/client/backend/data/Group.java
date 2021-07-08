package ch.tbz.client.backend.data;

import ch.tbz.client.backend.interfaces.Chat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class Group implements Chat{
    private final long groupId;
    private final String groupName;
    private final int unreadMessages;
    @Setter
    private ArrayList<Person> users;
    @Setter
    private ArrayList<Message> messages;
}
