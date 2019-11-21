package com.petadev.backend.service;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.AuthorizationToken;
import com.petadev.backend.entity.User;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

public class TokenService {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static Optional<User> getUserByToken(final String token) throws SQLException {
        Optional<AuthorizationToken> authorizationToken = DaoStore.getAuthorizationTokenDao().queryForEq("authorizationToken", token).stream().findFirst();

        Optional<User> userOptional = Optional.empty();

        if (authorizationToken.isPresent()) {
            final User user = DaoStore.getUserDao().queryForId(authorizationToken
                    .get()
                    .getUser()
                    .getUserID()
            );

            if (Objects.nonNull(user)) {
                userOptional = Optional.of(user);
            }
        }

        return userOptional;

    }

    public static boolean isTokenValid(final String token) throws SQLException {
        Optional<AuthorizationToken> authorizationToken = DaoStore.getAuthorizationTokenDao().queryForEq("authorizationToken", token).stream().findFirst();
        return authorizationToken.isPresent();
    }

    public static String authenticate(final User user) throws SQLException {
        String authToken = generateNewToken();

        var authorizationTokenDao = DaoStore.getAuthorizationTokenDao();
        AuthorizationToken authorizationToken = new AuthorizationToken(user, authToken);

        authorizationTokenDao.create(authorizationToken);

        return authToken;
    }

    private static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}