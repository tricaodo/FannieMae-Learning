package com.trido.springboot.services;

import com.trido.springboot.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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
        int idx = IntStream.range(0, users.size())
                .filter(i -> users.get(i).getId() == id)
                .findAny()
                .orElse(-1);
        return idx == -1 ? null : users.remove(idx);
    }

    /**
     * @param id         the user's id which we want to update.
     * @param updateUser the new user's information we want to update.
     */
    public boolean updateUser(int id, User updateUser) {
        return IntStream.range(0, users.size())
                .filter(i -> users.get(i).getId() == id)
                .anyMatch(i -> {
                    User currentUser = users.get(i);
                    currentUser.setName(updateUser.getName());
                    currentUser.setAge(updateUser.getAge());
                    return true;
                });
    }
}
