package com.petadev.backend.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.table.TableUtils;
import com.petadev.backend.Difficulty;
import com.petadev.backend.entity.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

import static com.petadev.backend.connection.ConnectionManager.getInstance;

// Rest Controller is needed in order for spring to pick up this class.
@RestController
public class ActivityController {
    // We don't use System.out.println, we use this LOG variable
    // example: LOG.debug("Hello World") will log Hello World to the console.
    // See further usage in code.
    private static final Logger LOG = LoggerFactory.getLogger(ActivityController.class);

    // We don't need a map anymore, since we are going to store entries in the database
    // Dao = DataAccessObject
    // what's between the <> tags is called generics.
    private Dao<Activity, Integer> activityDao;

    // Constructor for the rest controller. Here we initialize the data that will be stored in memory by default
    // we add two Users, with two random ids.
    public ActivityController() {
        try {
            // We have a global connection to the database
            // this is what we use to connect to the database
            final var connectionSource = getInstance().getConnectionSource();

            // this is just for the sake of the example. I first drop the table to remove every entry from it,
            // and the fill it up with arbitrary data.
            // this should be replaced with TableUtils.createTableIfNotExists()
            TableUtils.dropTable(connectionSource, Activity.class, true);
            TableUtils.createTable(connectionSource, Activity.class);

            // we initialize the Dao with the help of the built in command, using our connection
            this.activityDao = DaoManager.createDao(connectionSource, Activity.class);

            // we fill up the database with arbitrary data
            this.activityDao.create(
                    new Activity("seta",
                            Difficulty.HARD,
                            "menj el setalni",
                             15
                    )
            );

            this.activityDao.create(
                    new Activity(
                            "fozz",
                            Difficulty.EASY,
                            "mej es fozz",
                            10

                    )
            );

        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

    // Here we handle a GET request on the /students endpoint
    // We find all our stored students, and we return them
    @GetMapping("/activities")
    List<Activity> getAllActivities() throws SQLException {
        LOG.info("Returning all activities...");
        return this.activityDao.queryForAll();
    }

    // Here we handle a POST request on the /students endpoint
    // We receive a student which we should insert in to the database.
    @PostMapping("/activities")
    int createActivities(final @RequestBody Activity activity) throws SQLException {
        LOG.info("Creating activity with name " + activity.getActivityName());
        return this.activityDao.create(activity);
    }

    // Here we handle a GET request on the /students/<someId> endpoint
    // where <someId> is an Integer. We try to find the user with set id and return it.
    // @RequestBody means that it will be stored in the Request Body, so not in the url
    // @PathVariable will mean it is stored in the URI.
    // ID is a path variable
    // example /students/1 is a valid get request
    @GetMapping("/activities/{id}")
    Activity getActivityById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Returning activity with id " + id);
        return this.activityDao.queryForId(id);
    }

    // Here we handle a PUT request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and replace it.
    // note @RequestBody and @PathVariable
    @PutMapping("/activities/{id}")
    int replaceActivityById(final @RequestBody Activity activity, final @PathVariable Integer id) throws SQLException {
        UpdateBuilder<Activity, Integer> updateBuilder = this.activityDao.updateBuilder();
        // we want to update entries where studentId == id
        updateBuilder.where().eq("activityId", id);
        // we update each column with the information received from the client

        updateBuilder.updateColumnValue("activityName", activity.getActivityName());
        updateBuilder.updateColumnValue("difficultyLevel", activity.getDifficultyLevel());
        updateBuilder.updateColumnValue("description", activity.getDescription());
        updateBuilder.updateColumnValue("plusAppTime", activity.getPlusAppTime());

        return updateBuilder.update();
    }

    // Here we handle a DELETE request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and delete it.
    // note @PathVariable
    @DeleteMapping("/activities/{id}")
    int deleteActivityById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Deleting activity with id " + id);
        DeleteBuilder<Activity, Integer> deleteBuilder = this.activityDao.deleteBuilder();
        // we want to delete each entry where studentId == id
        deleteBuilder.where().eq("activityId", id);
        // we return the number of deleted users
        return deleteBuilder.delete();
    }
}
