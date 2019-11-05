package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "comments")
public class Comment {
    @DatabaseField(generatedId = true)
    private int commentId;

    @DatabaseField(foreign = true)
    private Post post;

    @DatabaseField(foreign = true)
    private Student student;

    @DatabaseField(canBeNull = false)
    private String commentBody;

    @DatabaseField(canBeNull = false)
    private Date dateCreated;

    public Comment() {
    }

    public Comment(final Student student, final Post post, final String commentBody, final Date dateCreated) {
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
