package com.petadev.backend.controller.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.petadev.backend.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Objects;

import static com.petadev.backend.connection.ConnectionManager.getInstance;

public class DaoStore {
    private static final Logger LOG = LoggerFactory.getLogger(DaoStore.class);

    private static Dao<Student, Integer> studentDao;
    private static Dao<Comment, Integer> commentDao;
    private static Dao<Activity, Integer> activityDao;
    private static Dao<Post, Integer> postDao;
    private static Dao<User, Integer> userDao;
    private static Dao<Reaction, Integer> reactionDao;
    private static Dao<UserActivity, Integer> userActivityDao; // camel case ..
    private static Dao<FinishedUserActivity, Integer> finishedUserActivityDao;
    private static Dao<WIPUserActivity, Integer> wipUserActivityDao;
    private static Dao<Friendship, Integer> friendShipDao;
    private static Dao<FriendRequest, Integer> friendRequestDao;
    private static Dao<UserApplication, Integer> userApplicationDao;
    private static Dao<Application, Integer> applicationDao;
    private static Dao<AuthorizationToken,Integer>authorizationTokenDao;

    private static ConnectionSource connectionSource = getInstance().getConnectionSource();

    public static Dao<Student, Integer> getStudentDao() {
        if (Objects.isNull(studentDao)) {
            try {
                TableUtils.dropTable(connectionSource, Student.class, true);
                TableUtils.createTable(connectionSource, Student.class);
                studentDao = DaoManager.createDao(connectionSource, Student.class);
            } catch (SQLException e) {
                LOG.error("Error creating StudentDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return studentDao;
    }

    public static Dao<Comment, Integer> getCommentDao() {
        if (Objects.isNull(commentDao)) {
            try {
                TableUtils.dropTable(connectionSource, Comment.class, true);
                TableUtils.createTable(connectionSource, Comment.class);
                commentDao = DaoManager.createDao(connectionSource, Comment.class);
            } catch (SQLException e) {
                LOG.error("Error creating CommentDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return commentDao;
    }

    public static Dao<Post, Integer> getPostDao() {
        if (Objects.isNull(postDao)) {
            try {
                TableUtils.dropTable(connectionSource, Post.class, true);
                TableUtils.createTable(connectionSource, Post.class);
                postDao = DaoManager.createDao(connectionSource, Post.class);
            } catch (SQLException e) {
                LOG.error("Error creating PostDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return postDao;
    }

    public static Dao<Activity, Integer> getActivityDao() {
        if (Objects.isNull(activityDao)) {
            try {
                TableUtils.dropTable(connectionSource, Activity.class, true);
                TableUtils.createTable(connectionSource, Activity.class);
                activityDao = DaoManager.createDao(connectionSource, Activity.class);
            } catch (SQLException e) {
                LOG.error("Error creating activityDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return activityDao;
    }

    public static Dao<User, Integer> getUserDao() {
        if (Objects.isNull(userDao)) {
            try {
                TableUtils.dropTable(connectionSource, User.class, true);
                TableUtils.createTable(connectionSource, User.class);
                userDao = DaoManager.createDao(connectionSource, User.class);
            } catch (SQLException e) {
                LOG.error("Error creating userDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return userDao;
    }

    public static Dao<UserActivity, Integer> getUserActivityDao() {
        if (Objects.isNull(userActivityDao)) {
            try {
                TableUtils.dropTable(connectionSource, UserActivity.class, true);
                TableUtils.createTable(connectionSource, UserActivity.class);
                userActivityDao = DaoManager.createDao(connectionSource, UserActivity.class);
            } catch (SQLException e) {
                LOG.error("Error creating UserActivityDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return userActivityDao;
    }

    public static Dao<Reaction, Integer> getReactionDao() {
        if (Objects.isNull(reactionDao)) {
            try {
                TableUtils.dropTable(connectionSource, Reaction.class, true);
                TableUtils.createTable(connectionSource, Reaction.class);
                reactionDao = DaoManager.createDao(connectionSource, Reaction.class);
            } catch (SQLException e) {
                LOG.error("Error creating ReactionDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }
        return reactionDao;
    }


    public static Dao<FinishedUserActivity, Integer> getFinishedUserActivityDao() {
        if (Objects.isNull(finishedUserActivityDao)) {
            try {
                TableUtils.dropTable(connectionSource, FinishedUserActivity.class, true);
                TableUtils.createTable(connectionSource, FinishedUserActivity.class);
                finishedUserActivityDao = DaoManager.createDao(connectionSource, FinishedUserActivity.class);
            } catch (SQLException e) {
                LOG.error("Error creating FinishedUserActivityDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return finishedUserActivityDao;
    }

    public static Dao<WIPUserActivity, Integer> getWipUserActivityDao() {
        if (Objects.isNull(wipUserActivityDao)) {
            try {
                TableUtils.dropTable(connectionSource, WIPUserActivity.class, true);
                TableUtils.createTable(connectionSource, WIPUserActivity.class);
                wipUserActivityDao = DaoManager.createDao(connectionSource, WIPUserActivity.class);
            } catch (SQLException e) {
                LOG.error("Error creating WipUserActivityDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return wipUserActivityDao;
    }

    public static Dao<Friendship, Integer> getFriendShipDao() {
        if (Objects.isNull(friendShipDao)) {
            try {
                TableUtils.dropTable(connectionSource, Friendship.class, true);
                TableUtils.createTable(connectionSource, Friendship.class);
                friendShipDao = DaoManager.createDao(connectionSource, Friendship.class);
            } catch (SQLException e) {
                LOG.error("Error creating friendshipDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return friendShipDao;
    }

    public static Dao<FriendRequest, Integer> getFriendRequestDao() {
        if (Objects.isNull(friendRequestDao)) {
            try {
                TableUtils.dropTable(connectionSource, FriendRequest.class, true);
                TableUtils.createTable(connectionSource, FriendRequest.class);
                friendRequestDao = DaoManager.createDao(connectionSource, FriendRequest.class);
            } catch (SQLException e) {
                LOG.error("Error creating friendrequestDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return friendRequestDao;
    }

    public static Dao<UserApplication, Integer> getUserApplicationDao() {
        if (Objects.isNull(userApplicationDao)) {
            try {
                TableUtils.dropTable(connectionSource, UserApplication.class, true);
                TableUtils.createTable(connectionSource, UserApplication.class);
                userApplicationDao = DaoManager.createDao(connectionSource, UserApplication.class);
            } catch (SQLException e) {
                LOG.error("Error creating UserApplicationDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return userApplicationDao;
    }

    public static Dao<Application, Integer> getApplicationDao() {
        if (Objects.isNull(applicationDao)) {
            try {
                TableUtils.dropTable(connectionSource, Application.class, true);
                TableUtils.createTable(connectionSource, Application.class);
                applicationDao = DaoManager.createDao(connectionSource, Application.class);
            } catch (SQLException e) {
                LOG.error("Error creating UserApplicationDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return applicationDao;
    }

    public static Dao<AuthorizationToken, Integer> getAuthorizationTokenDao() {
        if (Objects.isNull(authorizationTokenDao)) {
            try {
                TableUtils.createTableIfNotExists(connectionSource, AuthorizationToken.class);
                authorizationTokenDao = DaoManager.createDao(connectionSource, AuthorizationToken.class);
            } catch (SQLException e) {
                LOG.error("Error creating AuthorizationTokenDao\n " + e.getMessage() + " " + e.getSQLState());
            }
        }

        return authorizationTokenDao;
    }
}


