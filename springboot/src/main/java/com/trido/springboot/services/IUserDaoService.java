package com.trido.springboot.services;

import com.trido.springboot.models.User;

import java.util.List;

public interface IUserDaoService {
    List<User> getUsers();

    User getUserById(int id);

    void addUser(User user);

    User deleteUser(int id);

    boolean updateUser(int id, User updateUser);
}
