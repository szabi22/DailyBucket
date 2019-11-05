package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "posts")
public class Post {
    @DatabaseField(generatedId = true)
    private int postId;

    @DatabaseField(canBeNull = false, foreign = true)
    private Student student;

    @DatabaseField(canBeNull = false)
    private Date createdAt;

    @DatabaseField(canBeNull = false)
    private String postBody;

    public Post() {
    }

    public Post(final Student student, final Date createdAt, final String postBody) {
        this.student = student;
        this.createdAt = createdAt;
        this.postBody = postBody;
    }

    public int getPostId() {
        return postId;
    }

    public Student getStudent() {
        return student;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPostBody() {
        return postBody;
    }
}
