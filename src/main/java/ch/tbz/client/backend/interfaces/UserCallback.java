package ch.tbz.client.backend.interfaces;

import ch.tbz.client.backend.data.Person;

public interface UserCallback {
    void sendPersons(Person person);
}
