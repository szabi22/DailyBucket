package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "AuthorizationToken")
public class AuthorizationToken {
    @DatabaseField(generatedId = true, unique = true)
    private Integer authorizationTokenId;

    @DatabaseField(foreign = true)
    private Student student;

    @DatabaseField(unique = true)
    private String authorizationToken;

    public AuthorizationToken() {
    }

    public AuthorizationToken(final Student student, final String authorizationToken) {
        this.student = student;
        this.authorizationToken = authorizationToken;
    }

    public Integer getAuthorizationTokenId() {
        return authorizationTokenId;
    }

    public Student getStudent() {
        return student;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }
}
