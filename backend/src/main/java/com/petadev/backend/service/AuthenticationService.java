package com.petadev.backend.service;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Objects;

public final class AuthenticationService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);

    public static User exists(final String username, final String password) throws SQLException {
        var userQueryBuilder = DaoStore.getUserDao().queryBuilder();

        User user = userQueryBuilder.where()
                .eq("userName", username)
                .queryForFirst();

        if (Objects.nonNull(user)) {
            boolean checkPassword = BCrypt.checkpw(password, user.getPasswordHash());
            return checkPassword ? user : null;
        }

        return user;
    }

}