package com.petadev.backend.service;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.AuthorizationToken;
import com.petadev.backend.entity.Student;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

public class TokenService {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static Optional<Student> getStudentByToken(final String token) throws SQLException {
        Optional<AuthorizationToken> authorizationToken = DaoStore.getAuthorizationTokenDao().queryForEq("authorizationToken", token).stream().findFirst();

        Optional<Student> studentOptional = Optional.empty();

        if (authorizationToken.isPresent()) {
            final Student student = DaoStore.getStudentDao().queryForId(authorizationToken
                    .get()
                    .getStudent()
                    .getStudentId()
            );

            if (Objects.nonNull(student)) {
                studentOptional = Optional.of(student);
            }
        }

        return studentOptional;
    }

    public static boolean isTokenValid(final String token) throws SQLException {
        Optional<AuthorizationToken> authorizationToken = DaoStore.getAuthorizationTokenDao().queryForEq("authorizationToken", token).stream().findFirst();
        return authorizationToken.isPresent();
    }

    public static String authenticate(final Student student) throws SQLException {
        String authToken = generateNewToken();

        var authorizationTokenDao = DaoStore.getAuthorizationTokenDao();
        AuthorizationToken authorizationToken = new AuthorizationToken(student, authToken);

        authorizationTokenDao.create(authorizationToken);

        return authToken;
    }

    private static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
