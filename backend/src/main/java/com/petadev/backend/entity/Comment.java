package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Comments")
public final class Comment {
    @DatabaseField(generatedId = true)
    private int commentId; // to-do: hianyzik a commentId getter.

    @DatabaseField(foreign = true)
    private Post post;

    @DatabaseField(foreign = true)
    private User user;

    @DatabaseField(canBeNull = false)
    private String commentBody;

    @DatabaseField(canBeNull = false)
    private Date dateCreated;

    public Comment() {
    }

    public Comment(final User user, final Post post, final String commentBody, final Date dateCreated) {
        this.user = user;
        this.commentBody = commentBody;
        this.dateCreated = dateCreated;
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public int getCommentId() {
        return commentId;
    }

    public User getUser() {
        return user;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
