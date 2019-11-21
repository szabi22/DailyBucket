package com.petadev.backend.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "FriendRequests")
public final class FriendRequest {

    @DatabaseField(generatedId = true)
    private Integer friendRequestId;

    @DatabaseField(canBeNull = false, foreign = true)
    private User fromUser;

    @DatabaseField(canBeNull = false, foreign = true)
    private User toUser;

    @DatabaseField
    private Date sentAt;

    // empty constructor needed by Spring
    public FriendRequest() {
    }

    public FriendRequest(final User fromUser, final User toUser, Date sentAt) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.sentAt = sentAt;
    }

    public Integer getFriendRequestId() {
        return friendRequestId;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public Date getSentAt() {
        return sentAt;
    }
}