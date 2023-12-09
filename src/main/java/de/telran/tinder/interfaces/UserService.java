package de.telran.tinder.interfaces;

import de.telran.tinder.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getNextUser();
    User getNextUserWithShortName();
    void regUser(User user);
    void removeUser(long id);
}
