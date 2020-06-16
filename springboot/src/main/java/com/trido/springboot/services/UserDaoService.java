package com.trido.springboot.services;

import com.trido.springboot.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDaoService {
    private List<User> users = new ArrayList<>(List.of(
            new User(1, "John", 23),
            new User(2, "Kelly", 34),
            new User(3, "Terry", 27),
            new User(4, "Jessica", 25),
            new User(5, "Susan", 32),
            new User(6, "Tiffany", 42)
    ));
    private int countId = 6;

    /**
     * @return the entire list of users.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param id the user's id which we want to access.
     * @return the specific user's information.
     */
    public User getUserById(int id) {
        Optional<User> matchingUser = users.stream()
                .filter(user -> user.getId() == id).findFirst();
        return matchingUser.orElse(null);
    }

    /**
     * @param user the user we want to add.
     */
    public void addUser(User user) {
        user.setId(++countId);
        users.add(user);
    }

    /**
     * @param id the user's id which we want to delete.
     * @return {@code user} if any elements were removed.
     */
    public User deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.remove(i);
            }
        }
        return null;
    }

    /**
     * @param id         the user's id which we want to update.
     * @param updateUser the new user's information we want to update.
     */
    public boolean updateUser(int id, User updateUser) {
        boolean match = users.stream()
                .anyMatch(user -> user.getId() == id);
        if (!match) return false;
        users = users.stream()
                .peek(user -> {
                    if (user.getId() == id) {
                        user.setName(updateUser.getName());
                        user.setAge(updateUser.getAge());
                    }
                }).collect(Collectors.toList());
        return true;
    }
}
