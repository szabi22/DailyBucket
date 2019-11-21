package com.petadev.backend.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.table.TableUtils;
import com.petadev.backend.entity.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

import static com.petadev.backend.connection.ConnectionManager.getInstance;

// Rest Controller is needed in order for spring to pick up this class.
@RestController
public class ApplicationController {
    // We don't use System.out.println, we use this LOG variable
    // example: LOG.debug("Hello World") will log Hello World to the console.
    // See further usage in code.
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationController.class);

    // We don't need a map anymore, since we are going to store entries in the database
    // Dao = DataAccessObject
    // what's between the <> tags is called generics.
    private Dao<Application, Integer> applicationDao;

    // Constructor for the rest controller. Here we initialize the data that will be stored in memory by default
    // we add two Users, with two random ids.
    public ApplicationController() {
        try {
            // We have a global connection to the database
            // this is what we use to connect to the database
            final var connectionSource = getInstance().getConnectionSource();

            // this is just for the sake of the example. I first drop the table to remove every entry from it,
            // and the fill it up with arbitrary data.
            // this should be replaced with TableUtils.createTableIfNotExists()
            TableUtils.dropTable(connectionSource, Application.class, true);
            TableUtils.createTable(connectionSource, Application.class);

            // we initialize the Dao with the help of the built in command, using our connection
            this.applicationDao = DaoManager.createDao(connectionSource, Application.class);

            // we fill up the database with arbitrary data
            this.applicationDao.create(
                    new Application("seta",
                            "tamas")
            );
            this.applicationDao.create(
                    new Application(
                            "fozz",
                            "eazy"


                    )
            );

        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

    // Here we handle a GET request on the /students endpoint
    // We find all our stored students, and we return them
    @GetMapping("/application")
    List<Application> getAllApplications() throws SQLException {
        LOG.info("Returning all activities...");
        return this.applicationDao.queryForAll();
    }

    // Here we handle a POST request on the /students endpoint
    // We receive a student which we should insert in to the database.
    @PostMapping("/application")
    int createActivity(final @RequestBody Application application) throws SQLException {
        LOG.info("Creating application with name " + application.getApplicationName());
        return this.applicationDao.create(application);
    }

    // Here we handle a GET request on the /students/<someId> endpoint
    // where <someId> is an Integer. We try to find the user with set id and return it.
    // @RequestBody means that it will be stored in the Request Body, so not in the url
    // @PathVariable will mean it is stored in the URI.
    // ID is a path variable
    // example / s/1 is a valid get request
    @GetMapping("/applications/{id}")
    Application getApplicationById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Returning application with id " + id);
        return this.applicationDao.queryForId(id);
    }

    // Here we handle a PUT request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and replace it.
    // note @RequestBody and @PathVariable
    @PutMapping("/applications/{id}")
    int replaceApplicationById(final @RequestBody Application application, final @PathVariable Integer id) throws SQLException {
        UpdateBuilder<Application, Integer> updateBuilder = this.applicationDao.updateBuilder();
        // we want to update entries where studentId == id
        updateBuilder.where().eq("applicationId", id);
        // we update each column with the information received from the client

        updateBuilder.updateColumnValue("applicationName", application.getApplicationName());
        updateBuilder.updateColumnValue("package", application.getPackages());

        return updateBuilder.update();
    }

    // Here we handle a DELETE request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and delete it.
    // note @PathVariable
    @DeleteMapping("/applications/{id}")
    int deleteApplicationById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Deleting application with id " + id);
        DeleteBuilder<Application, Integer> deleteBuilder = this.applicationDao.deleteBuilder();
        // we want to delete each entry where studentId == id
        deleteBuilder.where().eq("applicationId", id);
        // we return the number of deleted users
        return deleteBuilder.delete();
    }
}
//peldaul itt