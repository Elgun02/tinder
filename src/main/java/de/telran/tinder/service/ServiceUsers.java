package de.telran.tinder.service;

import de.telran.tinder.interfaces.UserService;
import de.telran.tinder.model.User;
import de.telran.tinder.repository.RepositoryUsers;
import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Getter
@Primary

@Service
public class ServiceUsers implements UserService {
    private final RepositoryUsers repositoryUsers;

    public ServiceUsers(RepositoryUsers repositoryUsers) {
        this.repositoryUsers = repositoryUsers;
    }

    @Override
    public List<User> getAllUsers() {
        return repositoryUsers.getAllUsers();
    }

    @Override
    public User getNextUser() {
        Random random = new Random();
        int randomUser = random.nextInt(repositoryUsers.getAllUsers().size());
        return repositoryUsers.getAllUsers().get(randomUser);
    }

    @Override
    public User getNextUserWithShortName() {
        List<User> users = repositoryUsers.getAllUsers();

        User userWithShortestName = users.get(0);

        for (User user : users) {
            if (user.getName().length() < userWithShortestName.getName().length()) {
                userWithShortestName = user;
            }
        }
        return userWithShortestName;
    }

    @Override
    public void regUser(User user) {
        repositoryUsers.getAllUsers().add(user);
    }

    @Override
    public void removeUser(long id) {
        repositoryUsers.getAllUsers().removeIf(user -> user.getId() == id);
    }
}
