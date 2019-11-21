package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "AuthorizationToken")
public class AuthorizationToken {
    @DatabaseField(generatedId = true, unique = true)
    private Integer authorizationTokenId;

    @DatabaseField(foreign = true)
    private User user;

    @DatabaseField(unique = true)
    private String authorizationToken;

    public AuthorizationToken() {
    }

    public AuthorizationToken(final User user, final String authorizationToken) {
        this.user = user;
        this.authorizationToken = authorizationToken;
    }

    public Integer getAuthorizationTokenId() {
        return authorizationTokenId;
    }

    public User getUser() {
        return user;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }
}