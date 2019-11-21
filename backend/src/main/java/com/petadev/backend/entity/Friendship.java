package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Friendships")
public final class Friendship {
    @DatabaseField(generatedId = true)
    private Integer friendshipId; // to-do: hianyzik a gettere a generatedId-nek.

    @DatabaseField(canBeNull = false, foreign = true)
    private User user1;

    @DatabaseField(canBeNull = false, foreign = true)
    private User user2;

    @DatabaseField
    private Date startedAt;

    // empty constructor needed by Spring
    public Friendship() {
    }

    public Friendship(final User user1, final User user2, Date startedAt) {
        this.user1 = user1;
        this.user2 = user2;
        this.startedAt = startedAt;
    }

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public Date getStartedAt() {
        return startedAt;
    }
}