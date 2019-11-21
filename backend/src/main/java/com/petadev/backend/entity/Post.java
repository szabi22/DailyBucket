package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Posts")
public final class Post {
    @DatabaseField(generatedId = true)
    private int postId;

    @DatabaseField(canBeNull = false, foreign = true)
    private User user;

    @DatabaseField(canBeNull = false)
    private Date createdAt;

    @DatabaseField(canBeNull = false)
    private String postBody;

    public Post() {
    }

    public Post(final User user, final Date createdAt, final String postBody) {
        this.user = user;
        this.createdAt = createdAt;
        this.postBody = postBody;
    }

    public int getPostId() {
        return postId;
    }

    public User getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPostBody() {
        return postBody;
    }
}
