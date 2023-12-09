package de.telran.tinder.repository;

import de.telran.tinder.model.User;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode

@Repository
public class RepositoryUsers {
    private final List<User> users;

    public RepositoryUsers() {
        this.users = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return users;
    }
}
