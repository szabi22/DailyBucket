package com.petadev.backend.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

// Rest Controller is needed in order for spring to pick up this class.
@RestController
public class UserController {
    // We don't use System.out.println, we use this LOG variable
    // example: LOG.debug("Hello World") will log Hello World to the console.
    // See further usage in code.
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    // We don't need a map anymore, since we are going to store entries in the database
    // Dao = DataAccessObject
    // what's between the <> tags is called generics.
    private Dao<User, Integer> userDao = DaoStore.getUserDao();

    // Constructor for the rest controller. Here we initialize the data that will be stored in memory by default
    // we add two Users, with two random ids.
    public UserController() {
    }

    // Here we handle a GET request on the /students endpoint
    // We find all our stored students, and we return them
    @GetMapping("/users")
    List<User> getAllUsers() throws SQLException {
        LOG.info("Returning all users...");
        return this.userDao.queryForAll();
    }

    // Here we handle a POST request on the /students endpoint
    // We receive a student which we should insert in to the database.
    @PostMapping("/users")
    int createUsers(final @RequestBody User User) throws SQLException {
        LOG.info("Creating User with name " + User.getLastName());
        return this.userDao.create(User);
    }

    // Here we handle a GET request on the /students/<someId> endpoint
    // where <someId> is an Integer. We try to find the user with set id and return it.
    // @RequestBody means that it will be stored in the Request Body, so not in the url
    // @PathVariable will mean it is stored in the URI.
    // ID is a path variable
    // example /students/1 is a valid get request
    @GetMapping("/users/{id}")
    User getUserById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Returning user with id " + id);
        return this.userDao.queryForId(id);
    }

    // Here we handle a PUT request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and replace it.
    // note @RequestBody and @PathVariable
    @PutMapping("/users/{id}")
    int replaceUserById(final @RequestBody User user, final @PathVariable Integer id) throws SQLException {
        UpdateBuilder<User, Integer> updateBuilder = this.userDao.updateBuilder();
        // we want to update entries where studentId == id
        updateBuilder.where().eq("userId", id);
        // we update each column with the information received from the client

        updateBuilder.updateColumnValue("firstName", user.getFirstName());
        updateBuilder.updateColumnValue("lastName", user.getLastName());
        updateBuilder.updateColumnValue("birthDate", user.getBirthDate());
        updateBuilder.updateColumnValue("userName", user.getUserName());
        updateBuilder.updateColumnValue("userName", user.getAppTime());
        updateBuilder.updateColumnValue("passwordHashName", user.getPasswordHash());
        updateBuilder.updateColumnValue("userName", user.getRegisterDate());
        return updateBuilder.update();
    }

    // Here we handle a DELETE request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and delete it.
    // note @PathVariable
    @DeleteMapping("/users/{id}")
    int deleteUserById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Deleting user with id " + id);
        DeleteBuilder<User, Integer> deleteBuilder = this.userDao.deleteBuilder();
        // we want to delete each entry where studentId == id
        deleteBuilder.where().eq("userId", id);
        // we return the number of deleted users
        return deleteBuilder.delete();
    }
}
