package com.trido.springboot.services;

import com.trido.springboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    @Qualifier("fakeDAO")
    IUserDaoService userDAO;

    /**
     * @return the entire list of users.
     */
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    /**
     * @param id the user's id which we want to access.
     * @return the specific user's information.
     */

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    /**
     * @param user the user we want to add.
     */

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    /**
     * @param id the user's id which we want to delete.
     * @return {@code user} if any elements were removed.
     */
    public User deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    /**
     * @param id         the user's id which we want to update.
     * @param updateUser the new user's information we want to update.
     */
    public boolean updateUser(int id, User updateUser) {
        return userDAO.updateUser(id, updateUser);
    }
}
