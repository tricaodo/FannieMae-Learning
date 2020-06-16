package com.trido.springboot.models;

import com.trido.springboot.services.UserDaoService;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UserTest {
    private UserDaoService service;

    /**
     * @BeforeAll runs before the object has even been created.
     */
    @BeforeAll
    static void runBeforeInit(){
        System.out.println("This runs before init()");
    }

    @BeforeEach
    void init(){
        service = new UserDaoService();
    }

    @AfterEach
    void afterEach(){
        System.out.println("Cleaning up each time...");
    }

    @Test
    void getId() {
        User user = new User(12, "John", 33);
        assertEquals(12, user.getId(), "getId() is failed");
    }

    @Test
    void getUserById() {
        User expected = service.getUserById(5);
        User actual = null;
        List<User> users = service.getUsers();
        for(User user: users){
            if(user.getId() == 5) actual = user;
        }
        assertEquals(expected, actual);
    }

    @Test
    void addUser(){
        int expected = service.getUsers().size() + 1;
        User user = new User();
        user.setName("Jenny");
        user.setAge(18);
        service.getUsers().add(user);
        int actual = service.getUsers().size();
        assertEquals(expected, actual, "addUser() is failed");
    }

    @Test
    void updateUser(){

    }

    @Test
    @DisplayName("Should not run this one...")
    @Disabled
    void failed(){
        fail("Please disable this method!!!");
    }
}