package com.petadev.backend.service;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Objects;

public final class AuthenticationService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);

    public static Student exists(final String username, final String password) throws SQLException {
        var studentQueryBuilder = DaoStore.getStudentDao().queryBuilder();

        Student student = studentQueryBuilder.where()
                .eq("userName", username)
                .queryForFirst();

        if (Objects.nonNull(student)) {
            boolean checkPassword = BCrypt.checkpw(password, student.getPasswordHash());
            return checkPassword ? student : null;
        }

        return student;
    }

}
