package de.telran.tinder;

import de.telran.tinder.model.User;
import de.telran.tinder.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/show-next-user")
    public User showNewUser() {
        return userService.getNextUser();
    }

    @GetMapping(value = "/show-user-with-shortest-name")
    public User showUserWithShortestName() {
        return userService.getNextUserWithShortName();
    }

    @GetMapping(value = "/show-all-users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/reg-new-user")
    public void regNewUser(@RequestBody User user) {
        userService.regUser(user);
    }

    @DeleteMapping(value = "/remove-user/{id}")
    public void removeUser(@PathVariable long id) {
        userService.removeUser(id);
    }
}
