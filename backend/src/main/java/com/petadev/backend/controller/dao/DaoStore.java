package com.petadev.backend.controller.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.petadev.backend.controller.StudentController;
import com.petadev.backend.entity.AuthorizationToken;
import com.petadev.backend.entity.Comment;
import com.petadev.backend.entity.Post;
import com.petadev.backend.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Objects;

import static com.petadev.backend.connection.ConnectionManager.getInstance;

public class DaoStore {
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
    private static Dao<Student, Integer> studentDao;
    private static Dao<Comment, Integer> commentDao;
    private static Dao<Post, Integer> postDao;
    private static Dao<AuthorizationToken, Integer> authorizationTokenDao;
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
